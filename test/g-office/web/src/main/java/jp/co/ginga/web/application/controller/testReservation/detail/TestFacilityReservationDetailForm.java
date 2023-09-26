package jp.co.ginga.web.application.controller.testReservation.detail;

import java.util.List;

import jp.co.ginga.web.application.util.form.FacilityReservation.CalendarMonthForm;
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
public class TestFacilityReservationDetailForm {

	private String sysMsg;

	private FacilityReservationForm facilityReservationForm;
	private List<FacilityReservationForm> facilityReservationFormList;
	private FacilityForm facilityForm;
	private CalendarMonthForm calendarMonthForm;

	int startHour;
	int startMin;
	int endHour;
	int endMin;

	public FacilityReservationForm getFacilityReservationForm() {
		if (facilityReservationForm == null) {
			facilityReservationForm = new FacilityReservationForm();
		}
		return facilityReservationForm;
	}

	public static TestFacilityReservationDetailForm getInstance() {
		return new TestFacilityReservationDetailForm();
	}
}
