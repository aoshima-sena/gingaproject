package jp.co.ginga.web.application.controller.testReservation.calendar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import jp.co.ginga.web.application.util.helper.facilityReservation.FacilityReservationFormHelper;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;

@Component
public class TestFacilityReservationCalendarHelper {
	@Autowired
	FacilityReservationFormHelper reservationFormHelper;

	public TestFacilityReservationCalendarForm createStartEnd(FacilityReservationManagerDto dto) {
		TestFacilityReservationCalendarForm form = TestFacilityReservationCalendarForm.getInstance();
		List<FacilityReservationDto> list = dto.getReservationDtoList();
		List<FacilityReservationForm> formList = new ArrayList<FacilityReservationForm>();

		if (list != null) {
			for (FacilityReservationDto facilityReservationDto : list) {
				FacilityReservationForm reservationForm = reservationFormHelper
						.convertReservationForm(facilityReservationDto);
				formList.add(new FacilityReservationForm(facilityReservationDto.getReservationId(),
						facilityReservationDto.getStartTime(), facilityReservationDto.getEndTime(),
						reservationForm.getFacilityForm(), null, null, null));
			}
		} else if (dto.getFacilityDto() != null) {
			FacilityReservationForm facilityReservationForm = reservationFormHelper
					.convertReservationForm(dto.getFacilityDto());
			form.setFacilityReservationForm(facilityReservationForm);

		}

		form.setFacilityReservationFormList(formList);

		return form;
	}

	public TestFacilityReservationCalendarForm createFacilityReservationForm(FacilityReservationSession session) {
		TestFacilityReservationCalendarForm form = TestFacilityReservationCalendarForm.getInstance();
		form.setFacilityReservationForm(session.getFacilityReservationForm());
		form.setFacilityForm(session.getFacilityForm());

		return form;
	}
}
