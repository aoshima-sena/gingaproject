package jp.co.ginga.web.application.controller.testReservation.confirm;

import java.util.List;

import jp.co.ginga.web.application.util.form.FacilityReservation.CalendarMonthForm;
import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestFacilityReservationConfirmForm {

	FacilityReservationForm facilityReservationForm;
	List<FacilityReservationForm> facilityReservationFormList;
	CalendarMonthForm calendarMonthForm;
	FacilityReservationSession facilityReservaionSession;

	int startHour;
	int startMin;
	int endHour;
	int endMin;
	String btnName;
	String btnAction;

	public static TestFacilityReservationConfirmForm getInstance() {
		return new TestFacilityReservationConfirmForm();
	}
}
