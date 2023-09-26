package jp.co.ginga.web.application.controller.facility.complete;

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

import jp.co.ginga.web.application.util.session.facility.FacilitySession;
import jp.co.ginga.web.domain.service.facility.FacilityManagerDto;
import jp.co.ginga.web.domain.service.facility.FacilityManagerService;
import jp.co.ginga.web.domain.service.util.constant.ServiceConst;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;
import jp.co.ginga.web.util.security.domain.service.security.UserDetailsImpl;

@Controller
public class FacilityCompleteController {

	@Autowired
	MessageSource msg;
	@Autowired
	FacilitySession facilitySession;
	@Autowired
	FacilityManagerService facilityManagerService;
	@Autowired
	FacilityCompleteHelper facilityCompleteHelper;

	@GetMapping(path = "/facility/complete")
	public String createFacilityComplete(ModelMap modelMap) {
		FacilityCompleteForm facilityCompleteForm = FacilityCompleteForm.getInstance();

		if (modelMap.get("data") == null) {

			return "/error/error/";

		} else if (modelMap.containsKey("data") == true) {
			modelMap.addAttribute("facilityComplete", facilityCompleteForm);
		} else {
			facilityCompleteForm.setSysMsg("既に作業は完了しています");
			modelMap.addAttribute("facilityComplete", facilityCompleteForm);
		}
		return "facility/facility-complete";
	}

	@PostMapping(path = "/facility/complete", params = "add")
	public String createFacilityCompleteAdd(ModelMap modelMap, RedirectAttributes ra,
			@AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
		FacilityCompleteForm facilityCompleteForm = FacilityCompleteForm.getInstance();

		if (facilitySession.getFacilityForm().getName() == null) {
			facilityCompleteForm.setSysMsg("セッションが破棄されております。もう一度作業しなおしてください");
			ra.addFlashAttribute("data", facilityCompleteForm);
			return "redirect:/facility/complete";
		}

		FacilityManagerDto facilityManagerDto = facilityCompleteHelper.convertFacilityManagerDto(facilitySession);

		facilityManagerDto.getFacilityDto().setUserDto(UserDto.getInstance());
		System.out.println(UserDto.getInstance());

		facilityManagerDto.getFacilityDto().getUserDto().setUserId(userDetailsImpl.getUserId());

		FacilityManagerDto facilityDto = facilityManagerService.add(facilityManagerDto);

		facilityCompleteForm = facilityCompleteHelper.createFacilityCompleteForm(facilityDto);

		facilityCompleteForm.setBtnText(msg.getMessage("action.add", null, Locale.getDefault()));

		facilityCompleteForm.setBtnName(msg.getMessage("label.add", null, Locale.getDefault()));

		ra.addFlashAttribute("data", facilityCompleteForm);

		facilitySession.clear();

		System.out.println("complete-facility-Clear" + facilitySession.getFacilityForm());

		return "redirect:/facility/complete";

	}

	@PostMapping(path = "/facility/complete", params = "update")
	public String createFacilityCompleteUpdate(RedirectAttributes ra, Model model,
			@AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
		FacilityCompleteForm facilityCompleteForm = new FacilityCompleteForm();

		facilityCompleteForm.setBtnName(msg.getMessage("label.update", null, Locale.getDefault()));

		FacilityManagerDto facilityManagerDto = facilityCompleteHelper.convertFacilityManagerDto(facilitySession);

		facilityManagerDto.getFacilityDto().setUserDto(UserDto.getInstance());

		facilityManagerDto.getFacilityDto().getUserDto().setUserId(userDetailsImpl.getUserId());

		System.out.println("施設名称" + facilityManagerDto.getFacilityDto().getName());

		FacilityManagerDto facilityManager = facilityManagerService.update(facilityManagerDto);

		switch (facilityManager.getResult()) {

		case ServiceConst.OK:
			facilityCompleteForm.setSysMsg("更新が完了しました");
			break;
		case ServiceConst.OPTIMISTIC_ROCK_ERROR:
			facilityCompleteForm.setSysMsg("他のユーザーが情報を更新した可能性があります。情報を確認したうえ、作業をやり直してください");
		//これいらんかも↴
			return "redirect:/facility/complete";
		default:
			return "redirect:/error/error";

		}

		ra.addFlashAttribute("data", facilityCompleteForm);

		facilitySession.clear();

		return "redirect:/facility/complete";
	}

	@PostMapping(path = "/facility/complete", params = "delete")
	public String createFacilityCompleteDelete(RedirectAttributes ra, Model model) {
		FacilityCompleteForm facilityCompleteForm = new FacilityCompleteForm();

		FacilityManagerDto facilityManagerDto = facilityCompleteHelper.convertFacilityManagerDto(facilitySession);

		FacilityManagerDto facilityDto = facilityManagerService.delete(facilityManagerDto);

		if (facilityDto.getResult() != ServiceConst.OK) {

			return "/error/error";
		}

		facilityCompleteForm.setBtnName(msg.getMessage("label.delete", null, Locale.getDefault()));

		ra.addFlashAttribute("data", facilityCompleteForm);

		facilitySession.clear();

		return "redirect:/facility/complete";
	}
}
