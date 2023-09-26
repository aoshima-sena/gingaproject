package jp.co.ginga.web.application.controller.testReservation.confirm;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.ginga.web.application.controller.testReservation.add.TestFacilityReservationAddForm;
import jp.co.ginga.web.application.controller.testReservation.detail.TestFacilityReservationDetailForm;
import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import jp.co.ginga.web.application.util.helper.facilityReservation.FacilityReservationFormHelper;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerService;

@Controller
public class TestFacilityReservationConfirmController {
	@Autowired
	MessageSource msg;
	@Autowired
	FacilityReservationSession facilityReservationSession;
	@Autowired
	TestFacilityReservationConfirmHelper facilityReservationConfirmHelper;
	@Autowired
	FacilityReservationManagerService service;
	@Autowired
	FacilityReservationFormHelper facilityReservationFormHelper;

	@PostMapping(path = "/testfacilityreservation/confirm", params = "add")
	public String postFacilityReservationConfirmAdd(@ModelAttribute TestFacilityReservationAddForm inputForm,
			BindingResult result, RedirectAttributes ra, Model model) {
		boolean error = false;
		facilityReservationSession.setFacilityReservationForm(inputForm.getFacilityReservationForm());
		facilityReservationSession.setFacilityReservationFormList(inputForm.getFacilityReservationFormList());
		facilityReservationSession.setCalendarMonthForm(inputForm.getCalendarMonthForm());
		facilityReservationSession.setStartHour(inputForm.getStartHour());
		facilityReservationSession.setStartMin(inputForm.getStartMin());
		facilityReservationSession.setEndHour(inputForm.getEndHour());
		facilityReservationSession.setEndMin(inputForm.getEndMin());
		if (inputForm.getFacilityReservationFormList().size() != 0) {
			facilityReservationSession.getFacilityReservationFormList().get(0).getFacilityForm()
					.setFacilityId(inputForm.getFacilityReservationFormList().get(0).getFacilityForm().getFacilityId());
		} else if (inputForm.getFacilityReservationForm().getFacilityForm().getFacilityId() != 0) {
			facilityReservationSession.getFacilityReservationForm().getFacilityForm()
					.setFacilityId(inputForm.getFacilityReservationForm().getFacilityForm().getFacilityId());
		}
		if (result.hasErrors()) {
			error = true;
		}
		TestFacilityReservationConfirmForm form = facilityReservationConfirmHelper
				.createForm(facilityReservationSession);
		form.getCalendarMonthForm().setStartMonth(form.getCalendarMonthForm().getStartMonth() + 1);

		form.setBtnName(msg.getMessage("label.add", null, Locale.getDefault()));
		form.setBtnAction(msg.getMessage("action.add", null, Locale.getDefault()));
		if (error == true) {
			ra.addFlashAttribute("errors", result);
			return "redirect:/testfacilityreservation/add";
		}

		model.addAttribute("facilityReservationConfirmForm", form);
		System.out.println(form.getFacilityReservaionSession());
		return "test/test-reservationConfirm";
	}

	@PostMapping(path = "/testfacilityreservation/confirm", params = "update")
	public String createFacilityConfirmUpdate(@ModelAttribute TestFacilityReservationDetailForm inputForm,
			BindingResult result, RedirectAttributes ra, Model model) {
		boolean error = false;
		if (result.hasErrors()) {
			error = true;
		}
		List<FacilityReservationForm> facilityReservationFormList = new ArrayList<FacilityReservationForm>();

		facilityReservationSession.setFacilityReservationForm(inputForm.getFacilityReservationForm());
		//からのfacilityReservationFormListにからのリストを入れる
		facilityReservationSession.setFacilityReservationFormList(facilityReservationFormList);
		facilityReservationSession.setCalendarMonthForm(inputForm.getCalendarMonthForm());
		facilityReservationSession.setStartHour(inputForm.getStartHour());
		facilityReservationSession.setStartMin(inputForm.getStartMin());
		facilityReservationSession.setEndHour(inputForm.getEndHour());
		facilityReservationSession.setEndMin(inputForm.getEndMin());
		TestFacilityReservationConfirmForm form = facilityReservationConfirmHelper
				.createForm(facilityReservationSession);

		form.setBtnName(msg.getMessage("label.update", null, Locale.getDefault()));
		form.setBtnAction(msg.getMessage("action.update", null, Locale.getDefault()));

		if (error == true) {
			ra.addFlashAttribute("errors", result);
			return "redirect:/testfacilityreservation/add";
		}

		model.addAttribute("facilityReservationConfirmForm", form);
		System.out.println(form.getFacilityReservaionSession());
		return "test/test-reservationConfirm";

	}

	@PostMapping(path = "/testfacilityreservation/confirm", params = "delete")
	public String createFacilityConfirmDelete(@ModelAttribute TestFacilityReservationDetailForm inputForm,
			BindingResult result, RedirectAttributes ra, Model model) {

		if (result.hasErrors()) {
			ra.addFlashAttribute("errors", result);
			return "redirect:/testfacilityreservation/add";
		}

		List<FacilityReservationForm> facilityReservationFormList = new ArrayList<FacilityReservationForm>();

		facilityReservationSession.setFacilityReservationForm(inputForm.getFacilityReservationForm());
		//からのfacilityReservationFormListにからのリストを入れる
		facilityReservationSession.setFacilityReservationFormList(facilityReservationFormList);
		facilityReservationSession.setCalendarMonthForm(inputForm.getCalendarMonthForm());
		facilityReservationSession.setStartHour(inputForm.getStartHour());
		facilityReservationSession.setStartMin(inputForm.getStartMin());
		facilityReservationSession.setEndHour(inputForm.getEndHour());
		facilityReservationSession.setEndMin(inputForm.getEndMin());
		TestFacilityReservationConfirmForm form = facilityReservationConfirmHelper
				.createForm(facilityReservationSession);

		form.setBtnName(msg.getMessage("label.delete", null, Locale.getDefault()));
		form.setBtnAction(msg.getMessage("action.delete", null, Locale.getDefault()));

		model.addAttribute("facilityReservationConfirmForm", form);

		return "test/test-reservationConfirm";
	}

}
