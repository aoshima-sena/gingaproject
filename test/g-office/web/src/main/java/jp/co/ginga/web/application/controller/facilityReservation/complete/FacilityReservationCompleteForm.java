package jp.co.ginga.web.application.controller.facilityReservation.complete;

import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import lombok.Data;

@Data
public class FacilityReservationCompleteForm {
	private String sysMsg;
	private String btnName;
	private String btnText;

	FacilityReservationForm facilityReservationForm;

	public static FacilityReservationCompleteForm getInstance() {
		return new FacilityReservationCompleteForm();
	}
}
