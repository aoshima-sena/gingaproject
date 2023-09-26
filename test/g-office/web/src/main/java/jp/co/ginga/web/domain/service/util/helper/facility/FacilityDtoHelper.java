package jp.co.ginga.web.domain.service.util.helper.facility;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.infra.repository.facility.FacilityEntity;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import jp.co.ginga.web.domain.service.util.helper.facilitytype.FacilityTypeDtoHelper;
import jp.co.ginga.web.domain.service.util.helper.user.UserDtoHelper;

@Component
public class FacilityDtoHelper {
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	UserDtoHelper userDtoHelper;
	@Autowired
	FacilityTypeDtoHelper facilityTypeDtoHelper;

	//enitityからDtoに変換
	public FacilityDto mapToFacilityDto(FacilityEntity facilityEntity) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		FacilityDto facilityDto = modelMapper.map(facilityEntity, FacilityDto.class);

		if (facilityEntity.getFacilityTypeEntity() != null) {

			FacilityTypeDto facilityTypeDto = modelMapper.map(facilityEntity.getFacilityTypeEntity(),
					FacilityTypeDto.class);

			facilityDto.setFacilityTypeDto(facilityTypeDto);
		}

		return facilityDto;
	}

	//entityリストからDtoリストに変換
	public List<FacilityDto> mapToFacilityDtoList(List<FacilityEntity> facilityEntityList) {

		List<FacilityDto> dtoList = new ArrayList<FacilityDto>();

		for (FacilityEntity entity : facilityEntityList) {
			FacilityDto facilityDto = this.mapToFacilityDto(entity);
			dtoList.add(facilityDto);
		}
		return dtoList;
	}

	//dtoからentityに変換
	public FacilityEntity mapToFacilityEntity(FacilityDto facilityDto) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);

		FacilityEntity facilityEntity = modelMapper.map(facilityDto, FacilityEntity.class);

		if (facilityDto.getFacilityTypeDto() != null) {
			FacilityTypeEntity ent = modelMapper.map(facilityDto.getFacilityTypeDto(), FacilityTypeEntity.class);

			facilityEntity.setFacilityTypeEntity(ent);

			userDtoHelper.mapToUserEntity(facilityDto.getUserDto());

		}

		facilityEntity.setInsertUserEntity(userDtoHelper.mapToUserEntity(facilityDto.getUserDto()));
		facilityEntity.setUpdateUserEntity(userDtoHelper.mapToUserEntity(facilityDto.getUserDto()));

		return facilityEntity;
	}

	//dtoリストからentityリストに変換
	public List<FacilityEntity> mapTofacilityEntityList(List<FacilityDto> FacilityDtoList) {
		List<FacilityEntity> entityList = new ArrayList<FacilityEntity>();
		for (FacilityDto dto : FacilityDtoList) {
			FacilityEntity facilityEntity = mapToFacilityEntity(dto);
			entityList.add(facilityEntity);
		}

		return entityList;
	}
}
