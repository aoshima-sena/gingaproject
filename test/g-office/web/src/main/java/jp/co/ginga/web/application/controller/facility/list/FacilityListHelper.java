package jp.co.ginga.web.application.controller.facility.list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import jp.co.ginga.web.application.util.helper.facility.FacilityFormHelper;
import jp.co.ginga.web.domain.service.facility.FacilityManagerDto;
import jp.co.ginga.web.domain.service.util.constant.ServiceConst;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;

@Component
public class FacilityListHelper {

	@Autowired
	FacilityFormHelper facilityHelper;

	public FacilityListForm createFacilityListForm(FacilityManagerDto dto) {
		FacilityListForm facilityListForm = new FacilityListForm();
		List<FacilityDto> FacilityDtoList = dto.getFacilityDtoList();
		List<FacilityForm> FacilityFormList = facilityHelper.convertFacilityFormList(FacilityDtoList);
		facilityListForm.setFacilityFormList(FacilityFormList);
		if (dto.getResult() == ServiceConst.NO_DATA) {
			facilityListForm.setSysMsg("0件です。");
		}
		return facilityListForm;
	}
}
