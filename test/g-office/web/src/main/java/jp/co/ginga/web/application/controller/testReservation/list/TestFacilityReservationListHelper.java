package jp.co.ginga.web.application.controller.testReservation.list;

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
public class TestFacilityReservationListHelper {

	@Autowired
	FacilityFormHelper facilityHelper;
	@Autowired
	FacilityTypeFormHelper facilityTypeHelper;

	public TestFacilityReservationListForm createFacilityListForm(FacilityReservationManagerDto dto) {
		TestFacilityReservationListForm facilityReservationForm = new TestFacilityReservationListForm();
		List<FacilityDto> FacilityDtoList = dto.getFacilityDtoList();
		List<FacilityForm> FacilityFormList = facilityHelper.convertFacilityFormList(FacilityDtoList);
		facilityReservationForm.setFacilityFormList(FacilityFormList);
		if (dto.getFacilityTypeDtoList() != null) {
			List<FacilityTypeDto> facilityTypeDtoList = dto.getFacilityTypeDtoList();
			List<FacilityTypeForm> facilityTypeFormList = facilityTypeHelper
					.convertFacilityTypeFormList(facilityTypeDtoList);
			facilityReservationForm.setFacilityTypeFormList(facilityTypeFormList);
		}

		return facilityReservationForm;
	}

}
