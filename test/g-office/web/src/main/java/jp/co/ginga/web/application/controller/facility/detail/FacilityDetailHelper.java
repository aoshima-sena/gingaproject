package jp.co.ginga.web.application.controller.facility.detail;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import jp.co.ginga.web.application.util.helper.facility.FacilityFormHelper;
import jp.co.ginga.web.application.util.helper.facilitytype.FacilityTypeFormHelper;
import jp.co.ginga.web.application.util.session.facility.FacilitySession;
import jp.co.ginga.web.domain.service.facility.FacilityManagerDto;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerDto;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;

@Component
public class FacilityDetailHelper {

	@Autowired
	FacilityFormHelper facilityFormHelper;

	@Autowired
	FacilityTypeFormHelper facilityTypeFormHelper;

	public FacilityDetailForm createFacilityDetailForm(FacilitySession facilitySession) {
		FacilityDetailForm facilityDetailForm = FacilityDetailForm.getInstance();
		facilityDetailForm.setFacilityForm(facilitySession.getFacilityForm());
		facilityDetailForm.getFacilityForm()
				.setFacilityTypeForm(facilitySession.getFacilityForm().getFacilityTypeForm());
		facilityDetailForm.setFacilityTypeFormList(facilitySession.getFacilityTypeFormList());

		return facilityDetailForm;
	}

	public FacilityDetailForm createFacilityDetailForm(FacilityTypeManagerDto facilityTypeManagerDto) {
		List<FacilityTypeDto> facilityFacilityTypeDtoList = facilityTypeManagerDto.getFacilityTypeDtoList();
		List<FacilityTypeForm> facilityTypeFormList = new ArrayList<FacilityTypeForm>();

		for (FacilityTypeDto facilityTypeDto : facilityFacilityTypeDtoList) {

			facilityTypeFormList
					.add(new FacilityTypeForm(facilityTypeDto.getFacilityTypeId(), facilityTypeDto.getName()));

		}
		FacilityDetailForm facilityDetailForm = FacilityDetailForm.getInstance();

		facilityDetailForm.getFacilityForm().getFacilityTypeForm()
				.setFacilityTypeId(facilityTypeFormList.get(0).getFacilityTypeId());

		facilityDetailForm.setFacilityTypeFormList(facilityTypeFormList);

		return facilityDetailForm;
	}

	public FacilityDetailForm createFacilityDetailForm(FacilityManagerDto facilityManagerDto) {

		FacilityDto facilityDto = facilityManagerDto.getFacilityDto();
		List<FacilityTypeDto> facilityTypeDtoList = facilityManagerDto.getFacilityTypeDtoList();
		FacilityDetailForm faclityDetailForm = FacilityDetailForm.getInstance();
		FacilityForm facilityForm = facilityFormHelper.convertFacilityForm(facilityDto);
		List<FacilityTypeForm> facilityTypeFormList = facilityTypeFormHelper
				.convertFacilityTypeFormList(facilityTypeDtoList);
		faclityDetailForm.setFacilityForm(facilityForm);
		faclityDetailForm.setFacilityTypeFormList(facilityTypeFormList);

		return faclityDetailForm;
	}
}
