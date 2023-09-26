package jp.co.ginga.web.application.controller.facilityReservation.detail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import jp.co.ginga.web.application.util.helper.facilityReservation.FacilityReservationFormHelper;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;

@Component
public class FacilityReservationDetailHelper {
	@Autowired
	FacilityReservationFormHelper facilityReservationFormHelper;

	public FacilityReservationDetailForm createFacilityReservationDetailForm(FacilityReservationManagerDto dto) {
		FacilityReservationDetailForm facilityReservationDetailForm = FacilityReservationDetailForm.getInstance();
		FacilityReservationDto facilityReservationDto = dto.getReservationDto();
		List<FacilityReservationDto> facilityReservationDtoList = dto.getReservationDtoList();
		if (facilityReservationDto != null) {
			FacilityReservationForm facilityReservationForm = facilityReservationFormHelper
					.convertReservationForm(facilityReservationDto);
			facilityReservationDetailForm.setFacilityReservationForm(facilityReservationForm);

		}
		/*if(facilityReservationDtoList != null) {

			List<FacilityReservationForm> facilityReservationFormList = new ArrayList<FacilityReservationForm>();
			facilityReservationFormList = facilityReservationFormHelper.convertReservationForm(facilityReservationDtoList);
			facilityReservationDetailForm.setFacilityReservationFormList(facilityReservationFormList);
		}*/
		return facilityReservationDetailForm;
	}
	/*
		public List<FacilityReservationDetailForm> createFacilityReservationDetailFormList(
				FacilityReservationManagerDto dto) {
			List<FacilityReservationDetailForm> list = new ArrayList<FacilityReservationDetailForm>();
			for(FacilityReservationDetailForm form:list) {
				dto.getReservationDtoList() = facilityReservationFormHelper.
			}
		}*/

	public FacilityReservationDetailForm createFacilityReservationDetailForm(FacilityReservationSession session) {
		FacilityReservationDetailForm form = FacilityReservationDetailForm.getInstance();

		return form;
	}
}
