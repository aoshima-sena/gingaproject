package jp.co.ginga.web.application.controller.facility.add;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import jp.co.ginga.web.application.util.helper.facility.FacilityFormHelper;
import jp.co.ginga.web.application.util.session.facility.FacilitySession;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;

@Component
public class FacilityAddHelper {

	@Autowired
	FacilityFormHelper facilityHelper;

	public FacilityAddForm createFacilityAddForm(FacilityTypeManagerDto dto) {
		List<FacilityTypeDto> facilityTypeDtoList = dto.getFacilityTypeDtoList();

		List<FacilityTypeForm> facilityTypeFormList = new ArrayList<FacilityTypeForm>();

		for (FacilityTypeDto data : facilityTypeDtoList) {

			facilityTypeFormList.add(new FacilityTypeForm(data.getFacilityTypeId(), data.getName()));

		}
		FacilityAddForm facilityAddForm = FacilityAddForm.getInstance();

		facilityAddForm.getFacilityForm().getFacilityTypeForm()
				.setFacilityTypeId(facilityTypeFormList.get(0).getFacilityTypeId());

		facilityAddForm.setFacilityTypeFormList(facilityTypeFormList);

		return facilityAddForm;
	}

	public FacilityAddForm createFacilityAddForm(FacilitySession session) {
		FacilityAddForm facilityAddForm = FacilityAddForm.getInstance();
		facilityAddForm.setFacilityForm(session.getFacilityForm());
		facilityAddForm.setFacilityTypeFormList(session.getFacilityTypeFormList());
		return facilityAddForm;
	}
}
