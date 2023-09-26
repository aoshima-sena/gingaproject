package jp.co.ginga.web.application.controller.facility.confirm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.controller.facility.add.FacilityAddForm;
import jp.co.ginga.web.application.controller.facility.detail.FacilityDetailForm;
import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import jp.co.ginga.web.application.util.helper.facility.FacilityFormHelper;
import jp.co.ginga.web.application.util.helper.facilitytype.FacilityTypeFormHelper;
import jp.co.ginga.web.application.util.session.facility.FacilitySession;
import jp.co.ginga.web.domain.service.facility.FacilityManagerDto;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;

@Component
public class FacilityConfirmHelper {

	public final static int NO_UPDATE = 0;

	public final static int NAME_UPDATED = 1;

	public final static int FACILITY_TYPE_UPDATED = 10;

	public final static int CAPACITY_UPDATED = 100;
	@Autowired
	public FacilityFormHelper facilityFormHelper;
	@Autowired
	public FacilityTypeFormHelper facilityTypeFormHelper;

	public FacilityConfirmForm createFacilityConfirmForm(FacilitySession facilitySession) {
		FacilityConfirmForm facilityConfirmForm = FacilityConfirmForm.getInstance();

		facilityConfirmForm.setFacilityForm(facilitySession.getFacilityForm());

		facilityConfirmForm.setFacilityTypeFormList(facilitySession.getFacilityTypeFormList());

		return facilityConfirmForm;
	}

	public FacilityConfirmForm createFacilityConfirmForm(FacilityManagerDto facilityManagerDto) {
		FacilityDto facilityDto = facilityManagerDto.getFacilityDto();

		List<FacilityTypeDto> facilityTypeDtoList = facilityManagerDto.getFacilityTypeDtoList();

		FacilityConfirmForm facilityConfirmForm = FacilityConfirmForm.getInstance();

		if (facilityDto != null) {
			FacilityForm facilityForm = facilityFormHelper.convertFacilityForm(facilityDto);

			List<FacilityTypeForm> facilityTypeFormList = facilityTypeFormHelper
					.convertFacilityTypeFormList(facilityTypeDtoList);

			facilityConfirmForm.setFacilityForm(facilityForm);

			facilityConfirmForm.setFacilityTypeFormList(facilityTypeFormList);

		}
		return facilityConfirmForm;
	}

	public FacilityManagerDto createFacilityManagerServiceDto(FacilityAddForm inputForm) {

		FacilityForm facilityForm = inputForm.getFacilityForm();

		FacilityDto facilityDto = facilityFormHelper.convertFacilityDto(facilityForm);

		FacilityManagerDto facilityManagerDto = FacilityManagerDto.getInstance();

		facilityManagerDto.setFacilityDto(facilityDto);

		return facilityManagerDto;
	}

	public FacilityManagerDto getFacilityManagerServiceDto(FacilityDetailForm inputForm) {

		FacilityForm facilityForm = inputForm.getFacilityForm();

		FacilityDto facilityDto = facilityFormHelper.convertFacilityDto(facilityForm);

		FacilityManagerDto facilityManagerDto = FacilityManagerDto.getInstance();

		facilityManagerDto.setFacilityDto(facilityDto);

		return facilityManagerDto;

	}

	public int checkUpdated(FacilityDetailForm inputForm, FacilityForm beforeFacilityForm) {

		return this.checkedUpdated(inputForm.getFacilityForm(), beforeFacilityForm);

	}

	public int checkedUpdated(FacilityManagerDto facilityManagerDto, FacilityForm beforeFacilityForm) {

		FacilityDto facilityDto = facilityManagerDto.getFacilityDto();

		FacilityForm facilityForm = facilityFormHelper.convertFacilityForm(facilityDto);

		return this.checkedUpdated(facilityForm, beforeFacilityForm);

	}

	public int checkedUpdated(FacilityForm facilityForm, FacilityForm beforeFacilityForm) {

		String name = facilityForm.getName();
		int facilityTypeId = facilityForm.getFacilityTypeForm().getFacilityTypeId();
		String capacity = facilityForm.getCapacity();
		String beforeName = beforeFacilityForm.getName();
		int beforeFacilityTypeId = beforeFacilityForm.getFacilityTypeForm().getFacilityTypeId();
		String beforeCapacity = beforeFacilityForm.getCapacity();

		int result = NO_UPDATE;

		if (!name.equals(beforeName)) {
			result += NAME_UPDATED;
		} else if (facilityTypeId != beforeFacilityTypeId) {
			result += FACILITY_TYPE_UPDATED;
		} else if (!capacity.equals(beforeCapacity)) {
			result += CAPACITY_UPDATED;
		}
		return result;
	}
}
