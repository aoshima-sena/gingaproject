package jp.co.ginga.web.application.controller.facilityReservation.add;

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
public class FacilityReservationAddForm {

	String sysMsg;
	@Valid
	FacilityReservationForm facilityReservationForm;
	@Valid
	List<FacilityReservationForm> facilityReservationFormList;

	int year;
	int month;
	int date;
	int startHour;
	int startMin;
	int endHour;
	int endMin;


	FacilityForm facilityForm;

	public FacilityReservationForm getFacilityReservationForm() {
		if (facilityReservationForm == null) {
			facilityReservationForm = FacilityReservationForm.getInstance();
		}
		return facilityReservationForm;
	}

	public static FacilityReservationAddForm getInstance() {
		return new FacilityReservationAddForm();
	}
}
