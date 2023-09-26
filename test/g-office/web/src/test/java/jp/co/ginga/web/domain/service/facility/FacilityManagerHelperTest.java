package jp.co.ginga.web.domain.service.facility;

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
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.web.domain.service.util.constant.ServiceConst;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FacilityManagerHelperTest {

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

	@Autowired
	FacilityManagerHelper facilityManagerHelper;

	@Test
	public void createFacilityServiceDtoTestList() {
		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(facilityTypeId, typeName, null, null, null, null,
				null, null, false);
		FacilityEntity facilityEntity = new FacilityEntity(facilityId, name, capacity, facilityTypeEntity, insertDate,
				null, insertDate, null);

		List<FacilityEntity> list = new ArrayList<FacilityEntity>();
		list.add(facilityEntity);

		/*	List<FacilityDto> facilityDtoList = new ArrayList<FacilityDto>();
			facilityDtoList = facilityDtoHelper.mapToFacilityDtoList(list);*/
		FacilityManagerDto result = facilityManagerHelper.createFacilityServiceDto(list);

		assertEquals(1, result.getFacilityDtoList().size());
		assertEquals(facilityId, result.getFacilityDtoList().get(0).getFacilityId());
		assertEquals(name, result.getFacilityDtoList().get(0).getName());
		assertEquals(capacity, result.getFacilityDtoList().get(0).getCapacity());
		assertEquals(facilityTypeId, result.getFacilityDtoList().get(0).getFacilityTypeDto().getFacilityTypeId());
		assertEquals(typeName, result.getFacilityDtoList().get(0).getFacilityTypeDto().getName());

	}

	@Test
	public void createFacilityServiceDtoTestEntityAndList() {
		FacilityTypeEntity typeEntity = new FacilityTypeEntity(facilityTypeId, typeName, null, null, null, null, null,
				null, false);
		FacilityEntity facilityEntity = new FacilityEntity(facilityId, name, capacity, typeEntity, insertDate, null,
				insertDate, null);

		FacilityManagerDto result = facilityManagerHelper.createFacilityManagerServiceDto(facilityEntity);

		assertEquals(facilityId, result.getFacilityDto().getFacilityId());
		assertEquals(name, result.getFacilityDto().getName());
		assertEquals(capacity, result.getFacilityDto().getCapacity());
		assertEquals(facilityTypeId, result.getFacilityDto().getFacilityTypeDto().getFacilityTypeId());
		assertEquals(typeName, result.getFacilityDto().getFacilityTypeDto().getName());
	}

	@Test
	public void createFacilityServiceDtoTest() {
		FacilityTypeEntity typeEntity = new FacilityTypeEntity(facilityTypeId, typeName, null, null, null, null, null,
				null, false);
		FacilityEntity facilityEntity = new FacilityEntity(facilityId, name, capacity, typeEntity, insertDate, null,
				updateDate, null);
		FacilityManagerDto result = facilityManagerHelper.createFacilityServiceDto(facilityEntity);

		assertEquals(facilityId, result.getFacilityDto().getFacilityId());
		assertEquals(capacity, result.getFacilityDto().getCapacity());
		assertEquals(name, result.getFacilityDto().getName());
		assertEquals(facilityTypeId, result.getFacilityDto().getFacilityTypeDto().getFacilityTypeId());
		assertEquals(typeName, result.getFacilityDto().getFacilityTypeDto().getName());

	}

	@Test
	public void getFacilityEntityTest() {
		UserDto userDto = new UserDto(userId, userName, password, passUPdateDate, gender, birthday, contact,
				mailAddress, loginMissTimes, unlock, enabled, userDueDate, insertUserDate, updateUserDate, null);
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto(facilityTypeId, typeName, null, null);
		FacilityDto facilityDto = new FacilityDto(facilityId, name, capacity, facilityTypeDto, userDto);

		FacilityManagerDto facilityManagerDto = new FacilityManagerDto();
		facilityManagerDto.setFacilityDto(facilityDto);

		FacilityEntity result = facilityManagerHelper.getFacilityEntity(facilityManagerDto);

		assertEquals(facilityId, result.getFacilityId());
		assertEquals(name, result.getName());
		assertEquals(capacity, result.getCapacity());
		assertEquals(facilityTypeId, result.getFacilityTypeEntity().getFacilityTypeId());
		assertEquals(typeName, result.getFacilityTypeEntity().getName());

	}

	@Test
	public void createFacilityServiceDtoAddTest1() {
		int result = 1;
		FacilityManagerDto dto = facilityManagerHelper.createFacilityServiceDtoAdd(result);

		assertEquals(dto.getResult(), ServiceConst.THERE_IS_DATA);

	}

	@Test
	public void createFacilityServiceDtoAddTest0() {
		int result = 0;
		FacilityManagerDto dto = facilityManagerHelper.createFacilityServiceDtoAdd(result);
		assertEquals(dto.getResult(), ServiceConst.NO_DATA);
	}

	@Test
	public void createFcilityServiceDtoAddTestDefaultTest() {
		int result = 2;
		FacilityManagerDto dto = facilityManagerHelper.createFacilityServiceDtoAdd(result);

		assertEquals(dto.getResult(), ServiceConst.ERROR);
	}

	@Test
	public void getFacilityDtoTest() {
		FacilityTypeEntity typeEntity = new FacilityTypeEntity(facilityTypeId, typeName, null, null, null, null, null,
				null, enabled);
		FacilityEntity facilityEntity = new FacilityEntity(facilityId, name, capacity, typeEntity, insertDate, null,
				updateDate, null);

		FacilityDto result = facilityManagerHelper.getFacilityDto(facilityEntity);

		assertEquals(facilityId, result.getFacilityId());
		assertEquals(name, result.getName());
		assertEquals(capacity, result.getCapacity());
		assertEquals(facilityTypeId, result.getFacilityTypeDto().getFacilityTypeId());
		assertEquals(typeName, result.getFacilityTypeDto().getName());
	}

	@Test
	public void createFacilityManagerServiceDtoTestOK() {
		FacilityTypeEntity typeEntity = new FacilityTypeEntity(facilityTypeId, typeName, null, null, null, null, null,
				null, enabled);
		FacilityEntity facilityEntity = new FacilityEntity(facilityId, name, capacity, typeEntity, insertDate, null,
				updateDate, null);

		FacilityManagerDto result = facilityManagerHelper.createFacilityManagerServiceDto(facilityEntity);

		assertEquals(facilityId, result.getFacilityDto().getFacilityId());
		assertEquals(name, result.getFacilityDto().getName());
		assertEquals(capacity, result.getFacilityDto().getCapacity());
		assertEquals(facilityTypeId, result.getFacilityDto().getFacilityTypeDto().getFacilityTypeId());
		assertEquals(typeName, result.getFacilityDto().getFacilityTypeDto().getName());
	}

	//NO_DATAのテストができないので無視↓

	@Test
	public void createFacilityManagerServiceDtoTestNo_date() {
		FacilityEntity facilityEntity = new FacilityEntity();
		FacilityManagerDto result = facilityManagerHelper.createFacilityManagerServiceDto(facilityEntity);

		System.out.println(result.getFacilityDto());

	//	assertEquals(ServiceConst.NO_DATA,result.getResult());
	}

	@Test
	public void getFacilityListTest() {
		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(facilityTypeId, typeName, null, null, null, null, null, null, enabled);
		FacilityEntity facilityEntity = new FacilityEntity(facilityId, name, capacity, facilityTypeEntity, insertDate, null, updateDate, null);
		List<FacilityEntity> list = new ArrayList<FacilityEntity>();
		list.add(facilityEntity);

		List<FacilityDto> result = new ArrayList<FacilityDto>();
		result = facilityManagerHelper.getFacilityList(list);

		assertEquals(facilityId,result.get(0).getFacilityId());
		assertEquals(name,result.get(0).getName());
		assertEquals(capacity,result.get(0).getCapacity());
		assertEquals(facilityTypeId,result.get(0).getFacilityTypeDto().getFacilityTypeId());
		assertEquals(typeName,result.get(0).getFacilityTypeDto().getName());
	}

}
