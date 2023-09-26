package jp.co.ginga.web.application.util.session.faciliyReservation;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.FacilityReservation.CalendarMonthForm;
import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacilityReservationSession {

	private FacilityReservationForm facilityReservationForm;

	private List<FacilityReservationForm> facilityReservationFormList;

	private FacilityForm facilityForm;

	private FacilityTypeForm facilityTypeForm;

	private List<FacilityForm> facilityFormList;

	private List<FacilityTypeForm> facilityTypeFormList;

	private CalendarMonthForm calendarMonthForm;

	int startHour;
	int startMin;
	int endHour;
	int endMin;

	public FacilityReservationForm getFacilityReservationForm() {
		if (this.facilityReservationForm == null) {
			this.facilityReservationForm = new FacilityReservationForm();
		}
		return this.facilityReservationForm;
	}

	public void clear() {
		this.facilityReservationForm = null;
		this.facilityForm = null;
		this.facilityTypeForm = null;
		this.facilityReservationFormList = null;
		this.facilityFormList = null;
		this.facilityTypeFormList = null;
		this.calendarMonthForm = null;
	}
}
