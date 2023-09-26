package jp.co.ginga.web.domain.service.facility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.infra.repository.facility.FacilityEntity;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.web.domain.service.util.constant.ServiceConst;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.helper.facility.FacilityDtoHelper;
import jp.co.ginga.web.domain.service.util.helper.facilitytype.FacilityTypeDtoHelper;

@Component
public class FacilityManagerHelper {

	@Autowired
	FacilityDtoHelper facilityDtoHelper;
	@Autowired
	FacilityTypeDtoHelper facilityTypeDtoHelper;

	//dto生成処理(faiclityEntityリストを入れる)
	public FacilityManagerDto createFacilityServiceDto(List<FacilityEntity> facilityEntityList) {
		FacilityManagerDto facilityManagerDto = FacilityManagerDto.getInstance();
		facilityManagerDto.setFacilityDtoList(facilityDtoHelper
				.mapToFacilityDtoList(facilityEntityList));

		return facilityManagerDto;

	}

	//dto生成処理(facilityTypeEntityListを入れる)
	public FacilityManagerDto createFacilityServiceDto(FacilityEntity facilityEntity,
			List<FacilityTypeEntity> facilityTypeEntityList) {
		FacilityManagerDto facilityManagerDto = createFacilityServiceDto(facilityEntity);
		facilityManagerDto
				.setFacilityTypeDtoList(facilityTypeDtoHelper.mapToFacilityTypeDtoList(facilityTypeEntityList));

		return facilityManagerDto;
	}

	//dto生成処理(facilityEntityを入れる)
	public FacilityManagerDto createFacilityServiceDto(FacilityEntity facilityEntity) {

		FacilityManagerDto facilityManagerDto = FacilityManagerDto.getInstance();
		facilityManagerDto.setFacilityDto(facilityDtoHelper.mapToFacilityDto(facilityEntity));

		return facilityManagerDto;
	}

	//dtoからentityに変換
	public FacilityEntity getFacilityEntity(FacilityManagerDto facilityManagerDto) {

		FacilityEntity facilityEntity = facilityDtoHelper.mapToFacilityEntity(facilityManagerDto.getFacilityDto());

		return facilityEntity;
	}

	//dtoの処理結果によって分岐
	public FacilityManagerDto createFacilityServiceDtoAdd(int result) {
		FacilityManagerDto facility = FacilityManagerDto.getInstance();
		switch (result) {
		case 1:
			facility.setResult(ServiceConst.THERE_IS_DATA);
			break;
		case 0:
			facility.setResult(ServiceConst.NO_DATA);
			break;
		default:
			facility.setResult(ServiceConst.ERROR);
			break;
		}

		return facility;
	}

	//entityからdtoに変換
	public FacilityDto getFacilityDto(FacilityEntity facilityEntity) {
		FacilityDto facility = facilityDtoHelper.mapToFacilityDto(facilityEntity);

		return facility;
	}

	//dto生成処理(データベース内に同じデータがないことを確認？)
	public FacilityManagerDto createFacilityManagerServiceDto(FacilityEntity facilityEntity) {
		FacilityDto facilityDto = facilityDtoHelper.mapToFacilityDto(facilityEntity);
		FacilityManagerDto facilityManagerDto = FacilityManagerDto.getInstance();
		facilityManagerDto.setFacilityDto(facilityDto);
		if (facilityDto == null) {
			facilityManagerDto.setResult(ServiceConst.NO_DATA);
		}
		return facilityManagerDto;
	}

	//entityリストを入れる
	public List<FacilityDto> getFacilityList(List<FacilityEntity> facilityEntityList) {
		List<FacilityDto> facilityDtoList = facilityDtoHelper.mapToFacilityDtoList(facilityEntityList);

		return facilityDtoList;
	}

}
