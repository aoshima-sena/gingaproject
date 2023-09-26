package jp.co.ginga.web.application.util.helper.facilityReservation;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.FacilityReservation.CalendarMonthForm;
@Component
public class CalenderMonthFormHelper {


	/*
		public CalendarMonthForm getMonth(FacilityReservationManagerDto dto) {
			CalendarMonthForm form = CalendarMonthForm.getInstance();
			form.setMonth(dto.getMonth());
			return form;
		}

		public FacilityReservationManagerDto getMonth(CalendarMonthForm form) {
			FacilityReservationManagerDto dto = FacilityReservationManagerDto.getInstance();
			dto.setMonth(form.getMonth());
			return dto;
		}*/

	public CalendarMonthForm getMonth(Timestamp month) {
		CalendarMonthForm form = CalendarMonthForm.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("MM");
		String str = format.format(month);
		return form;
	}
}
