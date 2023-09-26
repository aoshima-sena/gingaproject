package jp.co.ginga.web.application.controller.facility.detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jp.co.ginga.web.application.util.session.facility.FacilitySession;
import jp.co.ginga.web.domain.service.facility.FacilityManagerDto;
import jp.co.ginga.web.domain.service.facility.FacilityManagerService;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerService;

@Controller
public class FacilityDetailController {

	@Autowired
	FacilityDetailHelper facilityDetailHelper;
	@Autowired
	FacilityManagerService facilityManagerService;
	@Autowired
	FacilityTypeManagerService facilityTypeService;
	@Autowired
	FacilitySession facilitySession;

	@GetMapping("/facility/detail/{facilityId}")
	public String getFacilityDetail(@PathVariable int facilityId, ModelMap mdMap) {
		FacilityDetailForm facilityDetailForm = null;

		if (mdMap.containsKey("errors")) {
			facilityDetailForm = facilityDetailHelper.createFacilityDetailForm(facilitySession);
			mdMap.addAttribute("facilityDetailForm", facilityDetailForm);
			String key = BindingResult.MODEL_KEY_PREFIX + "facilityDetailForm";
			mdMap.addAttribute(key, mdMap.get("errors"));

		} else {
			facilitySession.clear();
			FacilityManagerDto facilityManagerDto = facilityManagerService.getFacilityDetailByFacilityId(facilityId);
			facilityDetailForm = facilityDetailHelper.createFacilityDetailForm(facilityManagerDto);
			facilitySession.setFacilityForm(facilityDetailForm.getFacilityForm());
			facilitySession.setFacilityTypeFormList(facilityDetailForm.getFacilityTypeFormList());
			facilitySession.setBeforeFacilityForm(facilityDetailForm.getFacilityForm());
			facilitySession.setOptimisticRockValue(facilityManagerDto.getOptimisticRockValue());
			mdMap.addAttribute("facilityDetailForm", facilityDetailForm);
		}
		return "facility/facility-detail";
	}
}
