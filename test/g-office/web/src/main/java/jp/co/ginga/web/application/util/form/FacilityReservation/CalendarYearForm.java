package jp.co.ginga.web.application.util.form.FacilityReservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CalendarYearForm {

	String startTime;
	String endTime;
	String reservationId;

	public static CalendarYearForm getInstance() {
		return new CalendarYearForm();
	}
}
