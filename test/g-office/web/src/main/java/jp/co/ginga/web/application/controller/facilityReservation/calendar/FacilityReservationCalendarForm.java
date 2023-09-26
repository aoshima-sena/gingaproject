package jp.co.ginga.web.application.controller.facilityReservation.calendar;

import java.util.List;

import jp.co.ginga.web.application.util.form.FacilityReservation.CalendarDayForm;
import jp.co.ginga.web.application.util.form.FacilityReservation.CalendarMonthForm;
import jp.co.ginga.web.application.util.form.FacilityReservation.CalendarYearForm;
import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacilityReservationCalendarForm {

	private FacilityReservationForm facilityReservationForm;
	private FacilityForm facilityForm;
	private FacilityTypeForm facilityTypeForm;
	private List<FacilityForm> facilityFormList;
	private List<FacilityTypeForm> facilityTypeFormList;
	private List<FacilityReservationForm> facilityReservationFormList;
	private String name;
	private CalendarYearForm calenderYearForm;
	private CalendarMonthForm calenderMonthForm;
	private CalendarDayForm calenderDayForm;


	public FacilityReservationForm getFacilityReservationForm() {
		if (facilityReservationForm == null) {
			facilityReservationForm = new FacilityReservationForm();

		}
		return facilityReservationForm;
	}


	public static FacilityReservationCalendarForm getIntance() {
		return new FacilityReservationCalendarForm();
	}


	public FacilityReservationDto getFacilityReservationManagerForm() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}



}
