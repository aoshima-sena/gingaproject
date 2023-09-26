package jp.co.ginga.web.domain.service.facilityReservation;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jp.co.ginga.infra.repository.facility.FacilityEntity;
import jp.co.ginga.infra.repository.reservation.ReservationEntity;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FacilityReservationManagerHelperTest {


	@Autowired
	FacilityReservationManagerHelper facilityReservationManagerHelper;

	@Test
	public void reservationEntityListToReservationManagerDto() {

		int facilityId = 1;
		String name = "会議室1";
		int capacity = 10;
		int reservationId = 3;
		String datetime = "2022-12-07 09:00:00";
		Timestamp startTime = Timestamp.valueOf(datetime);
		Timestamp endTime = Timestamp.valueOf(datetime);

		FacilityEntity facilityEntity = new FacilityEntity();
		facilityEntity.setFacilityId(facilityId);
		facilityEntity.setName(name);
		ReservationEntity entity = new ReservationEntity();
		entity.setReservationId(reservationId);
		entity.setStartTime(startTime);
		entity.setEndTime(endTime);
		entity.setFacilityEntity(facilityEntity);

		List<ReservationEntity> list = new ArrayList<ReservationEntity>();
		list.add(entity);

		FacilityReservationManagerDto result = facilityReservationManagerHelper.createReservationDto(list);

		assertEquals(reservationId,result.getReservationDtoList().get(0).getReservationId());
		assertEquals(startTime,result.getReservationDtoList().get(0).getStartTime());
		assertEquals(endTime,result.getReservationDtoList().get(0).getEndTime());
		assertEquals(facilityId,result.getReservationDtoList().get(0).getFacilityDto().getFacilityId());
		assertEquals(name,result.getReservationDtoList().get(0).getFacilityDto().getName());

	}

	@Test
	public void reservationEntityToFacilityReservationManagerDto() {
		int facilityId = 1;
		String name = "会議室1";
		int capacity = 10;
		int reservationId = 3;
		String datetime = "2022-12-07 09:00:00";
		Timestamp startTime = Timestamp.valueOf(datetime);
		Timestamp endTime = Timestamp.valueOf(datetime);

		FacilityEntity facilityEntity = new FacilityEntity();
		facilityEntity.setFacilityId(facilityId);
		facilityEntity.setName(name);
		ReservationEntity entity = new ReservationEntity();
		entity.setReservationId(reservationId);
		entity.setStartTime(startTime);
		entity.setEndTime(endTime);
		entity.setFacilityEntity(facilityEntity);

		FacilityReservationManagerDto result = facilityReservationManagerHelper.createFacilityReservationDto(entity);

		assertEquals(reservationId,result.getReservationDto().getReservationId());
		assertEquals(startTime,result.getReservationDto().getStartTime());
		assertEquals(endTime,result.getReservationDto().getEndTime());
		assertEquals(facilityId,result.getReservationDto().getFacilityDto().getFacilityId());
		assertEquals(name,result.getReservationDto().getFacilityDto().getName());
	}


	//このメソッドいらなくね？
	@Test
	public void reservationEntityAndListToFacilityReservationManagerDto() {

		int facilityId = 1;
		String name = "会議室1";
		int capacity = 10;
		int reservationId = 3;
		String datetime = "2022-12-07 09:00:00";
		Timestamp startTime = Timestamp.valueOf(datetime);
		Timestamp endTime = Timestamp.valueOf(datetime);

		FacilityEntity facilityEntity = new FacilityEntity();
		facilityEntity.setFacilityId(facilityId);
		facilityEntity.setName(name);
		ReservationEntity entity = new ReservationEntity();
		entity.setReservationId(reservationId);
		entity.setStartTime(startTime);
		entity.setEndTime(endTime);
		entity.setFacilityEntity(facilityEntity);
		List<ReservationEntity> list = new ArrayList<ReservationEntity>();
		list.add(entity);

		FacilityReservationManagerDto result = facilityReservationManagerHelper.createReservationDto(entity, list);

		assertEquals(reservationId,result.getReservationDto().getReservationId());

	}

	@Test
	public void facilityReservationManagerDtoToReservationentity() {
		int facilityId = 1;
		String name = "会議室1";
		int capacity = 10;
		int reservationId = 3;
		String datetime = "2022-12-07 09:00:00";
		Timestamp startTime = Timestamp.valueOf(datetime);
		Timestamp endTime = Timestamp.valueOf(datetime);
		String userId = "2";

		UserDto userDto = new UserDto();
		userDto.setUserId(userId);
		FacilityReservationDto reservationDto = new FacilityReservationDto();
		reservationDto.setReservationId(reservationId);
		reservationDto.setStartTime(startTime);
		reservationDto.setEndTime(endTime);
		FacilityDto facilityDto = new FacilityDto();
		facilityDto.setFacilityId(facilityId);
		facilityDto.setName(name);
		reservationDto.setFacilityDto(facilityDto);
		reservationDto.setUserDto(userDto);

		FacilityReservationManagerDto dto = new FacilityReservationManagerDto();
		dto.setReservationDto(reservationDto);

		ReservationEntity result = facilityReservationManagerHelper.getReservationEntity(dto);

		assertEquals(reservationId,result.getReservationId());
		assertEquals(startTime,result.getStartTime());
		assertEquals(endTime,result.getEndTime());
		assertEquals(facilityId,result.getFacilityEntity().getFacilityId());
		assertEquals(name,result.getFacilityEntity().getName());
		assertEquals(userId,result.getInsertUserEntity().getUserId());
	}


}
