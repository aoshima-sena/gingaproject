package jp.co.ginga.web.application.controller.facilityReservation.confirm;

import java.util.ArrayList;
import java.util.List;
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

import jp.co.ginga.web.application.controller.facilityReservation.add.FacilityReservationAddForm;
import jp.co.ginga.web.application.controller.facilityReservation.detail.FacilityReservationDetailForm;
import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import jp.co.ginga.web.application.util.helper.facilityReservation.FacilityReservationFormHelper;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerService;
import lombok.Data;

@Controller
@Data
public class FacilityReservationConfirmController {

	@Autowired
	MessageSource msg;
	@Autowired
	FacilityReservationSession facilityReservationSession;
	@Autowired
	FacilityReservationConfirmHelper facilityReservationConfirmHelper;
	@Autowired
	FacilityReservationManagerService service;
	@Autowired
	FacilityReservationFormHelper facilityReservationFormHelper;

	@PostMapping(path = "/facilityreservation/confirm", params = "add")
	public String postFacilityReservationConfirmAdd(@ModelAttribute @Validated FacilityReservationAddForm inputForm,
			BindingResult result, RedirectAttributes ra, Model model) {
		boolean error = false;

		facilityReservationSession.setFacilityReservationForm(inputForm.getFacilityReservationForm());

		if (result.hasErrors()) {
			error = true;
		}
		FacilityReservationConfirmForm facilityReservationConfirmForm = facilityReservationConfirmHelper
				.createForm(facilityReservationSession);
		facilityReservationConfirmForm.setFacilityReservationForm(inputForm.getFacilityReservationForm());
		facilityReservationConfirmForm.setYear(inputForm.getYear());
		facilityReservationConfirmForm.setMonth(inputForm.getMonth());
		facilityReservationConfirmForm.setDate(inputForm.getDate());
		facilityReservationConfirmForm.setStartHour(inputForm.getStartHour());
		facilityReservationConfirmForm.setStartSecond(inputForm.getStartMin());
		facilityReservationConfirmForm.setEndHour(inputForm.getEndHour());
		facilityReservationConfirmForm.setEndSecond(inputForm.getEndMin());
		facilityReservationConfirmForm.setFacilityReservationFormList(inputForm.getFacilityReservationFormList());
		facilityReservationConfirmForm.getFacilityReservationForm().getFacilityForm()
				.setFacilityId(inputForm.getFacilityReservationFormList().get(0).getFacilityForm().getFacilityId());
		//	facilityReservationConfirmForm.getFacilityReservationForm().getFacilityForm().setName(inputForm.getFacilityForm().getName());
		facilityReservationConfirmForm.setBtnName(msg.getMessage("label.add", null, Locale.getDefault()));
		facilityReservationConfirmForm.setBtnAction(msg.getMessage("action.add", null, Locale.getDefault()));
		//	facilityReservationSession.setFacilityReservationFormList(facilityReservationConfirmForm.getFacilityReservationFormList());

		if (error == true) {
			ra.addFlashAttribute("errors", result);
			return "redirect:/facilityreservation/add";
		}

		model.addAttribute("facilityReservationConfirmForm", facilityReservationConfirmForm);
		return "facilityReservation/facilityReservation-confirm";

	}

	@PostMapping(path = "/facilityreservation/confirm", params = "update")
	public String postFacilityReservationConfirmUpdate(
			@ModelAttribute("facilityReservationDetailForm") @Validated FacilityReservationDetailForm inputForm,
			BindingResult result,
			RedirectAttributes ra, Model model) {
		boolean errorFlag = false;

		boolean error = false;
		//バリデーションをJsでやっているからやる意味あるのかわからない
		if (error == true) {
			ra.addFlashAttribute("error", result);

			return "redirect:/facilityreservation/detail/"
					+ (facilityReservationSession.getFacilityReservationForm().getReservationId());
		}

		facilityReservationSession.setFacilityReservationForm(inputForm.getFacilityReservationForm());
		FacilityReservationConfirmForm facilityReservationConfirmForm = facilityReservationConfirmHelper
				.createForm(facilityReservationSession);

		FacilityReservationManagerDto dto = service
				.findStartEnd(inputForm.getFacilityReservationForm().getFacilityForm().getFacilityId());
		List<FacilityReservationForm> list = new ArrayList<FacilityReservationForm>();
		list = facilityReservationFormHelper.convertReservationForm(dto.getReservationDtoList());
		facilityReservationConfirmForm.setFacilityReservationFormList(list);
		facilityReservationConfirmForm.setYear(inputForm.getYear());
		facilityReservationConfirmForm.setMonth(inputForm.getMonth());
		facilityReservationConfirmForm.setDate(inputForm.getDate());
		facilityReservationConfirmForm.setStartHour(inputForm.getStartHour());
		facilityReservationConfirmForm.setStartSecond(inputForm.getStartMin());
		facilityReservationConfirmForm.setEndHour(inputForm.getEndHour());
		facilityReservationConfirmForm.setEndSecond(inputForm.getEndMin());
		facilityReservationConfirmForm.getFacilityReservationForm()
				.setReservationId(inputForm.getFacilityReservationForm().getReservationId());
		System.out.println(facilityReservationConfirmForm.getFacilityReservationForm().getReservationId());

		//				facilityReservationConfirmForm.setFacilityReservationForm(inputForm.getFacilityReservationForm());
		//	facilityReservationConfirmForm.setFacilityReservationFormList(inputForm.getFacilityReservationFormList());
		facilityReservationConfirmForm.setBtnName(msg.getMessage("label.update", null, Locale.getDefault()));
		facilityReservationConfirmForm.setBtnAction(msg.getMessage("action.update", null, Locale.getDefault()));

		model.addAttribute("facilityReservationConfirmForm", facilityReservationConfirmForm);

		return "facilityReservation/facilityReservation-confirm";
	}

	@PostMapping(path = "/facilityreservation/confirm", params = "delete")
	public String postFacilityReservationConfirmDelete(
			@ModelAttribute @Validated FacilityReservationDetailForm inputForm, BindingResult result,
			RedirectAttributes ra, Model model) {

		boolean error = false;

		if (error == true) {
			ra.addFlashAttribute("error", result);

			return "redirect:/facilityreservation/detail/"
					+ (facilityReservationSession.getFacilityReservationForm().getReservationId());
		}

		FacilityReservationConfirmForm facilityReservationConfirmForm = facilityReservationConfirmHelper
				.createForm(facilityReservationSession);
		FacilityReservationManagerDto dto = service
				.findStartEnd(inputForm.getFacilityReservationForm().getFacilityForm().getFacilityId());
		List<FacilityReservationForm> list = new ArrayList<FacilityReservationForm>();
		list = facilityReservationFormHelper.convertReservationForm(dto.getReservationDtoList());
		facilityReservationConfirmForm.setFacilityReservationFormList(list);
		facilityReservationConfirmForm.setYear(inputForm.getYear());
		facilityReservationConfirmForm.setMonth(inputForm.getMonth());
		facilityReservationConfirmForm.setDate(inputForm.getDate());
		facilityReservationConfirmForm.setStartHour(inputForm.getStartHour());
		facilityReservationConfirmForm.setStartSecond(inputForm.getStartMin());
		facilityReservationConfirmForm.setEndHour(inputForm.getEndHour());
		facilityReservationConfirmForm.setEndSecond(inputForm.getEndMin());
		System.out.println(inputForm.getFacilityReservationForm().getReservationId());
		System.out.println(facilityReservationConfirmForm.getFacilityReservationForm().getReservationId());
		facilityReservationConfirmForm.getFacilityReservationForm()
				.setReservationId(inputForm.getFacilityReservationForm().getReservationId());

		facilityReservationConfirmForm.setBtnName(msg.getMessage("label.delete", null, Locale.getDefault()));

		facilityReservationConfirmForm.setBtnAction(msg.getMessage("action.delete", null, Locale.getDefault()));

		facilityReservationSession
				.setFacilityReservationForm(facilityReservationConfirmForm.getFacilityReservationForm());

		model.addAttribute("facilityReservationConfirmForm", facilityReservationConfirmForm);

		return "facilityReservation/facilityReservation-confirm";
	}
}
