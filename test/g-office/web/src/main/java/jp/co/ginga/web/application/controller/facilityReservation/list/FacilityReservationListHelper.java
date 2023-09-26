package jp.co.ginga.web.application.controller.facilityReservation.list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import jp.co.ginga.web.application.util.helper.facility.FacilityFormHelper;
import jp.co.ginga.web.application.util.helper.facilitytype.FacilityTypeFormHelper;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;

@Component
public class FacilityReservationListHelper {

	@Autowired
	FacilityFormHelper facilityHelper;
	@Autowired
	FacilityTypeFormHelper facilityTypeHelper;

	public FacilityReservationListForm createFacilityListForm(FacilityReservationManagerDto dto) {
		FacilityReservationListForm facilityReservationForm = new FacilityReservationListForm();
		List<FacilityDto> FacilityDtoList = dto.getFacilityDtoList();
		List<FacilityForm> FacilityFormList = facilityHelper.convertFacilityFormList(FacilityDtoList);
		facilityReservationForm.setFacilityFormList(FacilityFormList);
		//findAllの時はfacilityTypeDtoListは存在するけど、findByFacilityTypeIdの時はfacilityTypeDtoListが存在しないので
		if (dto.getFacilityTypeDtoList() != null) {
			List<FacilityTypeDto> facilityTypeDtoList = dto.getFacilityTypeDtoList();
			List<FacilityTypeForm> facilityTypeFormList = facilityTypeHelper
					.convertFacilityTypeFormList(facilityTypeDtoList);
			facilityReservationForm.setFacilityTypeFormList(facilityTypeFormList);
		}

		return facilityReservationForm;
	}

}
