package jp.co.ginga.web.application.controller.testReservation.complete;

import java.sql.Timestamp;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.ginga.web.application.controller.testReservation.confirm.TestFacilityReservationConfirmForm;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerService;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;
import jp.co.ginga.web.util.security.domain.service.security.UserDetailsImpl;

@Controller
public class TestFacilityReservationCompleteController {
	@Autowired
	MessageSource msg;
	@Autowired
	FacilityReservationSession facilityReservationSession;
	@Autowired
	FacilityReservationManagerService service;
	@Autowired
	TestFacilityReservationCompleteHelper facilityReservationCompleteHelper;

	@GetMapping(path = "/testfacilityreservation/complete")
	public String createFacilityReservationComplete(ModelMap modelMap) {
		TestFacilityReservationCompleteForm form = TestFacilityReservationCompleteForm.getInstance();
		if (modelMap.get("data") == null) {
			return "redirect:/error/error";
		} else if (modelMap.containsKey("data") == true) {
			modelMap.addAttribute("facilityReservationComplete", form);
		} else {
			form.setSysMsg(msg.getMessage("Already.completed", null, Locale.getDefault()));
			modelMap.addAttribute("faciltyReservationComplete", form);
		}
		return "test/test-reservationComplete";
	}

	@PostMapping(path = "/testfacilityreservation/complete", params = "add")
	public String createFacilityReservationCompleteAdd(ModelMap modelMap, RedirectAttributes ra,
			@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
			TestFacilityReservationConfirmForm facilityReservationConfirmForm) {

		TestFacilityReservationCompleteForm form = TestFacilityReservationCompleteForm.getInstance();
		Timestamp str = facilityReservationConfirmForm.getFacilityReservationForm().getStartTime();
		if (facilityReservationConfirmForm.getFacilityReservationForm().getStartTime() != null) {
			facilityReservationSession.getFacilityReservationForm().setStartTime(str);
			facilityReservationSession.getFacilityReservationForm()
					.setEndTime(facilityReservationConfirmForm.getFacilityReservationForm().getEndTime());
			facilityReservationSession.getFacilityReservationForm().getFacilityForm().setName(
					facilityReservationConfirmForm.getFacilityReservationFormList().get(0).getFacilityForm().getName());
			if (facilityReservationConfirmForm.getFacilityReservationForm().getFacilityForm().getFacilityId() == 0) {
				int facilityId =facilityReservationConfirmForm.getFacilityReservationFormList().get(0).getFacilityForm().getFacilityId();
				facilityReservationSession.getFacilityReservationForm().getFacilityForm().setFacilityId(facilityId);
			} else {
				facilityReservationSession.getFacilityReservationForm().getFacilityForm().setFacilityId(
						facilityReservationConfirmForm.getFacilityReservationForm().getFacilityForm().getFacilityId());

			}

		}
		FacilityReservationManagerDto dto = facilityReservationCompleteHelper
				.convertFacilityReservationManagerDto(facilityReservationSession);
		dto.getReservationDto().setUserDto(UserDto.getInstance());
		dto.getReservationDto().getUserDto().setUserId(userDetailsImpl.getUserId());
		FacilityReservationManagerDto addDto = service.add(dto);
		form = facilityReservationCompleteHelper.createFacilityReservationCompleteForm(addDto);
		form.setBtnName(msg.getMessage("label.add", null, Locale.getDefault()));
		form.setBtnText(msg.getMessage("action.add", null, Locale.getDefault()));
		ra.addFlashAttribute("data", form);
		facilityReservationSession.clear();
		return "redirect:/testfacilityreservation/complete";
	}

	@PostMapping(path = "/testfacilityreservation/complete", params = "update")
	public String createFacilityReservationComplete(RedirectAttributes ra, Model model,
			@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
			TestFacilityReservationConfirmForm facilityReservationConfirmForm) {
		TestFacilityReservationCompleteForm form = TestFacilityReservationCompleteForm.getInstance();
		Timestamp startTime = facilityReservationConfirmForm.getFacilityReservationForm().getStartTime();
		Timestamp endTime = facilityReservationConfirmForm.getFacilityReservationForm().getEndTime();
		int facilityId = facilityReservationConfirmForm.getFacilityReservationForm().getFacilityForm().getFacilityId();
		facilityReservationSession.getFacilityReservationForm().setStartTime(startTime);
		facilityReservationSession.getFacilityReservationForm().setEndTime(endTime);
		facilityReservationSession.getFacilityReservationForm().getFacilityForm().setFacilityId(facilityId);
		facilityReservationSession.getFacilityReservationForm()
				.setReservationId(facilityReservationConfirmForm.getFacilityReservationForm().getReservationId());
		FacilityReservationManagerDto dto = facilityReservationCompleteHelper
				.convertFacilityReservationManagerDto(facilityReservationSession);

		dto.getReservationDto().setUserDto(UserDto.getInstance());
		dto.getReservationDto().getUserDto().setUserId(userDetailsImpl.getUserId());
		FacilityReservationManagerDto updateDto = service.update(dto);
		form = facilityReservationCompleteHelper.createFacilityReservationCompleteForm(updateDto);
		form.setBtnName(msg.getMessage("label.update", null, Locale.getDefault()));
		form.setBtnText(msg.getMessage("action.update", null, Locale.getDefault()));
		ra.addFlashAttribute("data", form);
		facilityReservationSession.clear();
		return "redirect:/testfacilityreservation/complete";

	}

	@PostMapping(path = "testfacilityreservation/complete", params = "delete")
	public String createFacilityReservationComplete(RedirectAttributes ra, Model model,
			TestFacilityReservationCompleteForm facilityReservationConfirmForm) {

		TestFacilityReservationCompleteForm form = TestFacilityReservationCompleteForm.getInstance();
		facilityReservationSession.getFacilityReservationForm()
				.setReservationId(facilityReservationConfirmForm.getFacilityReservationForm().getReservationId());
		FacilityReservationManagerDto dto = facilityReservationCompleteHelper
				.convertFacilityReservationManagerDto(facilityReservationSession);
		FacilityReservationManagerDto deleteDto = service.delete(dto);
		form = facilityReservationCompleteHelper.createFacilityReservationCompleteForm(deleteDto);
		ra.addFlashAttribute("data", form);
		facilityReservationSession.clear();
		form.setBtnName(msg.getMessage("label.delete", null, Locale.getDefault()));
		form.setBtnText(msg.getMessage("action.delete", null, Locale.getDefault()));
		return "redirect:/testfacilityreservation/complete";
	}

}
