package jp.co.ginga.web.application.controller.testReservation.add;

import java.util.List;

import jp.co.ginga.web.application.util.form.FacilityReservation.CalendarMonthForm;
import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestFacilityReservationAddForm {


	FacilityReservationForm facilityReservationForm;

	List<FacilityReservationForm> facilityReservationFormList;

	CalendarMonthForm calendarMonthForm;

	int startHour;
	int startMin;
	int endHour;
	int endMin;

	public FacilityReservationForm getFacilityReservationForm() {
		if(facilityReservationForm ==null) {
			facilityReservationForm = FacilityReservationForm.getInstance();
		}
		return facilityReservationForm;
	}

	public static TestFacilityReservationAddForm getInstance() {
		return new TestFacilityReservationAddForm();
	}
}
