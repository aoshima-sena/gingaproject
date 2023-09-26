package jp.co.ginga.web.application.controller.facilityReservation.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.ginga.web.application.controller.facilityReservation.calendar.FacilityReservationCalendarForm;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerService;

@Controller
public class FacilityReservationAddController {

	@Autowired
	FacilityReservationAddHelper facilityReservationAddHelper;
	@Autowired
	FacilityReservationManagerService facilityReservationManagerService;

	@Autowired
	FacilityReservationSession facilityReservationSession;

	@GetMapping("/facilityreservation/add/{facilityId}/{year}/{month}/{date}")
	public String createFacilityReservationAdd(@PathVariable int facilityId, @PathVariable int year,
			@PathVariable int month, @PathVariable int date, ModelMap mdMap,
			@ModelAttribute FacilityReservationCalendarForm calendarForm) {
		FacilityReservationAddForm facilityReservationAddForm = null;
		if (mdMap.containsKey("errors")) {
			facilityReservationAddForm = facilityReservationAddHelper
					.createFacilityReservationAddForm(facilityReservationSession);
			mdMap.addAttribute("facilityReservationAddForm", facilityReservationAddForm);
			String key = BindingResult.MODEL_KEY_PREFIX + "faciltiyReservationForm";
			mdMap.addAttribute(key, mdMap.get("error"));

		} else {
			facilityReservationSession.clear();

			FacilityReservationManagerDto facilityReservationManagerDto = facilityReservationManagerService
					.findStartEnd(facilityId);
		//	FacilityReservationManagerDto facilityReservationManagerDto2 = facilityReservationManagerService.getFacilityDetailByFacilityId(facilityId);

//			facilityReservationSession.setFacilityReservationFormList(calendarForm.getFacilityReservationFormList());
//			facilityReservationAddForm = facilityReservationAddHelper
//					.createFacilityReservationAddForm(facilityReservationSession);

			facilityReservationAddForm = facilityReservationAddHelper
					.createFacilityReservationAddForm(facilityReservationManagerDto);
		//	facilityReservationAddForm = facilityReservationAddHelper.createFacilityReservationAddForm(facilityReservationManagerDto2);
			facilityReservationAddForm.setYear(year);
			facilityReservationAddForm.setMonth(month);
			facilityReservationAddForm.setDate(date);
			facilityReservationAddForm.getFacilityReservationForm().getFacilityForm().setFacilityId(facilityId);


			facilityReservationSession
					.setFacilityReservationForm(facilityReservationAddForm.getFacilityReservationForm());
			mdMap.addAttribute("facilityReservationAddForm", facilityReservationAddForm);
		}
		System.out.println(month);
		return "facilityReservation/facilityReservation-add";
	}

	//	@ResponseBody
	//	@GetMapping("/facilityreservation/add/remake/{facilityId}/{startTime}/{endTime}")
	//	public FacilityReservationAddForm getStartAndEnd(@PathVariable int facilityId, @PathVariable Timestamp startTime,
	//			@PathVariable Timestamp endTime) {
	//		FacilityReservationAddForm facilityReservationAddForm = FacilityReservationAddForm.getInstance();
	//		FacilityReservationManagerDto dto = facilityReservationManagerService.getFacilityIdAndStartDateBetween(facilityId, startTime, endTime);
	//		facilityReservationAddForm = facilityReservationAddHelper.createFacilityReservationAddForm(dto);
	//
	//		return facilityReservationAddForm;
	//	}

	@ResponseBody
	@GetMapping("/facilityreservation/add/remake/{reservationId}")
	public FacilityReservationAddForm getAjax(@PathVariable int reservationId) {
		FacilityReservationAddForm facilityReservationAddForm = FacilityReservationAddForm.getInstance();
		FacilityReservationManagerDto dto = facilityReservationManagerService.getReservationId(reservationId);
		facilityReservationAddForm = facilityReservationAddHelper.createFacilityReservationAddForm(dto);

		return facilityReservationAddForm;
	}

}
