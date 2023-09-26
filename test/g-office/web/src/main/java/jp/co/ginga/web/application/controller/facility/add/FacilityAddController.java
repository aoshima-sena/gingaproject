package jp.co.ginga.web.application.controller.facility.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.ginga.web.application.util.session.facility.FacilitySession;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerDto;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerService;

@Controller
public class FacilityAddController {

	@Autowired
	FacilityAddHelper facilityAddHelper;
	@Autowired
	FacilityTypeManagerService facilityTypeManagerService;
	@Autowired
	FacilitySession facilitySession;

	@GetMapping("/facility/add")
	public String createFacilityAdd(ModelMap mdMap) {

		FacilityAddForm facilityAddForm = null;

		if (mdMap.containsKey("errors")) {

			facilityAddForm = facilityAddHelper.createFacilityAddForm(facilitySession);

			mdMap.addAttribute("facilityAddForm", facilityAddForm);

			String key = BindingResult.MODEL_KEY_PREFIX + "facilityAddForm";
			//confirmで定義したerrors
			mdMap.addAttribute(key, mdMap.get("errors"));

			System.out.println("aaaaaaaa");

		} else {
			facilitySession.clear();

			FacilityTypeManagerDto faclityTypeManagerDto = facilityTypeManagerService.getFacilityTypeList();

			facilityAddForm = facilityAddHelper.createFacilityAddForm(faclityTypeManagerDto);

			facilitySession.setFacilityTypeFormList(facilityAddForm.getFacilityTypeFormList());

			mdMap.addAttribute("facilityAddForm", facilityAddForm);

		}

		return "facility/facility-add";
	}

}
