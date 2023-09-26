package jp.co.ginga.web.application.controller.facilityType.detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jp.co.ginga.web.application.util.session.facilityType.FacilityTypeSession;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerDto;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerService;

@Controller
public class FacilityTypeDetailController {

	@Autowired
	FacilityTypeDetailHelper facilityTypeDetailHelper;
	@Autowired
	FacilityTypeManagerService facilityTypeManagerService;
	@Autowired
	FacilityTypeSession facilityTypeSession;

	//URLを打って施設種別IDを入力しなかった際に出す処理
	@GetMapping("/facilitytype/detail")
	public String notFacilityTypeDetail() {
		return "redirect:/error/error";
	}

	@GetMapping("/facilitytype/detail/{facilityTypeId}")
	public String getFacilityTypeDetail(@PathVariable int facilityTypeId, ModelMap modelMap) {
		FacilityTypeDetailForm form = null;
		if (modelMap.containsKey("errors")) {
			form = facilityTypeDetailHelper.createFacilityTypeDetailForm(facilityTypeSession);
			modelMap.addAttribute("facilityTypeDetailForm", form);
			String key = BindingResult.MODEL_KEY_PREFIX + "facilityTypeDetailForm";
			modelMap.addAttribute(key, modelMap.get("errors"));
		} else {
			facilityTypeSession.clear();
			FacilityTypeManagerDto facilityTypeManagerDto = facilityTypeManagerService
					.getFacilityTypeDetailByFacilityTypeId(facilityTypeId);
			form = facilityTypeDetailHelper
					.convertFacilityTypeDetailForm(facilityTypeManagerDto);
			facilityTypeSession.setFacilityTypeForm(form.getFacilityTypeForm());
			facilityTypeSession.setBeforeFacilityTypeForm(form.getFacilityTypeForm());
			facilityTypeSession.setOptimisticRockValue(facilityTypeManagerDto.getOptimisticRockValue());
			modelMap.addAttribute("facilityTypeDetailForm", form);

		}
		return "facilityType/facilityType-detail";

	}

}
