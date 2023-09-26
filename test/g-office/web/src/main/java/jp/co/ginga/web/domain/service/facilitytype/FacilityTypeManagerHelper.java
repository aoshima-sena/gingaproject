package jp.co.ginga.web.domain.service.facilitytype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.web.domain.service.util.constant.ServiceConst;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import jp.co.ginga.web.domain.service.util.helper.facilitytype.FacilityTypeDtoHelper;

@Component
public class FacilityTypeManagerHelper {

	@Autowired
	FacilityTypeDtoHelper facilityTypeDtoHelper;

	//FacilityTypeManagerDtoにFacilityTypeEntity型のリストを入れる
	public FacilityTypeManagerDto createFacilityTypeServiceDto(List<FacilityTypeEntity> typeEntityList) {
		FacilityTypeManagerDto facilityTypeManagerDto = FacilityTypeManagerDto.getInstance();
		facilityTypeManagerDto.setFacilityTypeDtoList(facilityTypeDtoHelper.mapToFacilityTypeDtoList(typeEntityList));

		return facilityTypeManagerDto;
	}

	//FacilityTypeManagerDtoにFacilityTypeEntityを入れる
	public FacilityTypeManagerDto createFacilityTypeServiceDto(FacilityTypeEntity typeEntity) {
		//FacilityTypeManagerDto facilityTypeManagerDto = createFacilityTypeServiceDto(typeEntity);
		FacilityTypeManagerDto facilityTypeManagerDto = FacilityTypeManagerDto.getInstance();
		facilityTypeManagerDto.setFacilityTypeDto(facilityTypeDtoHelper.mapToFacilityTypeDto(typeEntity));
		return facilityTypeManagerDto;

	}

	//FacilityTypeManagerDtoにFacilityTypeEntityとFacilityTypeEntityListを入れる
	public FacilityTypeManagerDto createFacilityTypeServiceDto(FacilityTypeEntity typeEntity,
			List<FacilityTypeEntity> typeEntityList) {
		FacilityTypeManagerDto facilityTypeManagerDto = this.createFacilityTypeServiceDto(typeEntity);
		facilityTypeManagerDto.setFacilityTypeDtoList(facilityTypeDtoHelper.mapToFacilityTypeDtoList(typeEntityList));
		return facilityTypeManagerDto;
	}

	//FacilityTypeEntityにFacilityTypeManagerDtoを入れる
	public FacilityTypeEntity getFacilityTypeEntity(FacilityTypeManagerDto typeManagerDto) {
		FacilityTypeEntity facilityTypeEntity = facilityTypeDtoHelper
				.mapToFacilityTypeEntity(typeManagerDto.getFacilityTypeDto());
		return facilityTypeEntity;
	}

	//FacilityTypeManagerDtoのresultを使って情報を返す。
	public FacilityTypeManagerDto createFacilityTypeServiceDtoAdd(int result) {
		FacilityTypeManagerDto facilityTypeManagerDto = FacilityTypeManagerDto.getInstance();

		if (result == 1) {
			facilityTypeManagerDto.setResult(ServiceConst.THERE_IS_DATA);

		} else if (result == 2) {
			facilityTypeManagerDto.setResult(ServiceConst.NO_DATA);
		}

		return facilityTypeManagerDto;
	}

	//FacilityTypeDtoにFacilityTypeEntityを入れる
	public FacilityTypeDto getFacilityTypeDto(FacilityTypeEntity facilityTypeEntity) {
		FacilityTypeDto facilityTypeDto = facilityTypeDtoHelper.mapToFacilityTypeDto(facilityTypeEntity);
		return facilityTypeDto;
	}

	//FacilityTypeManagerDtoにFacilityTypeEntityを入れて、上のFacilityTypeEntityがはいった
	//facilityTypeDtoをFacilityTypeManagerDtoに入れて、facilityTypeDtoがnullのときはデータなしの指示をする。
	public FacilityTypeManagerDto createFacilityTypeManagerServiceDto(FacilityTypeEntity resultFacilityTypeEntity) {
		FacilityTypeDto facilityTypeDto = this.getFacilityTypeDto(resultFacilityTypeEntity);
		FacilityTypeManagerDto facilityTypeManagerDto = FacilityTypeManagerDto.getInstance();
		facilityTypeManagerDto.setFacilityTypeDto(facilityTypeDto);
		if (facilityTypeDto == null) {
			facilityTypeManagerDto.setResult(ServiceConst.NO_DATA);
		}
		return facilityTypeManagerDto;
	}

	//FacilityTypeDto型のリストにFacilityTypeEntity型のリストを入れる。
	public List<FacilityTypeDto> getFacilityTypeList(List<FacilityTypeEntity> facilityTypeEntityList) {
		List<FacilityTypeDto> facilityTypeDtoList = facilityTypeDtoHelper
				.mapToFacilityTypeDtoList(facilityTypeEntityList);
		return facilityTypeDtoList;
	}
}
