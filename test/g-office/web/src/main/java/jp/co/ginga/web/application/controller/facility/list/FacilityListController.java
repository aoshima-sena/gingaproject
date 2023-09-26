package jp.co.ginga.web.application.controller.facility.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.ginga.web.application.util.session.facility.FacilitySession;
import jp.co.ginga.web.domain.service.facility.FacilityManagerDto;
import jp.co.ginga.web.domain.service.facility.FacilityManagerService;

@Controller
public class FacilityListController {

	@Autowired
	FacilityListHelper facilityListHelper;

	@Autowired
	FacilityManagerService facilityManagerService;

	@Autowired
	FacilitySession facilitySession;

	@GetMapping("/facility/list")
	public String getFacilityList(ModelMap model) {
		facilitySession.clear();

		FacilityManagerDto facilityManagerDto = facilityManagerService.getFacilityList();

		FacilityListForm facilityListForm = facilityListHelper.createFacilityListForm(facilityManagerDto);

		model.addAttribute("facilityListForm", facilityListForm.getFacilityFormList());

		return "facility/facility-list";
	}
}
