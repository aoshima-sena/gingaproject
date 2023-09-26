package jp.co.ginga.web.application.controller.facilityReservation.confirm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.controller.facilityReservation.add.FacilityReservationAddForm;
import jp.co.ginga.web.application.controller.facilityReservation.detail.FacilityReservationDetailForm;
import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import jp.co.ginga.web.application.util.helper.facilityReservation.FacilityReservationFormHelper;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;

@Component
public class FacilityReservationConfirmHelper {

	public final static int NO_UPDATE = 0;

	@Autowired
	FacilityReservationFormHelper facilityReservationFormHelper;

	public FacilityReservationConfirmForm createForm(FacilityReservationSession session) {
		FacilityReservationConfirmForm form = FacilityReservationConfirmForm.getInstance();

		form.setFacilityReservationForm(session.getFacilityReservationForm());

		return form;
	}

	public FacilityReservationConfirmForm createForm(FacilityReservationManagerDto dto) {
		FacilityReservationConfirmForm form = FacilityReservationConfirmForm.getInstance();
		FacilityReservationDto facilityReservationDto = dto.getReservationDto();
		FacilityReservationForm facilityReservationForm = facilityReservationFormHelper.convertReservationForm(facilityReservationDto);
		form.setFacilityReservationForm(facilityReservationForm);

		return form;
	}

	public FacilityReservationManagerDto createFacilityReservationManagerDto(FacilityReservationAddForm inputForm) {

		FacilityReservationForm facilityReservationForm = inputForm.getFacilityReservationForm();

		FacilityReservationDto facilityReservationDto = facilityReservationFormHelper.convertReservationDto(facilityReservationForm);

		FacilityReservationManagerDto dto = FacilityReservationManagerDto.getInstance();

		dto.setReservationDto(facilityReservationDto);

		return dto;
	}

	public FacilityReservationManagerDto createFacilityReservationManagerDto(FacilityReservationDetailForm inputForm) {

		FacilityReservationForm facilityReservationForm = inputForm.getFacilityReservationForm();

		FacilityReservationDto facilityReservationDto =facilityReservationFormHelper.convertReservationDto(facilityReservationForm);

		FacilityReservationManagerDto dto = FacilityReservationManagerDto.getInstance();

		dto.setReservationDto(facilityReservationDto);

		return dto;
	}

	/*	public int checkedUpdated(FacilityReservationForm facilityReservationForm,FacilityReservationForm beforeFacilityReservationForm) {

		}*/
}
