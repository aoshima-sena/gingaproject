package jp.co.ginga.web.domain.service.util.helper.facilitytype;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import jp.co.ginga.web.domain.service.util.helper.user.UserDtoHelper;

@Component

public class FacilityTypeDtoHelper {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	UserDtoHelper userDtoHelper;

	public FacilityTypeDto mapToFacilityTypeDto(FacilityTypeEntity typeEntity) {
		FacilityTypeDto facilityTypeDto = modelMapper.map(typeEntity, FacilityTypeDto.class);

		return facilityTypeDto;
	}

	//M2のみ ok

	public List<FacilityTypeDto> mapToFacilityTypeDtoList(List<FacilityTypeEntity> typeEntityList) {

		List<FacilityTypeDto> dtoList = new ArrayList<FacilityTypeDto>();
		for (FacilityTypeEntity entity : typeEntityList) {
			FacilityTypeDto dto = mapToFacilityTypeDto(entity);
			dtoList.add(dto);

		}

		return dtoList;
	}

	public FacilityTypeEntity mapToFacilityTypeEntity(FacilityTypeDto typeDto) {
		FacilityTypeEntity facilityTypeEntity = modelMapper.map(typeDto, FacilityTypeEntity.class);
		facilityTypeEntity.setInsertUserEntity(userDtoHelper.mapToUserEntity(typeDto.getInsertUserDto()));
		facilityTypeEntity.setUpdateUserEntity(userDtoHelper.mapToUserEntity(typeDto.getInsertUserDto()));
		return facilityTypeEntity;
	}

	public List<FacilityTypeEntity> mapToFacilityTypeEntityList(List<FacilityTypeDto> typeDtoList) {
		List<FacilityTypeEntity> facilityTypeEntitylist = new ArrayList<FacilityTypeEntity>();
		for (FacilityTypeDto typeDto : typeDtoList) {
			FacilityTypeEntity facilityTypeEntity = this.mapToFacilityTypeEntity(typeDto);
			facilityTypeEntitylist.add(facilityTypeEntity);
		}
		return facilityTypeEntitylist;

	}
}
