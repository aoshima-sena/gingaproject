package jp.co.ginga.web.application.util.helper.facilitytype;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;

@Component
public class FacilityTypeFormHelper {

	@Autowired
	ModelMapper modelMapper;

	//dtoからformへ
	public FacilityTypeForm convertFacilitypeForm(FacilityTypeDto dto) {

		FacilityTypeForm facilityTypeForm = new FacilityTypeForm(
				dto.getFacilityTypeId(),
				dto.getName());

	//	facilityTypeForm = modelMapper.map(dto,FacilityTypeForm.class);
		return facilityTypeForm;
	}

	//DtoListからFormListへ
	public List<FacilityTypeForm> convertFacilityTypeFormList(List<FacilityTypeDto> list) {
		List<FacilityTypeForm> facilityList = new ArrayList<FacilityTypeForm>();
		for (FacilityTypeDto data : list) {
			FacilityTypeForm facilityTypeForm = this.convertFacilitypeForm(data);

			facilityList.add(facilityTypeForm);
		}
		return facilityList;

	}

	//FormからDtoへ
	public FacilityTypeDto convertFacilityTypeDto(FacilityTypeForm form) {
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto(
				form.getFacilityTypeId(),
				form.getName(),
				null,
				null);
		return facilityTypeDto;

	}

	public List<FacilityTypeDto> convertFacilityTypeDtoList(List<FacilityTypeForm> list) {
		List<FacilityTypeDto> facilityTypeDtoList = new ArrayList<FacilityTypeDto>();
		for (FacilityTypeForm data : list) {
			FacilityTypeDto facilityTypeDto = this.convertFacilityTypeDto(data);
			facilityTypeDtoList.add(facilityTypeDto);

		}
		return facilityTypeDtoList;
	}
}
