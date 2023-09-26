package jp.co.ginga.web.application.util.form.FacilityReservation;

import java.io.Serializable;
import java.sql.Timestamp;

import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacilityReservationForm implements Serializable {

	private int reservationId;

	private Timestamp startTime;

	private Timestamp endTime;

	private FacilityForm facilityForm;

	private CalendarDayForm calendarDayForm;

	private CalendarMonthForm calendarMonthForm;

	private CalendarYearForm calendarYearForm;

//	private List<FacilityForm> facilityFormList;

//	private List<FacilityTypeForm> facilityTypeFormList;

//	private FacilityTypeForm facilityTypeForm;

	public static FacilityReservationForm getInstance() {
		return new FacilityReservationForm();
	}

	public FacilityForm getFacilityForm() {
		if (facilityForm == null) {
			facilityForm = new FacilityForm();
		}
		return facilityForm;
	}


}
