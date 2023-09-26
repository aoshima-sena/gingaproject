package jp.co.ginga.web.application.util.helper.facilityReservation;

import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.FacilityReservation.CalendarDayForm;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
@Component
public class CalenderDayFormHelper {


	public CalendarDayForm getDay(FacilityReservationManagerDto dto) {
		CalendarDayForm form = CalendarDayForm.getInstance();
		form.setDate(dto.getDay());
		return form;
	}

	public FacilityReservationManagerDto getDay(CalendarDayForm form) {
		FacilityReservationManagerDto dto = FacilityReservationManagerDto.getInstance();
		dto.setDay(form.getDate());
		return dto;
	}
}
