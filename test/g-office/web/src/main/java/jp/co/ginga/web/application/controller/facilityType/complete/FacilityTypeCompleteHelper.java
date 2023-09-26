package jp.co.ginga.web.application.controller.facilityType.complete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import jp.co.ginga.web.application.util.helper.facilitytype.FacilityTypeFormHelper;
import jp.co.ginga.web.application.util.session.facilityType.FacilityTypeSession;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;

//施設種別のDtoからFormクラス型にする。
//sessionの値からFacilityTypeFormの変数に情報を詰めて返す。
@Component
public class FacilityTypeCompleteHelper {

	@Autowired
	private FacilityTypeFormHelper facilityTypeFormHelper;

	//セッションをコンバート処理
	public FacilityTypeManagerDto convertFacilityTypeManagerDto(FacilityTypeSession session) {
		FacilityTypeManagerDto facilityTypeManagerDto = FacilityTypeManagerDto.getInstance();
		if (session.getFacilityTypeForm() != null) {
			FacilityTypeForm facilityTypeForm = session.getFacilityTypeForm();
			FacilityTypeDto facilityTypeDto = facilityTypeFormHelper.convertFacilityTypeDto(facilityTypeForm);
			facilityTypeManagerDto.setFacilityTypeDto(facilityTypeDto);
		}
		if (session.getOptimisticRockValue() != null) {
			facilityTypeManagerDto.setOptimisticRockValue(session.getOptimisticRockValue());
		}
		facilityTypeManagerDto.getFacilityTypeDto().setInsertUserDto(UserDto.getInstance());
		return facilityTypeManagerDto;
	}

	//DtoからFormへコンバート処理
	public FacilityTypeCompleteForm createFacilityTypeCompeleteForm(FacilityTypeManagerDto dto) {
		FacilityTypeCompleteForm facilityTypeCompleteForm = FacilityTypeCompleteForm.getInstance();
		switch (dto.getResult()) {
		case 1:
			facilityTypeCompleteForm.setSysMsg(null);
			break;
		case 2:
			facilityTypeCompleteForm.setSysMsg(null);
			break;
		default:
			break;
		}

		return facilityTypeCompleteForm;
	}

}
