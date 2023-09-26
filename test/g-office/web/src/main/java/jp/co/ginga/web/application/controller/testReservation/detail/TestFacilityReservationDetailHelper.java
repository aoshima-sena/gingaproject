package jp.co.ginga.web.application.controller.testReservation.detail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import jp.co.ginga.web.application.util.helper.facilityReservation.FacilityReservationFormHelper;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;

@Component
public class TestFacilityReservationDetailHelper {
	@Autowired
	FacilityReservationFormHelper facilityReservationFormHelper;


	public TestFacilityReservationDetailForm createFacilityReservationDetailForm(FacilityReservationSession session) {
		TestFacilityReservationDetailForm form = TestFacilityReservationDetailForm.getInstance();
		form.setFacilityReservationForm(session.getFacilityReservationForm());
		return form;
	}

	public TestFacilityReservationDetailForm createFacilityReservationDetailForm(FacilityReservationManagerDto dto) {
		TestFacilityReservationDetailForm form = TestFacilityReservationDetailForm.getInstance();
		FacilityReservationDto facilityReservationDto = dto.getReservationDto();
		List<FacilityReservationDto> facilityreservationdtoList = dto.getReservationDtoList();
		if (facilityReservationDto != null) {
			FacilityReservationForm facilityReservationForm = facilityReservationFormHelper
					.convertReservationForm(facilityReservationDto);
			form.setFacilityReservationForm(facilityReservationForm);
		}
		return form;
	}
}
