package jp.co.ginga.web.application.controller.testReservation.complete;

import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import lombok.Data;

@Data
public class TestFacilityReservationCompleteForm {

	private String sysMsg;
	private String btnName;
	private String btnText;
	FacilityReservationForm facilityReservationForm;

	public static TestFacilityReservationCompleteForm getInstance() {
		return new TestFacilityReservationCompleteForm();
	}
}
