package jp.co.ginga.web.application.controller.facility.complete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import jp.co.ginga.web.application.util.helper.facility.FacilityFormHelper;
import jp.co.ginga.web.application.util.helper.facilitytype.FacilityTypeFormHelper;
import jp.co.ginga.web.application.util.session.facility.FacilitySession;
import jp.co.ginga.web.domain.service.facility.FacilityManagerDto;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;

@Component
public class FacilityCompleteHelper {

	@Autowired
	FacilityFormHelper facilityFormHelper;
	@Autowired
	FacilityTypeFormHelper facilityTypeFormHelper;

	public FacilityManagerDto convertFacilityManagerDto(FacilitySession session) {
		FacilityManagerDto facilityManagerDto = FacilityManagerDto.getInstance();

		if (session.getFacilityForm() != null) {
			FacilityForm facilityForm = session.getFacilityForm();
			FacilityDto facilityDto = facilityFormHelper.convertFacilityDto(facilityForm);
			facilityManagerDto.setFacilityDto(facilityDto);
		}
		if (session.getOptimisticRockValue() != null) {
			facilityManagerDto.setOptimisticRockValue(session.getOptimisticRockValue());
		}
		facilityManagerDto.getFacilityDto().setUserDto(UserDto.getInstance());

		return facilityManagerDto;
	}

	public FacilityCompleteForm createFacilityCompleteForm(FacilityManagerDto dto) {
		FacilityCompleteForm facilityCompleteForm = FacilityCompleteForm.getInstance();

		switch (dto.getResult()) {
		case 1:
			facilityCompleteForm.setSysMsg(null);
			break;
		case 2:
			facilityCompleteForm.setSysMsg(null);
			break;
		default:
			break;

		}
		return facilityCompleteForm;
	}

}
