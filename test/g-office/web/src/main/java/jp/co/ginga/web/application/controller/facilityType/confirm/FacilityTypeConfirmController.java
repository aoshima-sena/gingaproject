package jp.co.ginga.web.application.controller.facilityType.confirm;

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

import jp.co.ginga.web.application.controller.facilityType.add.FacilityTypeAddForm;
import jp.co.ginga.web.application.controller.facilityType.detail.FacilityTypeDetailForm;
import jp.co.ginga.web.application.util.session.facilityType.FacilityTypeSession;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerDto;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerService;

@Controller

public class FacilityTypeConfirmController {

	@Autowired
	MessageSource msg;
	@Autowired
	FacilityTypeSession facilityTypeSession;
	@Autowired
	FacilityTypeConfirmHelper facilityTypeConfirmHelper;

	@Autowired
	FacilityTypeManagerService facilityTypeService;

	//add登録確認処理
	@PostMapping(path = "/facilitytype/confirm", params = "add")
	public String postFacilityTypeConfirmAdd(@ModelAttribute @Validated FacilityTypeAddForm inputForm,
			BindingResult result, RedirectAttributes ra, Model model) {
		boolean errFlag = false;

		facilityTypeSession.setFacilityTypeForm(inputForm.getFacilityTypeForm());
		if (result.hasErrors()) {
			errFlag = true;
		}

		//	FacilityTypeManagerDto facilityTypeManagerDto = facilityTypeConfirmHelper
		//  .createFacilityTypeManagerServiceDto(inputForm);

		FacilityTypeManagerDto dto = facilityTypeService
				.getFacilityTypeByName(inputForm.getFacilityTypeForm().getName());

		//	facilityTypeManagerDto = facilityTypeService.getFacilityTypeByName(inputForm.getFacilityTypeForm());

		if (dto.getFacilityTypeDtoList().size() != 0) {
			result.rejectValue("facilityTypeForm.name", null,
					msg.getMessage("FacilityType.duplicate", null, Locale.getDefault()));
			errFlag = true;
		}

		FacilityTypeConfirmForm facilityTypeConfirmForm = facilityTypeConfirmHelper
				.createFacilityTypeConfirmForm(facilityTypeSession);

		facilityTypeConfirmForm.setBtnName(msg.getMessage("label.add", null, Locale.getDefault()));
		facilityTypeConfirmForm.setBtnAction(msg.getMessage("action.add", null, Locale.getDefault()));
		if (errFlag == true) {
			ra.addFlashAttribute("errors", result);
			return "redirect:/facilitytype/add";
		}
		model.addAttribute("facilityTypeConfirm", facilityTypeConfirmForm);
		return "facilityType/facilityType-confirm";

	}

	//update更新確認処理
	@PostMapping(path = "/facilitytype/confirm", params = "update")
	public String postFacilityTypeConfirmUpdate(@ModelAttribute @Validated FacilityTypeDetailForm inputForm,
			BindingResult result, RedirectAttributes ra, Model model) {

		boolean errorFlag1 = false;

		boolean error2 = false;

		if (result.hasErrors()) {
			errorFlag1 = true;

		}

		int value = facilityTypeConfirmHelper.checkUpdated(inputForm, facilityTypeSession.getBeforeFacilityTypeForm());

		switch (value) {

		case FacilityTypeConfirmHelper.NAME_UPDATED:
			error2 = true;
			break;
		case FacilityTypeConfirmHelper.NO_UPDATE:
			result.rejectValue("sysMsg", null, msg.getMessage("Facility.notChange", null, Locale.getDefault()));
			errorFlag1 = true;
			break;
		default:
			break;
		}

		//	FacilityTypeManagerDto facilityTypeManagerDto = facilityTypeConfirmHelper
		// .getFacilityTypeManagerSericeDto(inputForm);
		if (error2 == true) {
			FacilityTypeManagerDto facilityTypeManagerDto = facilityTypeService
					.getFacilityTypeByName(inputForm.getFacilityTypeForm().getName());
			if (facilityTypeManagerDto.getFacilityTypeDtoList().size() != 0) {
				result.rejectValue("facilityTypeForm.name", null,
						msg.getMessage("FacilityType.duplicate", null, Locale.getDefault()));
				errorFlag1 = true;
			}
		}
		if (errorFlag1 == true) {
			ra.addFlashAttribute("errors", result);
			//戻ったときにURLにIDが末尾につくようにする
			return "redirect:/facilitytype/detail/" + (facilityTypeSession.getFacilityTypeForm().getFacilityTypeId());
		}

		facilityTypeSession.getFacilityTypeForm().setName(inputForm.getFacilityTypeForm().getName());

		FacilityTypeConfirmForm facilityTypeConfirmForm = facilityTypeConfirmHelper
				.createFacilityTypeConfirmForm(facilityTypeSession);
		facilityTypeConfirmForm.setBtnName(msg.getMessage("label.update", null, Locale.getDefault()));
		facilityTypeConfirmForm.setBtnAction(msg.getMessage("action.update", null, Locale.getDefault()));

		model.addAttribute("facilityTypeConfirm", facilityTypeConfirmForm);
		return "facilityType/facilityType-confirm";

	}

	//delete削除確認処理
	@PostMapping(path = "/facilitytype/confirm", params = "delete")
	public String postFacilityTypeConfirmDelete(@ModelAttribute @Validated FacilityTypeDetailForm inputForm,
			BindingResult result, RedirectAttributes ra, Model model) {

		FacilityTypeManagerDto facilityTypeManagerDto = facilityTypeService
				.getFacilityTypeDetailByFacilityTypeId(facilityTypeSession.getFacilityTypeForm().getFacilityTypeId());
		int value = facilityTypeConfirmHelper.checkUpdated(facilityTypeManagerDto,
				facilityTypeSession.getBeforeFacilityTypeForm());

		boolean errorFlag = false;

		if (value != FacilityTypeConfirmHelper.NO_UPDATE) {
			result.rejectValue("sysMsg", null, msg.getMessage("already.completed", null, Locale.getDefault()));
			errorFlag = true;
		}

		if (errorFlag == true) {
			ra.addFlashAttribute("errors", result);
			return "redirect:/facilitytype/detail/" + (facilityTypeSession.getFacilityTypeForm().getFacilityTypeId());
		}

		FacilityTypeConfirmForm facilityTypeConfirmForm = facilityTypeConfirmHelper
				.createFacilityTypeConfirmForm(facilityTypeManagerDto);

		facilityTypeSession.getFacilityTypeForm().setName(facilityTypeConfirmForm.getBtnName());

		facilityTypeConfirmForm.setBtnName(msg.getMessage("label.delete", null, Locale.getDefault()));
		facilityTypeConfirmForm.setBtnAction(msg.getMessage("action.delete", null, Locale.getDefault()));

		model.addAttribute("facilityTypeConfirm", facilityTypeConfirmForm);

		return "facilityType/facilityType-confirm";
	}

}
