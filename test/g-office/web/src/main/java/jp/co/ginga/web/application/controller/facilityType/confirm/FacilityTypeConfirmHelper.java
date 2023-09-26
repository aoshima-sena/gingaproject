package jp.co.ginga.web.application.controller.facilityType.confirm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.controller.facilityType.add.FacilityTypeAddForm;
import jp.co.ginga.web.application.controller.facilityType.detail.FacilityTypeDetailForm;
import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import jp.co.ginga.web.application.util.helper.facilitytype.FacilityTypeFormHelper;
import jp.co.ginga.web.application.util.session.facilityType.FacilityTypeSession;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;

@Component
public class FacilityTypeConfirmHelper {

	@Autowired
	FacilityTypeFormHelper facilityTypeFormHelper;

	public final static int NO_UPDATE = 0;

	public final static int NAME_UPDATED = 1;

	//入力前と入力後を比較 入力したものが新しかったら成功になる
	public int checkUpdated(FacilityTypeForm facilityTypeForm, FacilityTypeForm beforeFacilityTypeForm) {
		String name = facilityTypeForm.getName();
		String beforeName = beforeFacilityTypeForm.getName();
		int update = NO_UPDATE;
		if (!name.equals(beforeName)) {
			update += NAME_UPDATED;
		}
		return update;
	}

	//dtoとformを比較
	public int checkUpdated(FacilityTypeManagerDto facilityTypeManagerDto, FacilityTypeForm beforeFacilityTypeForm) {
		FacilityTypeDto facilityTypeDto = facilityTypeManagerDto.getFacilityTypeDto();
		FacilityTypeForm facilityTypeForm = facilityTypeFormHelper.convertFacilitypeForm(facilityTypeDto);
		return this.checkUpdated(facilityTypeForm, beforeFacilityTypeForm);
	}

	//詳細画面のものと比較
	public int checkUpdated(FacilityTypeDetailForm inputForm, FacilityTypeForm beforeFacilityTypeForm) {
		return this.checkUpdated(inputForm.getFacilityTypeForm(), beforeFacilityTypeForm);
	}

	public FacilityTypeConfirmForm createFacilityTypeConfirmForm(FacilityTypeSession facilityTypeSession) {
		FacilityTypeConfirmForm facilityTypeConfirmForm = new FacilityTypeConfirmForm();
		facilityTypeConfirmForm.setFacilityTypeForm(facilityTypeSession.getFacilityTypeForm());
		return facilityTypeConfirmForm;

	}

	public FacilityTypeConfirmForm createFacilityTypeConfirmForm(FacilityTypeManagerDto facilityTypeManagerDto) {
		FacilityTypeConfirmForm facilityTypeConfirmForm = new FacilityTypeConfirmForm();
		FacilityTypeDto facilityTypeDto = facilityTypeManagerDto.getFacilityTypeDto();
		if (facilityTypeDto != null) {
			FacilityTypeForm facilityTypeForm = facilityTypeFormHelper.convertFacilitypeForm(facilityTypeDto);
			facilityTypeConfirmForm.setFacilityTypeForm(facilityTypeForm);
		}
		return facilityTypeConfirmForm;
	}

	public FacilityTypeManagerDto createFacilityTypeManagerServiceDto(FacilityTypeAddForm inputForm) {
		FacilityTypeForm facilityTypeForm = inputForm.getFacilityTypeForm();
		FacilityTypeDto facilityTypeDto = facilityTypeFormHelper.convertFacilityTypeDto(facilityTypeForm);
		FacilityTypeManagerDto facilityTypeManagerDto = FacilityTypeManagerDto.getInstance();
		facilityTypeManagerDto.setFacilityTypeDto(facilityTypeDto);
		return facilityTypeManagerDto;
	}

	public FacilityTypeManagerDto getFacilityTypeManagerSericeDto(FacilityTypeDetailForm inputForm) {
		FacilityTypeForm facilityTypeForm = inputForm.getFacilityTypeForm();
		FacilityTypeDto facilityTypeDto = facilityTypeFormHelper.convertFacilityTypeDto(facilityTypeForm);
		FacilityTypeManagerDto facilityTypeManagerDto = FacilityTypeManagerDto.getInstance();
		facilityTypeManagerDto.setFacilityTypeDto(facilityTypeDto);
		return facilityTypeManagerDto;

	}

}
