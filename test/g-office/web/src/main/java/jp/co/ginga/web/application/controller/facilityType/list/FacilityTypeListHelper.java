package jp.co.ginga.web.application.controller.facilityType.list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import jp.co.ginga.web.application.util.helper.facilitytype.FacilityTypeFormHelper;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;

@Component
public class FacilityTypeListHelper {
	@Autowired
	FacilityTypeFormHelper facilityTypeFormHelper;

	//FacilityTypeListFormのリストを生成してFacilityTypeDto型のListをいれる。最終的にFacilityTypeListFormにその要素を入れる。
	public FacilityTypeListForm createFacilityTypeListForm(FacilityTypeManagerDto facilityTypeManagerDto) {
		FacilityTypeListForm facilityTypeListForm = FacilityTypeListForm.getInstance();
		List<FacilityTypeDto> facilityTypeDtoList = facilityTypeManagerDto.getFacilityTypeDtoList();
		List<FacilityTypeForm> facilityTypeFormList = facilityTypeFormHelper
				.convertFacilityTypeFormList(facilityTypeDtoList);
		facilityTypeListForm.setFacilityTypeFormList(facilityTypeFormList);
		return facilityTypeListForm;
	}

}
