package jp.co.ginga.web.application.controller.facilityType.detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import jp.co.ginga.web.application.util.helper.facilitytype.FacilityTypeFormHelper;
import jp.co.ginga.web.application.util.session.facilityType.FacilityTypeSession;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;

@Component
public class FacilityTypeDetailHelper {

	@Autowired
	FacilityTypeFormHelper facilityTypeFormHelper;

	//DtoからFormに変換
	public FacilityTypeDetailForm convertFacilityTypeDetailForm(FacilityTypeManagerDto dto) {
		FacilityTypeDto facilityTypeDto = dto.getFacilityTypeDto();
		FacilityTypeDetailForm facilityTypeDetailForm = FacilityTypeDetailForm.getInstance();
		FacilityTypeForm facilityTypeForm = facilityTypeFormHelper.convertFacilitypeForm(facilityTypeDto);
		facilityTypeDetailForm.setFacilityTypeForm(facilityTypeForm);
		return facilityTypeDetailForm;
	}

	//FaciltiyTypeDerailFormを作成して返す
	public FacilityTypeDetailForm createFacilityTypeDetailForm(FacilityTypeSession facilityTypeSession) {
		FacilityTypeDetailForm form = new FacilityTypeDetailForm();
		form.setFacilityTypeForm(facilityTypeSession.getFacilityTypeForm());
		return form;
	}
}
