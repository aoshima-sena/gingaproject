package jp.co.ginga.web.application.controller.facilityReservation.confirm;

import java.util.List;

import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacilityReservationConfirmForm {

	private String sysMsg;

	private FacilityReservationForm facilityReservationForm;

	private List<FacilityReservationForm> facilityReservationFormList;

	private String btnName;

	private String btnAction;

	int year;
	int month;
	int date;
	int startHour;
	int startSecond;
	int endHour;
	int endSecond;

	public static FacilityReservationConfirmForm getInstance() {
		return new FacilityReservationConfirmForm();
	}

}
