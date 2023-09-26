package jp.co.ginga.web.application.controller.facility.detail;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import jp.co.ginga.web.application.util.helper.facility.FacilityFormHelper;
import jp.co.ginga.web.application.util.session.facility.FacilitySession;
import jp.co.ginga.web.domain.service.facility.FacilityManagerDto;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerDto;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FacilityDetailFormHelperTest {

	@Autowired
	FacilityDetailHelper facilityDetailHelper;
	@Autowired
	FacilityFormHelper facilityFormHelper;

	//FacilitySession
	@Test
	public void createFacilityDetailFormTestOk() {

		int facilityId = 1;
		String name = "会議室";
		String capacity = "10";
		int facilityTypeId = 1;
		String typeName = "部屋";

		FacilitySession facilitySession = new FacilitySession();
		FacilityTypeForm facilityTypeForm = new FacilityTypeForm(facilityTypeId, typeName);
		FacilityForm facilityForm = new FacilityForm(facilityId, name, capacity, facilityTypeForm);
		List<FacilityTypeForm> facilityTypeFormList = new ArrayList<FacilityTypeForm>();
		facilityTypeFormList.add(facilityTypeForm);
		facilitySession.setFacilityForm(facilityForm);
		facilitySession.setFacilityTypeFormList(facilityTypeFormList);

		FacilityDetailForm detailForm = FacilityDetailForm.getInstance();
		detailForm.setFacilityForm(facilitySession.getFacilityForm());

		FacilityDetailForm result = facilityDetailHelper.createFacilityDetailForm(facilitySession);

		assertEquals(facilityId, result.getFacilityForm().getFacilityId());
		assertEquals(name, result.getFacilityForm().getName());
		assertEquals(capacity, result.getFacilityForm().getCapacity());
		//なんでfacilityTypeFormListから持ってくるんだろう
		assertEquals(facilityTypeId, result.getFacilityForm().getFacilityTypeForm().getFacilityTypeId());
		assertEquals(typeName, result.getFacilityForm().getFacilityTypeForm().getName());
		assertEquals(facilityTypeId, result.getFacilityTypeFormList().get(0).getFacilityTypeId());
		assertEquals(typeName, result.getFacilityTypeFormList().get(0).getName());
	}

	@Test
	public void createFacilityDetailFormTestNo() {
		FacilitySession facilitySession = new FacilitySession();
		FacilityForm facilityForm = new FacilityForm();
		List<FacilityTypeForm> list = new ArrayList<FacilityTypeForm>();

		facilitySession.setFacilityForm(facilityForm);
		facilitySession.setFacilityTypeFormList(list);

		FacilityDetailForm result = facilityDetailHelper.createFacilityDetailForm(facilitySession);

		assertEquals(0, result.getFacilityForm().getFacilityId());
		assertNull(result.getFacilityForm().getName());
		assertNull(result.getFacilityForm().getCapacity());
		assertEquals(0, result.getFacilityForm().getFacilityTypeForm().getFacilityTypeId());
		assertNull(result.getFacilityForm().getFacilityTypeForm().getName());
		assertEquals(0, result.getFacilityTypeFormList().size());
	}

	//FacilityTypeManagerDto
	@Test
	public void createFacilityDetailFormOk() {

		int facilityTypeId = 1;
		String typeName = "部屋";

		FacilityTypeManagerDto dto = new FacilityTypeManagerDto();
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto(facilityTypeId, typeName);
		List<FacilityTypeDto> typeList = new ArrayList<FacilityTypeDto>();
		typeList.add(facilityTypeDto);

		dto.setFacilityTypeDto(facilityTypeDto);
		dto.setFacilityTypeDtoList(typeList);

		FacilityDetailForm result = facilityDetailHelper.createFacilityDetailForm(dto);

		assertEquals(facilityTypeId, result.getFacilityForm().getFacilityTypeForm().getFacilityTypeId());
		assertEquals(1, result.getFacilityTypeFormList().size());

	}

	@Test
	public void createFacilityDetailFormNo() {
		int facilityTypeId = 0;
		String name = "name";
		FacilityTypeManagerDto dto = new FacilityTypeManagerDto();
		FacilityTypeDto nullFacilityTypeDto = new FacilityTypeDto();
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto();
		facilityTypeDto.setFacilityTypeId(facilityTypeId);
		facilityTypeDto.setName(name);
		List<FacilityTypeDto> list = new ArrayList<FacilityTypeDto>();
		list.add(facilityTypeDto);
		dto.setFacilityTypeDto(nullFacilityTypeDto);
		dto.setFacilityTypeDtoList(list);

		FacilityDetailForm result = facilityDetailHelper.createFacilityDetailForm(dto);
		assertEquals(0, result.getFacilityForm().getFacilityTypeForm().getFacilityTypeId());
		//listは必ずいれないといけないから
		assertEquals(1, result.getFacilityTypeFormList().size());
	}

	@Test
	public void createFacilityDetailForm() {

		int facilityId = 1;
		String name = "会議室";
		int capacity = 10;
		int facilityTypeId = 1;
		String typeName = "部屋";
		String userId = "user";

		FacilityTypeDto facilityTypeDto = new FacilityTypeDto();
		facilityTypeDto.setFacilityTypeId(facilityTypeId);
		facilityTypeDto.setName(typeName);
		UserDto userDto = new UserDto();
		userDto.setUserId(userId);

		FacilityDto facilityDto = new FacilityDto(facilityId, name, capacity, facilityTypeDto, userDto);
		List<FacilityTypeDto> facilityTypeDtoList = new ArrayList<FacilityTypeDto>();
		facilityTypeDtoList.add(facilityTypeDto);
		FacilityManagerDto dto = new FacilityManagerDto();
		dto.setFacilityDto(facilityDto);
		dto.setFacilityTypeDtoList(facilityTypeDtoList);

		FacilityDetailForm result = facilityDetailHelper.createFacilityDetailForm(dto);

		assertEquals(facilityId, result.getFacilityForm().getFacilityId());
		assertEquals(name, result.getFacilityForm().getName());
		assertEquals("10", result.getFacilityForm().getCapacity());
		assertEquals(1, result.getFacilityTypeFormList().size());
		assertEquals(facilityTypeId, result.getFacilityTypeFormList().get(0).getFacilityTypeId());
		assertEquals(typeName, result.getFacilityTypeFormList().get(0).getName());

	}

	@Test
	public void createFacilityDetailFormNoTest() {
		int facilityId = 0;
		String name = null;
		int capacity = 0;
		int facilityTypeId = 0;
		String typeName = null;
		String userId = null;

		FacilityTypeDto facilityTypeDto = new FacilityTypeDto();
		facilityTypeDto.setFacilityTypeId(facilityTypeId);
		facilityTypeDto.setName(typeName);
		UserDto userDto = new UserDto();
		userDto.setUserId(userId);
		FacilityManagerDto dto = new FacilityManagerDto();
		FacilityDto facilityDto = new FacilityDto(facilityId, name, facilityTypeId, facilityTypeDto, userDto);

		List<FacilityTypeDto> facilityTypeDtoList = new ArrayList<FacilityTypeDto>();
		facilityTypeDtoList.add(facilityTypeDto);
		dto.setFacilityDto(facilityDto);
		dto.setFacilityTypeDtoList(facilityTypeDtoList);

		FacilityDetailForm result = facilityDetailHelper.createFacilityDetailForm(dto);

		assertEquals(0, result.getFacilityForm().getFacilityId());
		assertNull(result.getFacilityForm().getName());
		assertEquals("0", result.getFacilityForm().getCapacity());
		assertEquals(1, result.getFacilityTypeFormList().size());
		assertEquals(0, result.getFacilityTypeFormList().get(0).getFacilityTypeId());

	}

}
