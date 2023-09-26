package jp.co.ginga.web.domain.service.facilitytype;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.web.domain.service.util.constant.ServiceConst;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FacilityTypeManagerHelperTest {

	@Autowired
	FacilityTypeManagerHelper facilityTypeManagerHelper;
	int facilityId = 1;
	String name = "name";
	int capacity = 10;
	int facilityTypeId = 2;
	String typeName = "typeName";
	String datetime = "2022-12-07 09:00:00";
	Timestamp insertDate = Timestamp.valueOf(datetime);
	Timestamp updateDate = Timestamp.valueOf(datetime);
	String userId = "3";
	String userName = "user";
	String password = "12345";
	Timestamp passUPdateDate = Timestamp.valueOf(datetime);
	String gender = "osu";
	String birthday = "10/31";
	String contact = "住所";
	String mailAddress = "null@gmail.com";
	int loginMissTimes = 0;
	boolean unlock = true;
	boolean enabled = true;
	Timestamp userDueDate = Timestamp.valueOf(datetime);
	Timestamp insertUserDate = Timestamp.valueOf(datetime);
	Timestamp updateUserDate = Timestamp.valueOf(datetime);

	@Test
	public void createFacilityTypeServiceDtoTest() {
		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(facilityTypeId, typeName, null, null, null, null,
				null, null, enabled);
		List<FacilityTypeEntity> list = new ArrayList<FacilityTypeEntity>();
		list.add(facilityTypeEntity);
		FacilityTypeManagerDto result = facilityTypeManagerHelper.createFacilityTypeServiceDto(list);

		assertEquals(facilityTypeId, result.getFacilityTypeDtoList().get(0).getFacilityTypeId());
		assertEquals(typeName, result.getFacilityTypeDtoList().get(0).getName());
	}

	@Test
	public void createFacilityTypeServiceDtoEntityTest() {
		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(facilityTypeId, typeName, null, null, null, null,
				null, null, enabled);
		FacilityTypeManagerDto result = facilityTypeManagerHelper
				.createFacilityTypeServiceDto(facilityTypeEntity);

		assertEquals(facilityTypeId, result.getFacilityTypeDto().getFacilityTypeId());
		assertEquals(typeName, result.getFacilityTypeDto().getName());
	}

	@Test
	public void createFacilityTypeServiceDtoTestListAndEntity() {
		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(facilityTypeId, typeName, null, null, null, null,
				null, null, enabled);
		List<FacilityTypeEntity> list = new ArrayList<FacilityTypeEntity>();
		list.add(facilityTypeEntity);
		FacilityTypeManagerDto result = facilityTypeManagerHelper.createFacilityTypeServiceDto(facilityTypeEntity,
				list);

		assertEquals(facilityTypeId, result.getFacilityTypeDto().getFacilityTypeId());
		assertEquals(typeName, result.getFacilityTypeDto().getName());
		assertEquals(facilityTypeId, result.getFacilityTypeDtoList().get(0).getFacilityTypeId());
		assertEquals(typeName, result.getFacilityTypeDtoList().get(0).getName());
	}

	@Test
	public void getFacilityTypeEntityTest() {
		UserDto userDto = new UserDto(userId, birthday, birthday, insertDate, birthday, birthday, birthday, birthday,
				capacity, enabled, enabled, insertDate, insertDate, insertDate, null);
		FacilityTypeDto typeDto = new FacilityTypeDto(facilityTypeId, typeName, insertDate, userDto);
		FacilityTypeManagerDto managerDto = new FacilityTypeManagerDto();
		managerDto.setFacilityTypeDto(typeDto);

		FacilityTypeEntity result = facilityTypeManagerHelper.getFacilityTypeEntity(managerDto);

		assertEquals(facilityTypeId, result.getFacilityTypeId());
		assertEquals(typeName, result.getName());
	}

	@Test
	public void createFacilityTypeServiceDtoAddTest1() {
		int result = 1;
		FacilityTypeManagerDto dto = facilityTypeManagerHelper.createFacilityTypeServiceDtoAdd(result);

		assertEquals(ServiceConst.THERE_IS_DATA, dto.getResult());
	}

	@Test
	public void createFacilityTypeServiceDtoAddTest2() {
		int result = 2;
		FacilityTypeManagerDto dto = facilityTypeManagerHelper.createFacilityTypeServiceDtoAdd(result);

		assertEquals(ServiceConst.NO_DATA, dto.getResult());
	}

	@Test
	public void getFacilityTypeDtoTest() {
		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(facilityTypeId, typeName, null, null, null, null,
				null, null, enabled);
		FacilityTypeDto result = facilityTypeManagerHelper.getFacilityTypeDto(facilityTypeEntity);

		assertEquals(facilityTypeId, result.getFacilityTypeId());
		assertEquals(typeName, result.getName());
	}

	@Test
	public void createFacilitytypeManagerServiceDtoTest() {
		FacilityTypeEntity typeEntity = new FacilityTypeEntity(facilityTypeId, typeName, null, null, null, null, null,
				null, enabled);
		FacilityTypeManagerDto result = facilityTypeManagerHelper.createFacilityTypeManagerServiceDto(typeEntity);

		assertEquals(facilityTypeId, result.getFacilityTypeDto().getFacilityTypeId());
		assertEquals(typeName, result.getFacilityTypeDto().getName());
	}

	@Test
	public void getFacilityTyepListTest() {
		FacilityTypeEntity typeEntity = new FacilityTypeEntity(facilityTypeId, typeName, null, null, null, null, null,
				null, enabled);
		List<FacilityTypeEntity> list = new ArrayList<FacilityTypeEntity>();
		list.add(typeEntity);
		List<FacilityTypeDto> result = facilityTypeManagerHelper.getFacilityTypeList(list);

		assertEquals(facilityTypeId, result.get(0).getFacilityTypeId());
		assertEquals(typeName, result.get(0).getName());
	}

}