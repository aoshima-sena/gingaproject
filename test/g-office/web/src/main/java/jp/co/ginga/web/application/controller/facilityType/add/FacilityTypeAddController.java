package jp.co.ginga.web.application.controller.facilityType.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.ginga.web.application.util.session.facilityType.FacilityTypeSession;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerService;

@Controller
public class FacilityTypeAddController {

	@Autowired
	FacilityTypeAddHelper facilityTypeAddHelper;
	@Autowired
	FacilityTypeManagerService facilityTypeManagerService;
	@Autowired
	FacilityTypeSession facilityTypeSession;

	@GetMapping("/facilitytype/add")
	public String createFacilityTypeAdd(ModelMap mdMap) {
		FacilityTypeAddForm form = null;

		if (mdMap.containsKey("errors")) {
			form = facilityTypeAddHelper.createFacilityTypeAddForm(facilityTypeSession);
			mdMap.addAttribute("facilityTypeAddForm", form);
			String key = BindingResult.MODEL_KEY_PREFIX + "facilityTypeAddForm";
			mdMap.addAttribute(key, mdMap.get("errors"));
		} else {
			form = facilityTypeAddHelper.createFacilityTypeAddForm(facilityTypeSession);
			mdMap.addAttribute("facilityTypeAddForm", form);
		}
		return "facilityType/facilityType-add";
	}
}
