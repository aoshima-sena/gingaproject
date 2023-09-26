package jp.co.ginga.web.domain.service.util.helper.facilityReservation;

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
import jp.co.ginga.infra.repository.user.UserEntity;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;
import jp.co.ginga.web.domain.service.util.helper.reservation.FacilityReservationDtoHelper;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FacilityReservationDtoHelperTest {

	@Autowired
	FacilityReservationDtoHelper reservationDtoHelper;

	@Test
	public void testmapToFacilityReservationDto() {

		String datetime = "2019-05-01 01:02:03";

		int reservationId = 1;
		Timestamp startTime = Timestamp.valueOf(datetime);
		Timestamp endTime = Timestamp.valueOf(datetime);
		int facilityId = 1;
		String name = "会議室";
		String userId = "ユーザー";

		FacilityEntity facilityEntity = new FacilityEntity();
		facilityEntity.setFacilityId(facilityId);
		facilityEntity.setName(name);
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(userId);
		ReservationEntity reservationEntity = new ReservationEntity(reservationId, startTime, endTime, facilityEntity,null , userEntity, null, null);

		FacilityReservationDto result = reservationDtoHelper.mapToFacilityReservationDto(reservationEntity);

		assertEquals(reservationId,result.getReservationId());
		assertEquals(startTime,result.getStartTime());
		assertEquals(endTime,result.getEndTime());
		assertEquals(facilityId,result.getFacilityDto().getFacilityId());
		assertEquals(name,result.getFacilityDto().getName());
	//	assertEquals(userId,result.getUserDto().getUserId());

	}

	@Test
	public void testmapToFacilityReservationDtoList() {

		String datetime = "2019-05-01 01:02:03";

		int reservationId = 1;
		Timestamp startTime = Timestamp.valueOf(datetime);
		Timestamp endTime = Timestamp.valueOf(datetime);
		int facilityId = 1;
		String name = "会議室";
		String userId = "ユーザー";

		FacilityEntity facilityEntity = new FacilityEntity();
		facilityEntity.setFacilityId(facilityId);
		facilityEntity.setName(name);
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(userId);
		ReservationEntity reservationEntity = new ReservationEntity(reservationId, startTime, endTime, facilityEntity,null , userEntity, null, null);
		List<ReservationEntity> entityList = new ArrayList<ReservationEntity>();
		entityList.add(reservationEntity);

		List<FacilityReservationDto> result = reservationDtoHelper.mapToFacilityReservationDtoList(entityList);

		assertEquals(1,result.size());
		assertEquals(reservationId,result.get(0).getReservationId());
		assertEquals(startTime,result.get(0).getStartTime());
		assertEquals(endTime,result.get(0).getEndTime());
		assertEquals(facilityId,result.get(0).getFacilityDto().getFacilityId());
		assertEquals(name,result.get(0).getFacilityDto().getName());
	}

	@Test
	public void testcreateReservationDto() {

		String datetime = "2019-05-01 01:02:03";

		int reservationId = 1;
		Timestamp startTime = Timestamp.valueOf(datetime);
		Timestamp endTime = Timestamp.valueOf(datetime);
		int facilityId = 1;
		String name = "会議室";
		String userId = "ユーザー";

		FacilityDto facilityDto = new FacilityDto();
		facilityDto.setFacilityId(facilityId);
		facilityDto.setName(name);
		UserDto userDto = new UserDto();
		userDto.setUserId(userId);
		FacilityReservationDto dto = new FacilityReservationDto();
		dto.setFacilityDto(facilityDto);
		dto.setUserDto(userDto);
		dto.setReservationId(reservationId);
		dto.setStartTime(startTime);
		dto.setEndTime(endTime);

		ReservationEntity result = reservationDtoHelper.mapToReservationEntity(dto);

		assertEquals(reservationId,result.getReservationId());
		assertEquals(startTime,result.getStartTime());
		assertEquals(endTime,result.getEndTime());
		assertEquals(facilityId,result.getFacilityEntity().getFacilityId());
		assertEquals(name,result.getFacilityEntity().getName());
		assertEquals(userId,result.getInsertUserEntity().getUserId());
		assertEquals(userId,result.getUpdateUserEntity().getUserId());
	}

	@Test
	public void testList() {
		String datetime = "2019-05-01 01:02:03";

		int reservationId = 1;
		Timestamp startTime = Timestamp.valueOf(datetime);
		Timestamp endTime = Timestamp.valueOf(datetime);
		int facilityId = 1;
		String name = "会議室";
		String userId = "ユーザー";

		FacilityDto facilityDto = new FacilityDto();
		facilityDto.setFacilityId(facilityId);
		facilityDto.setName(name);
		UserDto userDto = new UserDto();
		userDto.setUserId(userId);
		FacilityReservationDto dto = new FacilityReservationDto();
		dto.setFacilityDto(facilityDto);
		dto.setUserDto(userDto);
		dto.setReservationId(reservationId);
		dto.setStartTime(startTime);
		dto.setEndTime(endTime);

		List<FacilityReservationDto> relist = new ArrayList<FacilityReservationDto>();
		relist.add(dto);

		List<ReservationEntity> result = reservationDtoHelper.mapToReservationEntityList(relist);
		assertEquals(reservationId,result.get(0).getReservationId());
		assertEquals(startTime,result.get(0).getStartTime());
		assertEquals(endTime,result.get(0).getEndTime());
		assertEquals(facilityId,result.get(0).getFacilityEntity().getFacilityId());
		assertEquals(name,result.get(0).getFacilityEntity().getName());
		assertEquals(userId,result.get(0).getInsertUserEntity().getUserId());
		assertEquals(userId,result.get(0).getUpdateUserEntity().getUserId());

	}
}
