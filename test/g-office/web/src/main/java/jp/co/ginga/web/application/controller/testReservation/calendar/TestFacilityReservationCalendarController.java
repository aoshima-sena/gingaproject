package jp.co.ginga.web.application.controller.testReservation.calendar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.ginga.web.application.util.form.FacilityReservation.CalendarMonthForm;
import jp.co.ginga.web.application.util.form.FacilityReservation.CalendarYearForm;
import jp.co.ginga.web.application.util.helper.facilityReservation.CalenderMonthFormHelper;
import jp.co.ginga.web.application.util.helper.facilityReservation.CalenderYearFormHelper;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerService;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;

@Controller
public class TestFacilityReservationCalendarController {

	@Autowired
	TestFacilityReservationCalendarHelper testFacilityReservationCalendarHelper;
	@Autowired
	FacilityReservationManagerService facilityReservationManagerService;
	@Autowired
	FacilityReservationSession reservationSession;
	@Autowired
	CalenderYearFormHelper calendarYearFormHelper;
	@Autowired
	CalenderMonthFormHelper calendarMonthFormHelper;

	@GetMapping("/testfacilityreservation/calendar/{facilityId}")
	public String getFacilityReservationCalendar(@PathVariable int facilityId, ModelMap mdMap) {
		TestFacilityReservationCalendarForm form = null;
		if (mdMap.containsKey("errors")) {
			form = testFacilityReservationCalendarHelper.createFacilityReservationForm(reservationSession);
			mdMap.addAttribute("reservationCalendarForm", form);
			String key = BindingResult.MODEL_KEY_PREFIX + "reservationCalendarForm";
			mdMap.addAttribute(key, mdMap.get("errors"));

		} else {

			FacilityReservationManagerDto dto = facilityReservationManagerService.findStartEnd(facilityId);
			if (dto.getReservationDtoList().size() != 0) {
				form = testFacilityReservationCalendarHelper.createStartEnd(dto);
			} else { //新規施設で予約が一つもない場合（facilityDtoの値しか入っていない）
				FacilityReservationManagerDto facilityDto = facilityReservationManagerService
						.getFacilityDetailByFacilityId(facilityId);
				form = testFacilityReservationCalendarHelper.createStartEnd(facilityDto);
			}
			mdMap.addAttribute("calendarForm", form);
		}
		return "test/test-reservationCalender";
	}

	@ResponseBody
	@GetMapping("/testfacilityreservation/remake/{facilityId}/{year}/{month}")
	public TestFacilityReservationCalendarForm getYearAndMonth(@PathVariable int facilityId, @PathVariable int year,
			@PathVariable int month) {
		TestFacilityReservationCalendarForm form = TestFacilityReservationCalendarForm.getInstance();
		FacilityReservationManagerDto dto = facilityReservationManagerService.findStartEnd(facilityId);

		if (dto.getReservationDtoList().size() != 0) {
			form = testFacilityReservationCalendarHelper.createStartEnd(dto);
			CalendarMonthForm calendarMonthForm = CalendarMonthForm.getInstance();
			List<CalendarMonthForm> calendarMonthFormList = new ArrayList<CalendarMonthForm>();
			CalendarYearForm calendarYearForm = CalendarYearForm.getInstance();
			for (FacilityReservationDto reservationDto : dto.getReservationDtoList()) {

				calendarYearForm.setStartTime(calendarYearFormHelper
						.getYear(reservationDto.getStartTime()));
				calendarYearForm.setEndTime(calendarYearFormHelper.getYear(reservationDto.getEndTime()));
				calendarYearForm
						.setReservationId(calendarYearFormHelper.getReservationId(reservationDto.getReservationId()));

			//	System.out.println("   " + calendarYearForm.getEndTime());
				String startTime = calendarYearForm.getStartTime().substring(11, 16);
				String startYear = calendarYearForm.getStartTime().substring(0, 4);
				String startMonth = calendarYearForm.getStartTime().substring(5, 7);
				String startDate = calendarYearForm.getStartTime().substring(8, 10);
				String endTime = calendarYearForm.getEndTime().substring(11, 16);
				String endYear = calendarYearForm.getEndTime().substring(0, 4);
				String endMonth = calendarYearForm.getEndTime().substring(5, 7);
				String endDate = calendarYearForm.getEndTime().substring(8, 10);
				String reservationId = calendarYearForm.getReservationId();

				//下のメソッドを呼び出す
				calendarMonthForm = getChange(startTime, endTime, startYear, startMonth, startDate, endYear, endMonth,
						endDate, reservationId);
				calendarMonthFormList.add(calendarMonthForm);
			}

			form.setCalendarMonthFormList(calendarMonthFormList);
			System.out.println(form);
		} else { //新規施設で予約が一つもない場合（facilityDtoの値しか入っていない）
			FacilityReservationManagerDto managerdto = facilityReservationManagerService
					.getFacilityDetailByFacilityId(facilityId);
			form = testFacilityReservationCalendarHelper.createStartEnd(managerdto);
		}
		return form;
	}

	public CalendarMonthForm getChange(String startTime, String endTime, String startYear, String startMonth,
			String startDate, String endYear, String endMonth, String endDate, String reservationId) {
		int startY = Integer.parseInt(startYear);
		int startM = Integer.parseInt(startMonth);
		int startD = Integer.parseInt(startDate);
		int endY = Integer.parseInt(endYear);
		int endM = Integer.parseInt(endMonth);
		int endD = Integer.parseInt(endDate);
		int reservation = Integer.parseInt(reservationId);
		CalendarMonthForm form = new CalendarMonthForm(startTime, endTime, startY, startM, startD, endY, endM, endD,
				reservation);
		return form;

	}
}