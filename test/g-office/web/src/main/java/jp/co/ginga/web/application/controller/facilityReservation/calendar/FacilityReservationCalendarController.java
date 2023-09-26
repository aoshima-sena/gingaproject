package jp.co.ginga.web.application.controller.facilityReservation.calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import jp.co.ginga.web.domain.service.facility.FacilityManagerService;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerService;

@Controller
public class FacilityReservationCalendarController {

	@Autowired
	FacilityReservationCalendarHelper reservationCalendarHelper;
	@Autowired
	FacilityReservationManagerService facilityReservationService;
	@Autowired
	FacilityManagerService facilityManagerService;
	@Autowired
	FacilityReservationSession reservationSession;

	@GetMapping("/facilityreservation/calendar/{facilityId}")
	public String getFacilityReservationCalendar(@PathVariable int facilityId, ModelMap mdMap) {
		FacilityReservationCalendarForm calendarForm = null;

		if (mdMap.containsKey("errors")) {
			calendarForm = reservationCalendarHelper.createFacilityReservationForm(reservationSession);
			mdMap.addAttribute("reservationCalendarForm", calendarForm);
			String key = BindingResult.MODEL_KEY_PREFIX + "reservationCalendarForm";
			mdMap.addAttribute(key, mdMap.get("errors"));

		} else {
			reservationSession.clear();
			FacilityReservationManagerDto dto = facilityReservationService.findStartEnd(facilityId);
			if (dto.getFacilityDtoList() != null) {
				calendarForm = reservationCalendarHelper.createStartEnd(dto);
				//reservationSession.setFacilityReservationFormList(calendarForm.getFacilityReservationFormList());
				//calendarForm.setFacilityReservationFormList(reservationSession.getFacilityReservationFormList());
				mdMap.addAttribute("calendarForm", calendarForm);
			} else {
				FacilityReservationManagerDto managerDto = facilityReservationService
						.getFacilityDetailByFacilityId(facilityId);
				//helperでListに入れたらいいと思う
				calendarForm = reservationCalendarHelper.getFacilityForm(managerDto);
				System.out.println(calendarForm);
				mdMap.addAttribute("calendarForm", calendarForm);
			}
		}
		return "facilityReservation/reservationCalender";
	}

	@ResponseBody
	@GetMapping("/facilityreservation/remake/{facilityId}/{year}/{month}")
	public FacilityReservationCalendarForm getYearAndMonth(@PathVariable int facilityId, @PathVariable int year,
			@PathVariable int month) {
		FacilityReservationCalendarForm form = FacilityReservationCalendarForm.getIntance();
		//			FacilityReservationManagerDto facilityReservationManagerDto = facilityReservationService.getYear();
		//			CalenderYearForm calenderYearForm = CalenderYearForm.getInstance();

		FacilityReservationManagerDto dto = facilityReservationService.findStartEnd(facilityId);
		if (dto.getReservationDtoList() != null) {
			form = reservationCalendarHelper.createStartEnd(dto);
			return form;
		}

		FacilityReservationManagerDto facilityReservationManagerDto = facilityReservationService
				.getFacilityDetailByFacilityId(facilityId);
		if (facilityReservationManagerDto.getReservationDto() != null) {
			form = reservationCalendarHelper.getFacilityForm(facilityReservationManagerDto);
			return form;
		}

		return form;
	}

	//	@GetMapping("/facilityreservation/calendar/{facilityId}")
	//	public String getFacilityReservationCalendar(@PathVariable int facilityId, ModelMap mdMap) {
	//		FacilityReservationCalendarForm calendarForm = null;
	//
	//		//	FacilityReservationCalendarForm calendarForm = new FacilityReservationCalendarForm();
	//		if (mdMap.containsKey("errors")) {
	//			calendarForm = reservationCalendarHelper.createFacilityReservationForm(reservationSession);
	//			mdMap.addAttribute("reservationCalendarForm", calendarForm);
	//			String key = BindingResult.MODEL_KEY_PREFIX + "reservationCalendarForm";
	//			mdMap.addAttribute(key, mdMap.get("errors"));
	//
	//		} else {
	//			reservationSession.clear();
	//
	//			FacilityReservationManagerDto reservationManagerDto = facilityReservationService
	//					.getFacilityDetailByFacilityId(facilityId);
	//			//			reservationManagerDto = facilityReservationService.getYear();
	//			//			reservationManagerDto = facilityReservationService.getMonth();
	//
	//			calendarForm = reservationCalendarHelper.createFacilityListForm(reservationManagerDto);
	//			//			calendarForm = reservationCalendarHelper.createYear(reservationManagerDto);
	//			//			calendarForm = reservationCalendarHelper.createMonth(reservationManagerDto);
	//
	//			//		 reservationManagerDto = facilityReservationService.findStartEnd(facilityId);
	//			//		calendarForm = reservationCalendarHelper.createStartEnd(reservationManagerDto);
	//
	//			reservationSession.setFacilityReservationForm(calendarForm.getFacilityReservationForm());
	//			reservationSession.setFacilityForm(calendarForm.getFacilityForm());
	//
	//			calendarForm = reservationCalendarHelper.createFacilityReservationForm(reservationSession);
	//			mdMap.addAttribute("calendarForm", calendarForm);
	//		}
	//
	//		return "facilityReservation/reservationCalender";
	//	}

	//				@ResponseBody
	//				public FacilityReservationCalendarForm getFacilityIdAndMonth(@PathVariable int facilityId, Timestamp startTime,
	//						Timestamp endTime) {
	//						FacilityReservationCalendarForm form = FacilityReservationCalendarForm.getIntance();
	//						FacilityReservationManagerDto dto = facilityReservationService.findStartEnd(facilityId);
	//						form = reservationCalendarHelper.createStartEnd(dto);
	//
	//						return form;
	//
	//				}
}
