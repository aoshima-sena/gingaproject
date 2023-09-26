package jp.co.ginga.web.application.controller.facility.confirm;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.ginga.web.application.controller.facility.add.FacilityAddForm;
import jp.co.ginga.web.application.controller.facility.detail.FacilityDetailForm;
import jp.co.ginga.web.application.util.session.facility.FacilitySession;
import jp.co.ginga.web.domain.service.facility.FacilityManagerDto;
import jp.co.ginga.web.domain.service.facility.FacilityManagerService;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerService;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import lombok.Data;

@Controller
@Data
public class FacilityConfirmController {

	@Autowired
	MessageSource msg;
	@Autowired
	FacilitySession facilitySession;

	@Autowired

	FacilityConfirmHelper facilityConfirmHelper;
	@Autowired
	FacilityManagerService facilityService;
	@Autowired
	FacilityTypeManagerService facilityTypeService;

	@PostMapping(path = "/facility/confirm", params = "add")
	public String postFacilityConfirmAdd(@ModelAttribute @Validated FacilityAddForm inputForm, BindingResult result,
			RedirectAttributes ra, Model model) {

		boolean errFlag = false;

		facilitySession.setFacilityForm(inputForm.getFacilityForm());

		if (result.hasErrors()) {
			errFlag = true;
		}

		FacilityManagerDto dto = facilityService.getFacilityByName(inputForm.getFacilityForm().getName());

		//		FacilityManagerDto facilityManagerDto = facilityService.getFacilityByName(dto.getFacilityDto().getName());

		if (dto.getFacilityDtoList().size() != 0) {
			result.rejectValue("facilityForm.name", null,
					msg.getMessage("Facility.duplicate", null, Locale.getDefault()));
			errFlag = true;
		}

		FacilityConfirmForm facilityConfirmForm = facilityConfirmHelper.createFacilityConfirmForm(facilitySession);

		facilityConfirmForm.setBtnName(msg.getMessage("label.add", null, Locale.getDefault()));

		facilityConfirmForm.setBtnAction(msg.getMessage("action.add", null, Locale.getDefault()));

		if (errFlag == true) {
			ra.addFlashAttribute("errors", result);
			return "redirect:/facility/add";
		}
		model.addAttribute("facilityConfirmForm", facilityConfirmForm);
		return "facility/facility-confirm";
	}
	//	@PostMapping(path = "/facility/confirm", params = "add")
	//	public "facility/facility-confirm" postFacilityConfirmUpdate(@ModelAttribute @Validated FacilityDetailForm inputForm,BindingResult result,RedirectAttributes ra,Model model) {

	//	}

	@PostMapping(path = "/facility/confirm", params = "update")
	public String postFacilityConfirmUpdate(@ModelAttribute @Validated FacilityDetailForm inputForm,
			BindingResult result, RedirectAttributes ra,
			Model model) {
		//エラーになったらtrue
		boolean errFlag = false;

		//データが変更されていたらtrue
		boolean errFlags = false;
		//validatorのエラーが入ったエラー
		if (result.hasErrors()) {
			errFlag = true;
		}
		//何も変更されてないかどうかチェック
		int checkValue = facilityConfirmHelper.checkUpdated(inputForm, facilitySession.getBeforeFacilityForm());

		switch (checkValue) {

		case FacilityConfirmHelper.NAME_UPDATED:
			errFlags = true;
			break;
		case FacilityConfirmHelper.NAME_UPDATED + FacilityConfirmHelper.FACILITY_TYPE_UPDATED:
			errFlags = true;
			break;
		case FacilityConfirmHelper.NAME_UPDATED + FacilityConfirmHelper.CAPACITY_UPDATED:
			errFlags = true;
			break;
		case FacilityConfirmHelper.NAME_UPDATED + FacilityConfirmHelper.FACILITY_TYPE_UPDATED
				+ FacilityConfirmHelper.CAPACITY_UPDATED:
			errFlags = true;

			break;

		case FacilityConfirmHelper.NO_UPDATE:
			//522
			result.rejectValue("sysMsg", null, msg.getMessage("Facility.notChange", null, Locale.getDefault()));
			//523
			errFlag = true;
			break;
		default:
			break;

		}
		//6
		if (errFlags == true) {
			FacilityManagerDto facilityManagerDto = facilityService
					.getFacilityByName(inputForm.getFacilityForm().getName());

			if (facilityManagerDto.getFacilityDtoList().size() != 0) {
				result.rejectValue("facilityForm.name", null,
						msg.getMessage("Facility.duplicate", null, Locale.getDefault()));
				errFlag = true;

			}
		}
		if (errFlag == true) {
			ra.addFlashAttribute("errors", result);
			return "redirect:/facility/detail/" + facilitySession.getFacilityForm().getFacilityId();
		}

		facilitySession.getFacilityForm().setName(inputForm.getFacilityForm().getName());
		facilitySession.getFacilityForm().setCapacity(inputForm.getFacilityForm().getCapacity());
		facilitySession.getFacilityForm().getFacilityTypeForm()
				.setFacilityTypeId(inputForm.getFacilityForm().getFacilityTypeForm().getFacilityTypeId());

		FacilityConfirmForm facilityConfirmForm = facilityConfirmHelper.createFacilityConfirmForm(facilitySession);

		facilityConfirmForm.setBtnName(msg.getMessage("label.update", null, Locale.getDefault()));
		facilityConfirmForm.setBtnAction(msg.getMessage("action.update", null, Locale.getDefault()));

		model.addAttribute("facilityConfirmForm", facilityConfirmForm);

		return "facility/facility-confirm";

	}

	@PostMapping(path = "/facility/confirm", params = "delete")
	public String postFacilityComfirmDelete(@ModelAttribute @Validated FacilityDetailForm inputForm,
			BindingResult result, RedirectAttributes ra, Model model) {
		FacilityManagerDto facilityManagerDto = facilityService
				.getFacilityDetailByFacilityId(facilitySession.getFacilityForm().getFacilityId());

		FacilityTypeDto facilityTypeDto = facilityTypeService
				.getFacilityTypeDto(facilitySession.getFacilityForm().getFacilityTypeForm().getFacilityTypeId());

		facilityManagerDto.setFacilityTypeDto(facilityTypeDto);

		int form = facilityConfirmHelper.checkedUpdated(facilityManagerDto, facilitySession.getBeforeFacilityForm());

		boolean errFlag = false;

		if (form != FacilityConfirmHelper.NO_UPDATE) {

			result.rejectValue("sysMsg", null, msg.getMessage("Facility.optimistic", null, Locale.getDefault()));

			errFlag = true;

		}

		if (errFlag == true) {
			ra.addFlashAttribute("errors", result);

			return "redirect:/facility/detail/" + (facilitySession.getFacilityForm().getFacilityId());
		}

		FacilityConfirmForm facilityConfirmForm = facilityConfirmHelper.createFacilityConfirmForm(facilityManagerDto);

		facilityConfirmForm.setBtnName(msg.getMessage("label.delete", null, Locale.getDefault()));

		facilityConfirmForm.setBtnAction(msg.getMessage("action.delete", null, Locale.getDefault()));

		facilitySession.getFacilityForm().setName(facilityConfirmForm.getFacilityForm().getName());

		facilitySession.getFacilityForm().setCapacity(facilityConfirmForm.getFacilityForm().getCapacity());

		facilitySession.getFacilityForm().getFacilityTypeForm()
				.setFacilityTypeId(facilityConfirmForm.getFacilityForm().getFacilityTypeForm().getFacilityTypeId());

		model.addAttribute("facilityConfirmForm", facilityConfirmForm);

		return "facility/facility-confirm";
	}
}