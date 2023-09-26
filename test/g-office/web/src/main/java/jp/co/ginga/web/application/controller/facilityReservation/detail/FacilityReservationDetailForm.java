package jp.co.ginga.web.application.controller.facilityReservation.detail;

import java.util.List;

import javax.validation.Valid;

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
public class FacilityReservationDetailForm {

	private String sysMsg;
	@Valid
	private FacilityReservationForm facilityReservationForm;
	private List<FacilityReservationForm> facilityReservationFormList;
	private FacilityForm facilityForm;

	int year;
	int month;
	int date;
	int startHour;
	int startMin;
	int endHour;
	int endMin;

	public FacilityReservationForm getFacilityReservationForm() {
		if(facilityReservationForm == null) {
			facilityReservationForm = new FacilityReservationForm();
		}
		return facilityReservationForm;
	}

	public static FacilityReservationDetailForm getInstance() {
		return new FacilityReservationDetailForm();
	}
}
