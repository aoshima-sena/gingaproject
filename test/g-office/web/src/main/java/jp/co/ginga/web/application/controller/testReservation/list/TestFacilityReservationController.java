package jp.co.ginga.web.application.controller.testReservation.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.ginga.web.application.controller.facilityReservation.list.FacilityReservationListHelper;
import jp.co.ginga.web.application.util.session.facility.FacilitySession;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerService;

@Controller
public class TestFacilityReservationController {
	@Autowired
	FacilityReservationListHelper facilityReservationHelper;

	@Autowired
	FacilityReservationManagerService facilityReservationService;
	@Autowired
	FacilitySession facilitySession;

	@Autowired
	TestFacilityReservationListHelper helper;

	@GetMapping("/testfacilityreservation/list")
	public String getFacilityList(ModelMap model) {
		facilitySession.clear();

		FacilityReservationManagerDto facilityReservationDto = facilityReservationService.getFacilityList();

		TestFacilityReservationListForm reservationListForm = helper
				.createFacilityListForm(facilityReservationDto);

		model.addAttribute("facilityReservationListForm", reservationListForm);

		return "test/test-reservationList";
	}

	@ResponseBody
	@GetMapping("/testfacilityreservation/remake/{facilityTypeId}")
	public TestFacilityReservationListForm getFacilityTypeId(@PathVariable int facilityTypeId) {
		//すべての画面表示(html内のvalueを使って条件分岐)
		if (facilityTypeId == 0) {

			FacilityReservationManagerDto facilityManagerDto = facilityReservationService.getFacilityList();

			TestFacilityReservationListForm facilityListForm = helper
					.createFacilityListForm(facilityManagerDto);

			return facilityListForm;
		} else {
			System.out.println("succes");

			//それ以外はIdを返す
			FacilityReservationManagerDto facilityDto = facilityReservationService
					.getFacilityByFacilityTypeId(facilityTypeId);

			TestFacilityReservationListForm facilityListForm = helper
					.createFacilityListForm(facilityDto);

			return facilityListForm;
		}

	}

}
