package jp.co.ginga.web.application.util.helper.facility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import jp.co.ginga.web.application.util.helper.facilitytype.FacilityTypeFormHelper;
import jp.co.ginga.web.application.validation.ValidationItem;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;

@Component
public class FacilityFormHelper {

	@Autowired
	FacilityTypeFormHelper facilityTypeHelper;

	@Autowired
	ValidationItem item;

	public List<FacilityForm> convertFacilityFormList(List<FacilityDto> list) {
		List<FacilityForm> facilityFormList = new ArrayList<FacilityForm>();

		for (FacilityDto data : list) {
			FacilityForm facilityForm = this.convertFacilityForm(data);
			facilityFormList.add(facilityForm);
		}
		return facilityFormList;
	}

	public FacilityForm convertFacilityForm(FacilityDto dto) {
		FacilityTypeForm facilityTypeForm = facilityTypeHelper.convertFacilitypeForm(dto.getFacilityTypeDto());

		FacilityForm facilityForm = new FacilityForm(
				dto.getFacilityId(),
				dto.getName(),
				Integer.toString(dto.getCapacity()),
				facilityTypeForm);

		return facilityForm;
	}


	public List<FacilityDto> convertFacilityDtoList(List<FacilityForm> list) {
		List<FacilityDto> facilityDtoList = new ArrayList<FacilityDto>();
		for (FacilityForm data : list) {
			FacilityDto facilityDto = this.convertFacilityDto(data);
			facilityDtoList.add(facilityDto);
		}
		return facilityDtoList;
	}

	public FacilityDto convertFacilityDto(FacilityForm form) {
		int data = 0;
		String facility = form.getCapacity();

		if (item.isNull(facility) == false && item.isEmpty(facility) == false && item.isInteger(facility) == true) {
			data = Integer.parseInt(facility);
		}

		FacilityTypeDto facilityTypeForm = facilityTypeHelper.convertFacilityTypeDto(form.getFacilityTypeForm());

		FacilityDto facilityDto = new FacilityDto(
				form.getFacilityId(),
				form.getName(),
				data,
				facilityTypeForm,
				UserDto.getInstance());
		return facilityDto;
	}

	public FacilityForm convertMiniFacilityDto(FacilityDto dto) {
		FacilityForm form = new FacilityForm();

		form.setFacilityId(dto.getFacilityId());
		form.setName(dto.getName());
//		form.setCapacity(Integer.toString(dto.getCapacity()));


		return form;

	}
}
