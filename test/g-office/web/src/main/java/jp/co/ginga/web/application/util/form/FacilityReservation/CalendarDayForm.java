package jp.co.ginga.web.application.util.form.FacilityReservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CalendarDayForm {


	String date;

	public static CalendarDayForm getInstance() {
		return new CalendarDayForm();
	}
}
