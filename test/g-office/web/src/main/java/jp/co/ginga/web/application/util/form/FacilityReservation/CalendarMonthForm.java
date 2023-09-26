package jp.co.ginga.web.application.util.form.FacilityReservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CalendarMonthForm {

	String startTime;
	String endTime;
	int startYear;
	int startMonth;
	int startDate;
	int endYear;
	int endMonth;
	int endDate;
	int reservationId;

	public static CalendarMonthForm getInstance() {
		return new CalendarMonthForm();
	}
}
