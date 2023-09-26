package jp.co.ginga.web.application.util.helper.facilityReservation;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.FacilityReservation.CalendarYearForm;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;

@Component
public class CalenderYearFormHelper {

	public CalendarYearForm getYear(FacilityReservationManagerDto dto) {
		CalendarYearForm form = CalendarYearForm.getInstance();
		form.setStartTime(dto.getYear());
		return form;
	}

	public FacilityReservationManagerDto getYear(CalendarYearForm form) {
		FacilityReservationManagerDto dto = FacilityReservationManagerDto.getInstance();
		dto.setYear(form.getStartTime());
		return dto;
	}

	public String getYear(Timestamp year) {
		CalendarYearForm form = CalendarYearForm.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd/HH:mm");
		String str = format.format(year);
		//	System.out.println("what   " + str);
		/*form.setStartTime(str);*/
		return str;
	}

	public String getReservationId(int reservationId) {
		String str = Integer.toString(reservationId);
		return str;
	}

}
