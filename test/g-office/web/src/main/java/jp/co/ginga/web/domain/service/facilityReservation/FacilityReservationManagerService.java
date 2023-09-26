package jp.co.ginga.web.domain.service.facilityReservation;

import java.sql.Timestamp;

import jp.co.ginga.infra.repository.facility.FacilityRepository;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeRepository;
import jp.co.ginga.infra.repository.reservation.ReservationEntity;
import jp.co.ginga.infra.repository.reservation.ReservationRepository;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerDto;

public interface FacilityReservationManagerService {

	public FacilityReservationManagerDto getFacilityList();

	public FacilityReservationManagerDto getFacilityByFacilityTypeId(int facilityTypeId);

	public FacilityReservationManagerDto getReservationId(ReservationEntity reservationEntity);

	public FacilityReservationManagerDto getFacilityIdAndStartDateBetween(int facilityId, Timestamp startTime,
			Timestamp endTime);

	public int getCanMakeReservation(int facilityId, Timestamp startTime, Timestamp endTime);

	public FacilityReservationManagerDto add(FacilityReservationManagerDto dto);

	public FacilityReservationManagerDto update(FacilityReservationManagerDto dto);

	public FacilityReservationManagerDto delete(FacilityReservationManagerDto dto);

	void setFacilityRepository(FacilityRepository facilityRepository);

	void setFacilityTypeRepository(FacilityTypeRepository facilityTypeRepository);

	public FacilityReservationManagerDto getFacilityByFacilityTypeId(FacilityTypeEntity f_facility_type_id);

	public FacilityTypeManagerDto getFacilityTypeDetailByFacilityTypeId(int ft_facility_type_id);

	public void setReservationRepository(ReservationRepository repository);

	public FacilityReservationManagerDto getFacilityDetailByFacilityId(int facilityId);



	public FacilityReservationManagerDto findStartEnd(int facilityId);

//	FacilityReservationManagerDto getReservationId(FacilityReservationManagerDto facilityReservationManagerDto);

	FacilityReservationManagerDto getReservationId(int reservationId);

	FacilityReservationManagerDto reservationId(int facilityId, Timestamp startTime, Timestamp endTime);

	FacilityReservationManagerDto getfindOneById(ReservationEntity entity);

}
