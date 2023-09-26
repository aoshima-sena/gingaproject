package jp.co.ginga.web.application.controller.facilityReservation.complete;

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

import jp.co.ginga.web.application.controller.facilityReservation.confirm.FacilityReservationConfirmForm;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerService;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;
import jp.co.ginga.web.util.security.domain.service.security.UserDetailsImpl;

@Controller
public class FacilityReservationCompleteController {

	@Autowired
	MessageSource msg;
	@Autowired
	FacilityReservationSession facilityReservationSession;
	@Autowired
	FacilityReservationManagerService service;
	@Autowired
	FacilityReservationCompleteHelper facilityReservationCompleteHelper;

	@GetMapping(path = "/facilityreservation/complete")
	public String createFacilityReservationComplete(ModelMap modelMap) {
		FacilityReservationCompleteForm facilityReservationCompleteForm = FacilityReservationCompleteForm.getInstance();
		if (modelMap.get("data") == null) {
			return "redirect:/error/error";
		} else if (modelMap.containsKey("data") == true) {
			modelMap.addAttribute("facilityReservationComplete", facilityReservationCompleteForm);
		} else {
			facilityReservationCompleteForm.setSysMsg(msg.getMessage("Already.completed", null, Locale.getDefault()));
			modelMap.addAttribute("facilityReservationComplete", facilityReservationCompleteForm);
		}
		return "facilityReservation/facilityReservation-complete";
	}

	@PostMapping(path = "/facilityreservation/complete", params = "add")
	public String createFacilityReservationCompleteAdd(ModelMap modelMap, RedirectAttributes ra,
			@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
			FacilityReservationConfirmForm facilityReservationConfirmForm) {
		FacilityReservationCompleteForm form = FacilityReservationCompleteForm.getInstance();
		Timestamp str = facilityReservationConfirmForm.getFacilityReservationForm().getStartTime();
		System.out.println(str);
		if (facilityReservationConfirmForm.getFacilityReservationForm().getStartTime() != null) {
			facilityReservationSession.getFacilityReservationForm().setStartTime(str);
			facilityReservationSession.getFacilityReservationForm()
					.setEndTime(facilityReservationConfirmForm.getFacilityReservationForm().getEndTime());
			facilityReservationSession.getFacilityReservationForm().getFacilityForm().setName(
					facilityReservationConfirmForm.getFacilityReservationFormList().get(0).getFacilityForm().getName());
			facilityReservationSession.getFacilityReservationForm().getFacilityForm().setFacilityId(
					facilityReservationConfirmForm.getFacilityReservationForm().getFacilityForm().getFacilityId());
			/*	form.getFacilityReservationForm().setStartTime(facilityReservationConfirmForm.getFacilityReservationForm().getStartTime());
				form.getFacilityReservationForm().setEndTime(facilityReservationConfirmForm.getFacilityReservationForm().getEndTime());
				form.getFacilityReservationForm().getFacilityForm().setName(facilityReservationConfirmForm.getFacilityReservationFormList().get(0).getFacilityForm().getName());*/
		}
		System.out.println(facilityReservationSession.getFacilityReservationForm().getFacilityForm().getFacilityId());
		FacilityReservationManagerDto facilityReservationManagerDto = facilityReservationCompleteHelper
				.convertFacilityReservationManagerDto(facilityReservationSession);

		facilityReservationManagerDto.getReservationDto().setUserDto(UserDto.getInstance());
		facilityReservationManagerDto.getReservationDto().getUserDto().setUserId(userDetailsImpl.getUserId());

		//	FacilityReservationManagerDto dto = facilityReservationCompleteHelper.createForm(form);
		FacilityReservationManagerDto addDto = service.add(facilityReservationManagerDto);
		form = facilityReservationCompleteHelper.createFacilityReservationCompleteForm(addDto);
		form.setBtnName(msg.getMessage("label.add", null, Locale.getDefault()));
		form.setBtnText(msg.getMessage("action.add", null, Locale.getDefault()));
		ra.addFlashAttribute("data", form);
		facilityReservationSession.clear();
		return "redirect:/facilityreservation/complete";
	}

	@PostMapping(path = "/facilityreservation/complete", params = "update")
	public String createFacilityReservationComplete(RedirectAttributes ra, Model model,
			@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
			FacilityReservationConfirmForm facilityReservationConfirmForm) {
		FacilityReservationCompleteForm form = FacilityReservationCompleteForm.getInstance();

		Timestamp startTime = facilityReservationConfirmForm.getFacilityReservationForm().getStartTime();
		Timestamp endTime = facilityReservationConfirmForm.getFacilityReservationForm().getEndTime();
		int facilityId = facilityReservationConfirmForm.getFacilityReservationForm().getFacilityForm().getFacilityId();
		facilityReservationSession.getFacilityReservationForm()
				.setStartTime(startTime);
		facilityReservationSession.getFacilityReservationForm()
				.setEndTime(endTime);
		//		facilityReservationSession.getFacilityReservationForm().getFacilityForm().setName(
		//				facilityReservationConfirmForm.getFacilityReservationFormList().get(0).getFacilityForm().getName());
		facilityReservationSession.getFacilityReservationForm().getFacilityForm().setFacilityId(facilityId);
		facilityReservationSession.getFacilityReservationForm()
				.setReservationId(facilityReservationConfirmForm.getFacilityReservationForm().getReservationId());
		System.out.println(facilityReservationConfirmForm.getFacilityReservationForm().getReservationId());
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
		return "redirect:/facilityreservation/complete";
	}

	@PostMapping(path = "/facilityreservation/complete", params = "delete")
	public String createFacilityReservationComplete(RedirectAttributes ra, Model model,
			FacilityReservationConfirmForm facilityReservationConfirmForm) {
		FacilityReservationCompleteForm form = FacilityReservationCompleteForm.getInstance();

		facilityReservationSession.getFacilityReservationForm().setReservationId(facilityReservationConfirmForm.getFacilityReservationForm().getReservationId());
		System.out.println(facilityReservationConfirmForm.getFacilityReservationForm().getReservationId());
		FacilityReservationManagerDto dto =facilityReservationCompleteHelper.convertFacilityReservationManagerDto(facilityReservationSession);
		FacilityReservationManagerDto managerDto = service.delete(dto);
		form=facilityReservationCompleteHelper.createFacilityReservationCompleteForm(managerDto);
		ra.addFlashAttribute("data", form);

		facilityReservationSession.clear();
		form.setBtnName(msg.getMessage("label.delete", null, Locale.getDefault()));
		form.setBtnText(msg.getMessage("action.delete", null, Locale.getDefault()));
		return "redirect:/facilityreservation/complete";
	}

}
