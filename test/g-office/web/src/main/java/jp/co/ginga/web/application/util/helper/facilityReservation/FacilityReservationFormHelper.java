package jp.co.ginga.web.application.util.helper.facilityReservation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import jp.co.ginga.web.application.util.helper.facility.FacilityFormHelper;
import jp.co.ginga.web.application.util.helper.facilitytype.FacilityTypeFormHelper;
import jp.co.ginga.web.application.validation.ValidationItem;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;

@Component
public class FacilityReservationFormHelper {

	@Autowired
	ValidationItem item;

	@Autowired
	FacilityFormHelper facilityFormHelper;

	@Autowired
	FacilityTypeFormHelper facilityTypeFormHelper;

	public List<FacilityReservationForm> convertReservationForm(List<FacilityReservationDto> list) {
		List<FacilityReservationForm> reservationFormList = new ArrayList<FacilityReservationForm>();

		for (FacilityReservationDto date : list) {
			FacilityReservationForm form = this.convertReservationForm(date);
			reservationFormList.add(form);
		}
		return reservationFormList;

	}

	public FacilityReservationForm convertReservationForm(FacilityReservationDto dto) {

		FacilityForm facilityForm = facilityFormHelper.convertMiniFacilityDto(dto.getFacilityDto());

		FacilityReservationForm form = new FacilityReservationForm(
				dto.getReservationId(),
				dto.getStartTime(),
				dto.getEndTime(),
				facilityForm, null, null, null
				);


		return form;
	}

	public FacilityReservationDto convertReservationDto(FacilityReservationForm form) {

		FacilityDto facilityDto = facilityFormHelper.convertFacilityDto(form.getFacilityForm());

		FacilityReservationDto dto = new FacilityReservationDto();
		dto.setReservationId(form.getReservationId());
		dto.setStartTime(form.getStartTime());
		dto.setEndTime(form.getEndTime());
		dto.setFacilityDto(facilityDto);

		return dto;
	}

	public List<FacilityReservationDto> convertReservationDto(List<FacilityReservationForm> list) {
		List<FacilityReservationDto> reservationDtoList = new ArrayList<FacilityReservationDto>();
		for (FacilityReservationForm form : list) {
			FacilityReservationDto dto = this.convertReservationDto(form);
			reservationDtoList.add(dto);
		}
		return reservationDtoList;
	}

	public FacilityReservationForm convertReservationForm(FacilityDto facilityDto) {
		FacilityReservationForm form = FacilityReservationForm.getInstance();
		FacilityForm facilityForm = FacilityForm.getInstance();
		facilityForm = facilityFormHelper.convertFacilityForm(facilityDto);
		form.setFacilityForm(facilityForm);

		return form;
	}

	/*	public FacilityReservationForm convertReservationForm(FacilityReservationManagerDto dto) {
			FacilityReservationForm form = FacilityReservationForm.getInstance();
			form.setReservationId(dto);
			return null;
		}*/
}
