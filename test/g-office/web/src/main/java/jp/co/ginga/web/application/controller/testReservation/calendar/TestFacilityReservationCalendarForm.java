package jp.co.ginga.web.application.controller.testReservation.calendar;

import java.util.List;

import jp.co.ginga.web.application.util.form.FacilityReservation.CalendarMonthForm;
import jp.co.ginga.web.application.util.form.FacilityReservation.CalendarYearForm;
import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestFacilityReservationCalendarForm {

	private FacilityReservationForm facilityReservationForm;
	private List<FacilityReservationForm> facilityReservationFormList;

	private FacilityForm facilityForm;
	private CalendarYearForm calendarYearForm;
	private CalendarMonthForm calendarMonthForm;
	private List<CalendarYearForm> calendarYearFormList;
	private List<CalendarMonthForm> calendarMonthFormList;




	public static TestFacilityReservationCalendarForm getInstance() {
		return new TestFacilityReservationCalendarForm();
	}
}
