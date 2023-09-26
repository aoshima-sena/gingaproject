package jp.co.ginga.web.application.controller.testReservation.add;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.FacilityReservation.CalendarMonthForm;
import jp.co.ginga.web.application.util.form.FacilityReservation.CalendarYearForm;
import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import jp.co.ginga.web.application.util.helper.facility.FacilityFormHelper;
import jp.co.ginga.web.application.util.helper.facilityReservation.CalenderYearFormHelper;
import jp.co.ginga.web.application.util.helper.facilityReservation.FacilityReservationFormHelper;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;

@Component
public class TestFacilityReservationAddHelper {

	@Autowired
	FacilityReservationFormHelper facilityReservationFormHelper;
	@Autowired
	FacilityFormHelper facilityFormHelper;

	@Autowired
	CalenderYearFormHelper calendarYearFormHelper;

	public TestFacilityReservationAddForm createFaciltiyReservationAddForm(FacilityReservationManagerDto dto, int year,
			int month, int date) {
		TestFacilityReservationAddForm form = TestFacilityReservationAddForm.getInstance();
		List<FacilityReservationDto> facilityReservationDtoList = dto.getReservationDtoList();
		List<FacilityReservationForm> facilityReservationFormList = new ArrayList<FacilityReservationForm>();

		if (facilityReservationDtoList != null) {
			for (FacilityReservationDto facilityReservationDto : facilityReservationDtoList) {
				int dtoYear = this.getYear(facilityReservationDto.getStartTime());
				int dtoMonth = this.getMonth(facilityReservationDto.getStartTime());
				int dtoDate = this.getDate(facilityReservationDto.getStartTime());
				if (year == dtoYear && month + 1 == dtoMonth && date == dtoDate) {
					FacilityReservationForm facilityReservationForm = facilityReservationFormHelper
							.convertReservationForm(facilityReservationDto);
					CalendarMonthForm calendarMonthForm = CalendarMonthForm.getInstance();
					calendarMonthForm.setStartTime(this.getTime(facilityReservationForm.getStartTime()));
					calendarMonthForm.setEndTime(this.getTime(facilityReservationForm.getEndTime()));
					facilityReservationForm.setCalendarMonthForm(calendarMonthForm);
					facilityReservationFormList
							.add(new FacilityReservationForm(facilityReservationDto.getReservationId(),
									facilityReservationDto.getStartTime(), facilityReservationDto.getEndTime(),
									facilityReservationForm.getFacilityForm(), null, calendarMonthForm, null));
				} else {//予約時間がなかった場合とりまFacilityForm の情報だけ入れる
					FacilityReservationForm facilityReservationForm = facilityReservationFormHelper
							.convertReservationForm(facilityReservationDto);
					facilityReservationFormList
							.add(new FacilityReservationForm(0, null, null,
									facilityReservationForm.getFacilityForm(), null, null, null));

				}
			}
		}

		form.setFacilityReservationFormList(facilityReservationFormList);
		FacilityReservationDto facilityReservationDto = dto.getReservationDto();
		if (facilityReservationDto != null) {
			facilityReservationDto.setFacilityDto(dto.getReservationDto().getFacilityDto());
			FacilityReservationForm facilityReservationForm = facilityReservationFormHelper
					.convertReservationForm(facilityReservationDto);
			form.setFacilityReservationForm(facilityReservationForm);
		}
		return form;
	}

	public TestFacilityReservationAddForm getFacilityDto(FacilityReservationManagerDto dto) {
		TestFacilityReservationAddForm form = TestFacilityReservationAddForm.getInstance();
		FacilityReservationForm facilityReservationForm = facilityReservationFormHelper
				.convertReservationForm(dto.getFacilityDto());
		form.setFacilityReservationForm(facilityReservationForm);
		return form;
	}

	public TestFacilityReservationAddForm createFacilityReservationAddForm(FacilityReservationSession session) {
		TestFacilityReservationAddForm form = TestFacilityReservationAddForm.getInstance();
		form.setFacilityReservationForm(session.getFacilityReservationForm());
		form.setFacilityReservationFormList(session.getFacilityReservationFormList());
		return form;
	}

	public int getYear(Timestamp time) {
		CalendarYearForm calendarYearForm = CalendarYearForm.getInstance();
		calendarYearForm.setStartTime(calendarYearFormHelper.getYear(time));
		String yearString = calendarYearForm.getStartTime().substring(0, 4);
		int year = Integer.parseInt(yearString);
		return year;
	}

	public int getMonth(Timestamp time) {
		CalendarYearForm calendarYearForm = CalendarYearForm.getInstance();
		calendarYearForm.setStartTime(calendarYearFormHelper.getYear(time));
		String monthString = calendarYearForm.getStartTime().substring(5, 7);
		int year = Integer.parseInt(monthString);
		return year;
	}

	public int getDate(Timestamp time) {
		CalendarYearForm calendarYearForm = CalendarYearForm.getInstance();
		calendarYearForm.setStartTime(calendarYearFormHelper.getYear(time));
		String dateString = calendarYearForm.getStartTime().substring(8, 10);
		int year = Integer.parseInt(dateString);
		return year;
	}

	public String getTime(Timestamp time) {
		String getTime = calendarYearFormHelper.getYear(time).substring(11, 16);
		return getTime;
	}

	public CalendarMonthForm setTime(int startYear, int startMonth, int startDate) {
		CalendarMonthForm calendarMonthForm = CalendarMonthForm.getInstance();
		calendarMonthForm.setStartYear(startYear);
		calendarMonthForm.setStartMonth(startMonth);
		calendarMonthForm.setStartDate(startDate);
		return calendarMonthForm;
	}
}
