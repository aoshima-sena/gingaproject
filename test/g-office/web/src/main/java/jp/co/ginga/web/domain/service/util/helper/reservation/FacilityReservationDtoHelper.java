package jp.co.ginga.web.domain.service.util.helper.reservation;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.infra.repository.facility.FacilityEntity;
import jp.co.ginga.infra.repository.reservation.ReservationEntity;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;
import jp.co.ginga.web.domain.service.util.helper.user.UserDtoHelper;

@Component
public class FacilityReservationDtoHelper {
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	UserDtoHelper userDtoHelper;

	public FacilityReservationDto mapToFacilityReservationDto(ReservationEntity entity) {
		//map先が曖昧なときは無視する↓
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		FacilityReservationDto dto = modelMapper.map(entity, FacilityReservationDto.class);

		if (entity.getFacilityEntity() != null) {
			FacilityDto facilityDto = modelMapper.map(entity.getFacilityEntity(), FacilityDto.class);
			dto.setFacilityDto(facilityDto);
		}

		return dto;
	}

	public List<FacilityReservationDto> mapToFacilityReservationDtoList(List<ReservationEntity> entityList) {
		List<FacilityReservationDto> dtoList = new ArrayList<FacilityReservationDto>();
		for (ReservationEntity entity : entityList) {
			FacilityReservationDto dto = this.mapToFacilityReservationDto(entity);
			dtoList.add(dto);
		}
		return dtoList;
	}

	public ReservationEntity mapToReservationEntity(FacilityReservationDto dto) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);

		ReservationEntity entity = modelMapper.map(dto, ReservationEntity.class);

		if (dto.getFacilityDto() != null) {
			FacilityEntity ent = modelMapper.map(dto.getFacilityDto(), FacilityEntity.class);
			entity.setFacilityEntity(ent);
			userDtoHelper.mapToUserEntity(dto.getUserDto());
		}

		entity.setInsertUserEntity(userDtoHelper.mapToUserEntity(dto.getUserDto()));
		entity.setUpdateUserEntity(userDtoHelper.mapToUserEntity(dto.getUserDto()));

		return entity;
	}

	public List<ReservationEntity> mapToReservationEntityList(List<FacilityReservationDto> reservationList) {
		List<ReservationEntity> entityList = new ArrayList<ReservationEntity>();
		for (FacilityReservationDto dto : reservationList) {
			ReservationEntity entity = this.mapToReservationEntity(dto);
			entityList.add(entity);
		}
		return entityList;
	}
}
