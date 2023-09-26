package jp.co.ginga.web.application.controller.facilityType.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerDto;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerService;

@Controller
public class FacilityTypeListController {

	@Autowired
	FacilityTypeListHelper facilityTypeListHelper;
	@Autowired
	FacilityTypeManagerService facilityTypeManagerService;

	@GetMapping("/facilityType/list")
	public String getFacilityTypeList(ModelMap map) {
		FacilityTypeManagerDto dto = facilityTypeManagerService.getFacilityTypeList();
		FacilityTypeListForm form = facilityTypeListHelper.createFacilityTypeListForm(dto);
		map.addAttribute("facilityTypeListForm", form);

		return "facilityType/facilityType-list";
	}

}
