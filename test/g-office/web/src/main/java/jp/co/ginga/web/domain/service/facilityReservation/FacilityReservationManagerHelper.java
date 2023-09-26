package jp.co.ginga.web.domain.service.facilityReservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.infra.repository.facility.FacilityEntity;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.infra.repository.reservation.ReservationEntity;
import jp.co.ginga.web.domain.service.util.constant.ServiceConst;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;
import jp.co.ginga.web.domain.service.util.helper.facility.FacilityDtoHelper;
import jp.co.ginga.web.domain.service.util.helper.facilitytype.FacilityTypeDtoHelper;
import jp.co.ginga.web.domain.service.util.helper.reservation.FacilityReservationDtoHelper;

@Component
public class FacilityReservationManagerHelper {

	@Autowired
	FacilityReservationDtoHelper reservationDtoHelper;
	@Autowired
	FacilityDtoHelper facilityDtoHelper;
	@Autowired
	FacilityTypeDtoHelper facilityTypeDtoHelper;

	public FacilityReservationManagerDto createReservationDto(List<ReservationEntity> reservationList) {
		FacilityReservationManagerDto dto = FacilityReservationManagerDto.getInstance();
		dto.setReservationDtoList(reservationDtoHelper.mapToFacilityReservationDtoList(reservationList));

		return dto;
	}

	public FacilityReservationManagerDto createReservationDto(ReservationEntity entity) {
		FacilityReservationManagerDto dto = FacilityReservationManagerDto.getInstance();
		dto.setReservationDto(reservationDtoHelper.mapToFacilityReservationDto(entity));

		return dto;
	}

	public FacilityReservationManagerDto createReservationDto(ReservationEntity entity, List<ReservationEntity> entityList) {
		FacilityReservationManagerDto dto = createReservationDto(entity);
		dto.setReservationDtoList(reservationDtoHelper.mapToFacilityReservationDtoList(entityList));

		return dto;
	}

	//dtoからentityへ
	public ReservationEntity getReservationEntity(FacilityReservationManagerDto dto) {
		ReservationEntity entity = reservationDtoHelper.mapToReservationEntity(dto.getReservationDto());

		return entity;
	}

	public FacilityReservationManagerDto createReservationDtoAdd(int result) {
		FacilityReservationManagerDto dto = FacilityReservationManagerDto.getInstance();
		switch (result) {
		case 1:
			dto.setResult(ServiceConst.THERE_IS_DATA);
			break;
		case 0:
			dto.setResult(ServiceConst.NO_DATA);
			break;
		default:
			dto.setResult(ServiceConst.ERROR);
			break;
		}

		return dto;
	}

	public FacilityReservationDto getReservationDto(ReservationEntity entity) {
		FacilityReservationDto dto = reservationDtoHelper.mapToFacilityReservationDto(entity);

		return dto;
	}

	public FacilityReservationManagerDto createFacilityReservationDto(ReservationEntity entity) {
		FacilityReservationDto dto = reservationDtoHelper.mapToFacilityReservationDto(entity);
		FacilityReservationManagerDto reservationDto = FacilityReservationManagerDto.getInstance();
		reservationDto.setReservationDto(dto);
		if (dto == null) {
			reservationDto.setResult(ServiceConst.NO_DATA);
		}
		return reservationDto;
	}

	public List<FacilityReservationDto> getReservationList(List<ReservationEntity> reservationEntityList) {
		List<FacilityReservationDto> list = reservationDtoHelper.mapToFacilityReservationDtoList(reservationEntityList);

		return list;
	}

	public FacilityReservationManagerDto getFacilityEntityFndFacilityTypeList(FacilityEntity facilityEntity,List<FacilityTypeEntity> facilityTypeEntityList) {
		FacilityReservationManagerDto dto = FacilityReservationManagerDto.getInstance();
		dto.setFacilityDto(facilityDtoHelper.mapToFacilityDto(facilityEntity));
		dto.setFacilityTypeDtoList(facilityTypeDtoHelper.mapToFacilityTypeDtoList(facilityTypeEntityList));

		return dto;
	}

	public FacilityReservationManagerDto getFacilityEntity(FacilityEntity facilityEntity) {
		FacilityReservationManagerDto dto = FacilityReservationManagerDto.getInstance();
		dto.setFacilityDto(facilityDtoHelper.mapToFacilityDto(facilityEntity));
		return dto;
	}
}
