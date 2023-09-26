package jp.co.ginga.web.application.controller.facilityReservation.add;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import jp.co.ginga.web.application.util.helper.facility.FacilityFormHelper;
import jp.co.ginga.web.application.util.helper.facilityReservation.FacilityReservationFormHelper;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;

@Component
public class FacilityReservationAddHelper {

	@Autowired
	FacilityReservationFormHelper facilityReservationFormHelper;
	@Autowired
	FacilityFormHelper facilityFormHelper;

	public FacilityReservationAddForm createFacilityReservationAddForm(FacilityReservationManagerDto dto) {
		List<FacilityReservationDto> facilityReservationDtoList = dto.getReservationDtoList();

		List<FacilityReservationForm> facilityReservationFormList = new ArrayList<FacilityReservationForm>();
		//for文で回す必要がある
		if (facilityReservationDtoList != null) {
			for (FacilityReservationDto facilityReservationDto : facilityReservationDtoList) {
				FacilityReservationForm facilityReservationForm = facilityReservationFormHelper
						.convertReservationForm(facilityReservationDto);
				facilityReservationFormList.add(new FacilityReservationForm(facilityReservationDto.getReservationId(),
						facilityReservationDto.getStartTime(), facilityReservationDto.getEndTime(),
						facilityReservationForm.getFacilityForm(), null, null, null));

			}
		}

		FacilityReservationAddForm facilityReservationAddForm = FacilityReservationAddForm.getInstance();
		facilityReservationAddForm.setFacilityReservationFormList(facilityReservationFormList);
		FacilityReservationDto facilityReservationDto = dto.getReservationDto();
		if (facilityReservationDto != null) {
			facilityReservationDto.setFacilityDto(dto.getReservationDto().getFacilityDto());
			FacilityReservationForm facilityReservationForm = facilityReservationFormHelper
					.convertReservationForm(facilityReservationDto);
			facilityReservationAddForm.setFacilityReservationForm(facilityReservationForm);
		}

		return facilityReservationAddForm;
	}

	public FacilityReservationAddForm createFacilityReservationAddForm(FacilityReservationSession session) {
		FacilityReservationAddForm facilityReservationAddForm = FacilityReservationAddForm.getInstance();
		facilityReservationAddForm.setFacilityReservationForm(session.getFacilityReservationForm());
		facilityReservationAddForm.setFacilityForm(session.getFacilityForm());
		return facilityReservationAddForm;
	}
}
