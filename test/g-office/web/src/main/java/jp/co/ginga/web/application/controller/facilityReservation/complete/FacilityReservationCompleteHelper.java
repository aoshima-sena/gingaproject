package jp.co.ginga.web.application.controller.facilityReservation.complete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import jp.co.ginga.web.application.util.helper.facilityReservation.FacilityReservationFormHelper;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;

@Component
public class FacilityReservationCompleteHelper {
	@Autowired
	FacilityReservationFormHelper facilityReservationFormHelper;

public FacilityReservationManagerDto convertFacilityReservationManagerDto(FacilityReservationSession session) {
	FacilityReservationManagerDto facilityReservationManagerDto = FacilityReservationManagerDto.getInstance();

	if(session.getFacilityReservationForm() != null) {
		FacilityReservationForm facilityReservationForm = session.getFacilityReservationForm();
		FacilityReservationDto facilityReservationDto = facilityReservationFormHelper.convertReservationDto(facilityReservationForm);
		facilityReservationManagerDto.setReservationDto(facilityReservationDto);
	}


	return facilityReservationManagerDto;
}

public FacilityReservationCompleteForm createFacilityReservationCompleteForm(FacilityReservationManagerDto dto) {
	FacilityReservationCompleteForm form = FacilityReservationCompleteForm.getInstance();

	switch(dto.getResult()) {
	case 1:
		form.setSysMsg(null);
		break;
	case 2:
		form.setSysMsg(null);
		break;
	default:
		break;

	}
	return form;
}

public FacilityReservationManagerDto createForm(FacilityReservationCompleteForm form) {
	FacilityReservationManagerDto dto = FacilityReservationManagerDto.getInstance();
	FacilityReservationForm facilityReservationForm = form.getFacilityReservationForm();
	FacilityReservationDto facilityReservationDto = facilityReservationFormHelper.convertReservationDto(facilityReservationForm);
	dto.setReservationDto(facilityReservationDto);

	return dto;
}
}
