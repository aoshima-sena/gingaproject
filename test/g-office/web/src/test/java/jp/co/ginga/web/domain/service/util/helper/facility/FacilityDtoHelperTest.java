package jp.co.ginga.web.domain.service.util.helper.facility;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jp.co.ginga.infra.repository.facility.FacilityEntity;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.infra.repository.user.UserEntity;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FacilityDtoHelperTest {

	@Autowired
	FacilityDtoHelper facilityDtoHelper;

	@Test
	public void testMapToFacilityDto() {

		String datetime = "2019-05-01 01:02:03";

		int f_facility_id = 1;
		String f_name = "会議室";
		int f_capacity = 10;
		FacilityTypeEntity f_facility_type_id = null;
		Timestamp f_insert_date = Timestamp.valueOf(datetime);
		;
		UserEntity f_user_id = null;
		Timestamp f_update_date = Timestamp.valueOf(datetime);
		;
		UserEntity f_update_user_id = null;

		int ft_facility_type_id = 1;
		String ft_name = "会議室";
		Date ft_insert_date = null;
		UserEntity ft_user_id = null;
		Date ft_update_date = null;
		UserEntity ft_update_user_id = null;
		Date ft_delete_date = null;
		UserEntity ft_delete_user_id = null;
		boolean ft_fg_delete = true;
		String ft_to_string = null;

		String u_userId = "test";

		String u_userName = "テストユーザー";
		String u_password = "pass1";
		Timestamp u_passUpdateDate = null;
		String u_gender = "男";
		String u_birthday = "2021-04-01";
		String u_contact = "090-1234-5678";
		String u_mailAddress = "test@xxx.co.jp";
		int u_loginMissTimes = 0;
		boolean u_unlock = true;
		boolean u_enabled = true;
		Timestamp u_userDueDate = null;
		Timestamp u_insertDate = null;
		Timestamp u_updateDate = null;
		String ur_roleId1 = "tests2";

		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(ft_facility_type_id, ft_name, ft_insert_date,
				ft_user_id, ft_update_date, ft_update_user_id, ft_delete_date, ft_delete_user_id, ft_fg_delete);

		UserEntity userEntity = new UserEntity(u_userId, u_mailAddress, u_contact, u_updateDate, u_birthday, u_gender,
				u_password, u_userName, u_loginMissTimes, u_enabled, u_unlock, u_insertDate, u_userDueDate,
				u_passUpdateDate);
		FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity,
				facilityTypeEntity, f_insert_date, userEntity, f_update_date, f_update_user_id);

		FacilityDto result = facilityDtoHelper.mapToFacilityDto(facilityEntity);

		//EntityからDtoへの処理なのでinsertdateなどの時間は受け取ることができない
		assertEquals(f_facility_id, result.getFacilityId());
		assertEquals(f_name, result.getName());
		assertEquals(f_capacity, result.getCapacity());
		assertEquals(ft_facility_type_id, result.getFacilityTypeDto().getFacilityTypeId());

	}

	@Test
	public void testMapToFacilityDtoNO() {

		FacilityEntity facilityEntity = new FacilityEntity();

		FacilityDto result = facilityDtoHelper.mapToFacilityDto(facilityEntity);

		assertEquals(0, result.getFacilityId());
		assertNull(result.getName());
		assertEquals(0, result.getCapacity());

	}

	//FacilityTypeIdがnullの時
	@Test
	public void testMapToFacilityDtoNo2() {

		String datetime = "2019-05-01 01:02:03";

		int f_facility_id = 1;
		String f_name = "会議室";
		int f_capacity = 10;
		FacilityTypeEntity f_facility_type_id = null;
		Timestamp f_insert_date = Timestamp.valueOf(datetime);
		;
		UserEntity f_user_id = null;
		Timestamp f_update_date = Timestamp.valueOf(datetime);
		;
		UserEntity f_update_user_id = null;

		int ft_facility_type_id = 1;
		String ft_name = "会議室";
		Date ft_insert_date = null;
		UserEntity ft_user_id = null;
		Date ft_update_date = null;
		UserEntity ft_update_user_id = null;
		Date ft_delete_date = null;
		UserEntity ft_delete_user_id = null;
		boolean ft_fg_delete = true;
		String ft_to_string = null;

		String u_userId = "test";

		String u_userName = "テストユーザー";
		String u_password = "pass1";
		Timestamp u_passUpdateDate = null;
		String u_gender = "男";
		String u_birthday = "2021-04-01";
		String u_contact = "090-1234-5678";
		String u_mailAddress = "test@xxx.co.jp";
		int u_loginMissTimes = 0;
		boolean u_unlock = true;
		boolean u_enabled = true;
		Timestamp u_userDueDate = null;
		Timestamp u_insertDate = null;
		Timestamp u_updateDate = null;
		String ur_roleId1 = "tests2";

		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity();

		UserEntity userEntity = new UserEntity(u_userId, u_mailAddress, u_contact, u_updateDate, u_birthday, u_gender,
				u_password, u_userName, u_loginMissTimes, u_enabled, u_unlock, u_insertDate, u_userDueDate,
				u_passUpdateDate);
		FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity,
				facilityTypeEntity, f_insert_date, userEntity, f_update_date, f_update_user_id);

		FacilityDto result = facilityDtoHelper.mapToFacilityDto(facilityEntity);

		//EntityからDtoへの処理なのでinsertdateなどの時間は受け取ることができない
		assertEquals(f_facility_id, result.getFacilityId());
		assertEquals(f_name, result.getName());
		assertEquals(f_capacity, result.getCapacity());
		assertEquals(0, result.getFacilityTypeDto().getFacilityTypeId());

	}

	//mapToFacilityDtoList

	@Test
	public void mapToFacilityDtoListTest() {
		String datetime = "2019-05-01 01:02:03";

		int f_facility_id = 1;
		String f_name = "会議室";
		int f_capacity = 10;
		FacilityTypeEntity f_facility_type_id = null;
		Timestamp f_insert_date = Timestamp.valueOf(datetime);
		;
		UserEntity f_user_id = null;
		Timestamp f_update_date = Timestamp.valueOf(datetime);
		;
		UserEntity f_update_user_id = null;

		int ft_facility_type_id = 1;
		String ft_name = "会議室";
		Date ft_insert_date = null;
		UserEntity ft_user_id = null;
		Date ft_update_date = null;
		UserEntity ft_update_user_id = null;
		Date ft_delete_date = null;
		UserEntity ft_delete_user_id = null;
		boolean ft_fg_delete = true;
		String ft_to_string = null;

		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(ft_facility_type_id, ft_name, ft_insert_date,
				ft_user_id, ft_update_date, ft_update_user_id, ft_delete_date, ft_delete_user_id, ft_fg_delete);
		FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity, facilityTypeEntity,
				f_insert_date, f_user_id, f_update_date, f_update_user_id);
		List<FacilityEntity> facilityEntityList = new ArrayList<FacilityEntity>();
		facilityEntityList.add(facilityEntity);

		List<FacilityDto> result = facilityDtoHelper.mapToFacilityDtoList(facilityEntityList);

		assertEquals(1, result.size());
		assertEquals(f_facility_id, result.get(0).getFacilityId());
		assertEquals(f_name, result.get(0).getName());
		assertEquals(f_capacity, result.get(0).getCapacity());
		assertEquals(ft_facility_type_id, result.get(0).getFacilityTypeDto().getFacilityTypeId());
	}

	@Test
	public void mapToFacilityDtoListTestNO() {

		List<FacilityEntity> facilityEntityList = new ArrayList<FacilityEntity>();

		List<FacilityDto> result = facilityDtoHelper.mapToFacilityDtoList(facilityEntityList);

		assertEquals(0, result.size());

	}

	@Test
	public void mapToFacilityEntity() {
		int f_facility_id = 1;
		String f_name = "会議室";
		int f_capacity = 10;
		int ft_facility_type_id = 1;
		String userId = "1";

		FacilityTypeDto facilityTypeDto = new FacilityTypeDto();
		facilityTypeDto.setFacilityTypeId(ft_facility_type_id);
		UserDto userDto = new UserDto();
		userDto.setUserId(userId);

		FacilityDto dto = new FacilityDto(f_facility_id, f_name, f_capacity, facilityTypeDto, userDto);

		FacilityEntity result = facilityDtoHelper.mapToFacilityEntity(dto);

		assertEquals(f_facility_id, result.getFacilityId());
		assertEquals(f_name, result.getName());
		assertEquals(f_capacity, result.getCapacity());
		assertEquals(ft_facility_type_id, result.getFacilityTypeEntity().getFacilityTypeId());
		assertEquals(userId, result.getInsertUserEntity().getUserId());
		assertEquals(userId, result.getUpdateUserEntity().getUserId());
	}

	//例外のテストになるためやらなくてもいい…
	@Test
	public void mapToFacilityEntityNO() {
		FacilityDto facilityDto = new FacilityDto();

		IllegalArgumentException result = assertThrows(IllegalArgumentException.class,
				() -> facilityDtoHelper.mapToFacilityEntity(facilityDto));
		assertEquals("source cannot be null", result.getMessage());

		//ジャンケン課題テストで出たから試しにやったけどきいろになった
		assertThrows(IllegalArgumentException.class, () -> facilityDtoHelper.mapToFacilityEntity(facilityDto));

		//		FacilityEntity result = facilityDtoHelper.mapToFacilityEntity(facilityDto);
		//
		//		assertEquals(0, result.getFacilityId());
		//		assertNull(result.getName());
		//		assertEquals(0, result.getCapacity());
		//		assertEquals(0, result.getFacilityTypeEntity().getFacilityTypeId());
		//		assertNull(result.getInsertUserEntity().getUserId());
		//		assertNull(result.getUpdateUserEntity().getUserId());
	}

	@Test
	public void mapTofacilityEntityListTest() {
		int f_facility_id = 1;
		String f_name = "会議室";
		int f_capacity = 10;
		int ft_facility_type_id = 1;
		String userId = "1";

		FacilityTypeDto typeDto = new FacilityTypeDto();
		typeDto.setFacilityTypeId(ft_facility_type_id);
		UserDto userDto = new UserDto();
		userDto.setUserId(userId);

		FacilityDto dto = new FacilityDto(f_facility_id, f_name, f_capacity, typeDto, userDto);
		List<FacilityDto> facilityDtoList = new ArrayList<FacilityDto>();
		facilityDtoList.add(dto);

		List<FacilityEntity> result = facilityDtoHelper.mapTofacilityEntityList(facilityDtoList);

		assertEquals(f_facility_id, result.get(0).getFacilityId());
		assertEquals(f_name, result.get(0).getName());
		assertEquals(f_capacity, result.get(0).getCapacity());
		assertEquals(ft_facility_type_id, result.get(0).getFacilityTypeEntity().getFacilityTypeId());
		assertEquals(userId, result.get(0).getInsertUserEntity().getUserId());
		assertEquals(userId, result.get(0).getUpdateUserEntity().getUserId());
	}

	@Test
	public void mapTofacilityEntityListNOTest() {

		List<FacilityDto> facilityDtolist = new ArrayList<FacilityDto>();

		List<FacilityEntity> list = facilityDtoHelper.mapTofacilityEntityList(facilityDtolist);

		assertEquals(0, list.size());
	}
}
