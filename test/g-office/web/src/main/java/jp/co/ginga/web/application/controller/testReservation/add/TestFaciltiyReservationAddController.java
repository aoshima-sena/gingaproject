package jp.co.ginga.web.application.controller.testReservation.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.ginga.web.application.util.form.FacilityReservation.CalendarMonthForm;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerService;

@Controller
public class TestFaciltiyReservationAddController {

	@Autowired
	TestFacilityReservationAddHelper facilityReservationAddHelepr;
	@Autowired
	FacilityReservationManagerService facilityReservationManagerService;
	@Autowired
	FacilityReservationSession session;

	@GetMapping("/testfacilityreservation/add/{facilityId}/{year}/{month}/{date}")
	public String createFacilityReservationAdd(@PathVariable int facilityId, @PathVariable int year,
			@PathVariable int month, @PathVariable int date, ModelMap mdMap) {
		TestFacilityReservationAddForm form = null;
		if (mdMap.containsKey("error")) {
			form = facilityReservationAddHelepr.createFacilityReservationAddForm(session);
			mdMap.addAttribute("facilityReservationAddForm", form);
			String key = BindingResult.MODEL_KEY_PREFIX + "faciltiyReservationForm";
			mdMap.addAttribute(key, mdMap.get("error"));
		} else {
			session.clear();
			FacilityReservationManagerDto facilityReservationManagerDto = facilityReservationManagerService
					.findStartEnd(facilityId);
			if (facilityReservationManagerDto.getReservationDtoList().size() != 0) {
				form = facilityReservationAddHelepr.createFaciltiyReservationAddForm(facilityReservationManagerDto,
						year, month, date);

			} else { //新規施設で予約が一つもない場合（facilityDtoの値しか入っていない）
				FacilityReservationManagerDto facilityDto = facilityReservationManagerService
						.getFacilityDetailByFacilityId(facilityId);
				form = facilityReservationAddHelepr.getFacilityDto(facilityDto);
				CalendarMonthForm calendarMonthForm = CalendarMonthForm.getInstance();
				calendarMonthForm = facilityReservationAddHelepr.setTime(year, month, date);
				form.setCalendarMonthForm(calendarMonthForm);
			}

			CalendarMonthForm calendarMonthForm = facilityReservationAddHelepr.setTime(year, month, date);
			form.setCalendarMonthForm(calendarMonthForm);

			mdMap.addAttribute("facilityReservationAddForm", form);

		}
		return "test/test-reservationAdd";
	}

	@ResponseBody
	@GetMapping("/testfacilityreservation/add/remake/{facilityId}/{year}/{month}/{date}")
	public TestFacilityReservationAddForm getForm(@PathVariable int facilityId,@PathVariable int year,@PathVariable int month,@PathVariable int date) {
		TestFacilityReservationAddForm form = TestFacilityReservationAddForm.getInstance();
		FacilityReservationManagerDto facilityReservationManagerDto = facilityReservationManagerService
				.findStartEnd(facilityId);
		if (facilityReservationManagerDto.getReservationDtoList().size() != 0) {
			form = facilityReservationAddHelepr.createFaciltiyReservationAddForm(facilityReservationManagerDto,
					year, month-1, date);
		}
System.out.println(form);
		return form;
	}
}
