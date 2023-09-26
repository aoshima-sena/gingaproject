package jp.co.ginga.web.application.controller.testReservation.detail;

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
import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import jp.co.ginga.web.application.util.helper.facilityReservation.CalenderYearFormHelper;
import jp.co.ginga.web.application.util.helper.facilityReservation.FacilityReservationFormHelper;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerService;

@Controller
public class TestFacilityReservationDetailController {

	@Autowired
	FacilityReservationSession facilityReservationSession;
	@Autowired
	FacilityReservationManagerService service;
	@Autowired
	TestFacilityReservationDetailHelper facilityReservationDetailHelper;
	@Autowired
	FacilityReservationFormHelper facilityReservationFormHelper;
	@Autowired
	CalenderYearFormHelper calendarYearFormHelper;

	@GetMapping("/testfacilityreservation/detail/{reservationId}")
	public String getFacilityReservationDetail(ModelMap mdMap, @PathVariable int reservationId) {
		TestFacilityReservationDetailForm form = null;
		if (mdMap.containsKey("error")) {
			form = facilityReservationDetailHelper
					.createFacilityReservationDetailForm(facilityReservationSession);
			mdMap.addAttribute("facilityReservationDetailForm", form);
			String key = BindingResult.MODEL_KEY_PREFIX + "facilityReservationDetailForm";
			mdMap.addAttribute(key, mdMap.get("error"));
		} else {
			facilityReservationSession.clear();
			FacilityReservationManagerDto facilityReservationManagerDto = service.getReservationId(reservationId);
			form = facilityReservationDetailHelper.createFacilityReservationDetailForm(facilityReservationManagerDto);
			//reservationIdで見つけたものと　facilityIdが一緒で日にちも同じやつを持ってきたい
			CalendarYearForm calendarYearForm = CalendarYearForm.getInstance();
			CalendarMonthForm calendarMonthForm = CalendarMonthForm.getInstance();
			calendarYearForm.setStartTime(
					calendarYearFormHelper.getYear(facilityReservationManagerDto.getReservationDto().getStartTime()));
			calendarYearForm.setEndTime(
					calendarYearFormHelper.getYear(facilityReservationManagerDto.getReservationDto().getEndTime()));
			String startTime = calendarYearForm.getStartTime().substring(11, 16);
			String endTime = calendarYearForm.getEndTime().substring(11, 16);
			String startYear = calendarYearForm.getStartTime().substring(0, 4);
			String startMonth = calendarYearForm.getStartTime().substring(5, 7);
			String startDate = calendarYearForm.getStartTime().substring(8, 10);
			String endYear = calendarYearForm.getEndTime().substring(0, 4);
			String endMonth = calendarYearForm.getEndTime().substring(5, 7);
			String endDate = calendarYearForm.getEndTime().substring(8, 10);

			calendarMonthForm = getChange(startTime, endTime, startYear, startMonth, startDate, endYear, endMonth,
					endDate, reservationId);
			form.setCalendarMonthForm(calendarMonthForm);

			FacilityReservationManagerDto dto = service
					.findStartEnd(form.getFacilityReservationForm().getFacilityForm().getFacilityId());
			List<FacilityReservationForm> list = new ArrayList<FacilityReservationForm>();
			list = facilityReservationFormHelper.convertReservationForm(dto.getReservationDtoList());
			form.setFacilityReservationFormList(list);
			mdMap.addAttribute("facilityReservationDetailForm", form);

		}

		return "test/test-reservationDetail";
	}

	public CalendarMonthForm getChange(String startTime, String endTime, String startYear, String startMonth,
			String startDate, String endYear, String endMonth, String endDate, int reservationId) {
		int startY = Integer.parseInt(startYear);
		int startM = Integer.parseInt(startMonth);
		int startD = Integer.parseInt(startDate);
		int endY = Integer.parseInt(endYear);
		int endM = Integer.parseInt(endMonth);
		int endD = Integer.parseInt(endDate);
		CalendarMonthForm form = new CalendarMonthForm(startTime, endTime, startY, startM, startD, endY, endM, endD,
				reservationId);
		return form;
	}

	@ResponseBody
	@GetMapping("/testfacilityreservation/detail/remake/{reservationId}")
	public TestFacilityReservationDetailForm getForm(@PathVariable int reservationId) {
		FacilityReservationManagerDto facilityReservationManagerDto = service.getReservationId(reservationId);
		TestFacilityReservationDetailForm form = facilityReservationDetailHelper
				.createFacilityReservationDetailForm(facilityReservationManagerDto);
		FacilityReservationManagerDto dto = service
				.findStartEnd(form.getFacilityReservationForm().getFacilityForm().getFacilityId());
		if (dto.getReservationDtoList().size() != 0) {
			List<FacilityReservationForm> list = new ArrayList<FacilityReservationForm>();
			list = facilityReservationFormHelper.convertReservationForm(dto.getReservationDtoList());
			form.setFacilityReservationFormList(list);
		}
		System.out.println(form);
		return form;
	}
}
