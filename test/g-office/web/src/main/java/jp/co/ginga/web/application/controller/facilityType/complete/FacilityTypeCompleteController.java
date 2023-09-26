package jp.co.ginga.web.application.controller.facilityType.complete;

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

import jp.co.ginga.web.application.util.session.facilityType.FacilityTypeSession;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerDto;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerService;
import jp.co.ginga.web.domain.service.util.constant.ServiceConst;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;
import jp.co.ginga.web.util.security.domain.service.security.UserDetailsImpl;

@Controller
public class FacilityTypeCompleteController {

	@Autowired
	MessageSource msg;
	@Autowired
	FacilityTypeSession facilityTypeSession;
	@Autowired
	FacilityTypeCompleteHelper facilityTypeCompleteHelper;
	@Autowired
	FacilityTypeManagerService facilityTypeService;

	@GetMapping(path = "/facilitytype/complete")
	public String createFacilityTypeComplete(ModelMap modelMap) {
		FacilityTypeCompleteForm form = FacilityTypeCompleteForm.getInstance();
		//cotainsKeyは指定したキーが存在するか確認を行いtrueで確認ができる

		if (modelMap.get("data") == null) {
			return "redirect:/error/error";

		} else if (modelMap.containsKey("data") == true) {
			modelMap.addAttribute("facilityTypeComplete", form);
		} else {
			form.setSysMsg(msg.getMessage("Already.completed", null, Locale.getDefault()));
		}
		return "facilityType/facilityType-complete";

	}

	@PostMapping(path = "/facilitytype/complete", params = "add")

	public String createFacilityTypeCompleteAdd(RedirectAttributes ra, Model model,
			@AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
		FacilityTypeCompleteForm form = FacilityTypeCompleteForm.getInstance();

		if (facilityTypeSession.getFacilityTypeForm().getName() == null) {
			form.setSysMsg(msg.getMessage("Session.lost", null, Locale.getDefault()));
			ra.addAttribute("data", form);
			return "redirect:/facilitytype/complete";
		}
		FacilityTypeManagerDto facilityTypeManagerDto = facilityTypeCompleteHelper
				.convertFacilityTypeManagerDto(facilityTypeSession);
		facilityTypeManagerDto.getFacilityTypeDto().setInsertUserDto(UserDto.getInstance());
		facilityTypeManagerDto.getFacilityTypeDto().getInsertUserDto().setUserId(userDetailsImpl.getUserId());
		FacilityTypeManagerDto facilityDto = facilityTypeService.add(facilityTypeManagerDto);
		form = facilityTypeCompleteHelper.createFacilityTypeCompeleteForm(facilityDto);
		form.setBtnName(msg.getMessage("label.add", null, Locale.getDefault()));

		ra.addFlashAttribute("data", form);
		facilityTypeSession.clear();
		return "redirect:/facilitytype/complete";

	}

	@PostMapping(path = "facilitytype/complete", params = "update")
	public String createFacilityTypeCompleteUpdate(RedirectAttributes ra, Model model,
			@AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
		FacilityTypeCompleteForm form = new FacilityTypeCompleteForm();
		form.setBtnName(msg.getMessage("label.update", null, Locale.getDefault()));
		FacilityTypeManagerDto dto = facilityTypeCompleteHelper.convertFacilityTypeManagerDto(facilityTypeSession);
		dto.getFacilityTypeDto().setInsertUserDto(UserDto.getInstance());
		dto.getFacilityTypeDto().getInsertUserDto().setUserId(userDetailsImpl.getUserId());
		FacilityTypeManagerDto facilityTypeManagerDto = facilityTypeService.update(dto);
		switch (facilityTypeManagerDto.getResult()) {
		case ServiceConst.OK:
			form.setSysMsg(msg.getMessage("label.update", null, Locale.getDefault()));
			break;
		case ServiceConst.OPTIMISTIC_ROCK_ERROR:
			form.setSysMsg(msg.getMessage("User.optimistic", null, Locale.getDefault()));
			return "redirect:/facility/complete";
		default:
			return "redirect:/error/error";
		}

		ra.addFlashAttribute("data", form);

		facilityTypeSession.clear();

		return "redirect:/facilitytype/complete";
	}

	@PostMapping(path = "/facilitytype/complete", params = "delete")
	public String createFacilityTypeCompleteDelete(RedirectAttributes ra, Model model,
			@AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
		FacilityTypeCompleteForm form = FacilityTypeCompleteForm.getInstance();
		FacilityTypeManagerDto facilityTypeManagerDto = facilityTypeCompleteHelper
				.convertFacilityTypeManagerDto(facilityTypeSession);
		FacilityTypeManagerDto dto = facilityTypeService.delete(facilityTypeManagerDto);
		if (dto.getResult() != ServiceConst.OK) {
			return "redirect:/error/error";
		}
		form.setBtnName(msg.getMessage("label.delete", null, Locale.getDefault()));
		ra.addFlashAttribute("data", form);
		facilityTypeSession.clear();
		return "redirect:/facilitytype/complete";
	}
}
