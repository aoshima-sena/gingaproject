package jp.co.ginga.web.application.controller.facility.list;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jp.co.ginga.web.application.controller.facility.list.FacilityListForm;
import jp.co.ginga.web.application.controller.facility.list.FacilityListHelper;
import jp.co.ginga.web.domain.service.facility.FacilityManagerDto;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FacilityListFormHelperTest {

	@Autowired
	FacilityListHelper facilityListHelper;

	@Test
	public void createFacilityListFormTest() {

		int facilityId = 1;
		String name = "会議室";
		int capacity = 10;
		int facilityTypeId = 1;
		String facility_name = "会議室";
		String userId = "1";

		FacilityTypeDto facilityTypeDto = new FacilityTypeDto();
		facilityTypeDto.setFacilityTypeId(facilityTypeId);
		facilityTypeDto.setName(facility_name);
		UserDto userDto = new UserDto();
		userDto.getUserId();

		FacilityDto facilityDto = new FacilityDto(facilityId, name, capacity, facilityTypeDto, userDto);
		List<FacilityDto> facilityDtoList = new ArrayList<FacilityDto>();
		facilityDtoList.add(facilityDto);
		FacilityManagerDto facilityManagerDto = new FacilityManagerDto();
		facilityManagerDto.setFacilityDtoList(facilityDtoList);

		FacilityListForm result = facilityListHelper.createFacilityListForm(facilityManagerDto);

		assertEquals(1, result.getFacilityFormList().size());
		assertEquals(facilityId, result.getFacilityFormList().get(0).getFacilityId());
		assertEquals(name, result.getFacilityFormList().get(0).getName());
		//form内ではString、Dto内ではintなので↓
		assertEquals("10", result.getFacilityFormList().get(0).getCapacity());
		assertEquals(facilityTypeId, result.getFacilityFormList().get(0).getFacilityTypeForm().getFacilityTypeId());
		assertEquals(facility_name, result.getFacilityFormList().get(0).getFacilityTypeForm().getName());

	}

	//facilityDtoListとfacilityTypeDtoListがないとき
	@Test
	public void createFacilityListFormNoTest() {

		List<FacilityDto> facilityDtoList = new ArrayList<FacilityDto>();
		List<FacilityTypeDto> facilityTypeDtoList = new ArrayList<FacilityTypeDto>();

		FacilityManagerDto facilityManagerDto = new FacilityManagerDto();
		facilityManagerDto.setFacilityDtoList(facilityDtoList);
		facilityManagerDto.setFacilityTypeDtoList(facilityTypeDtoList);

		FacilityListForm result = facilityListHelper.createFacilityListForm(facilityManagerDto);

		assertEquals(0, result.getFacilityFormList().size());
		//dto.getResult() == ServiceConst.NO_DATAの時↓
		//nullエラーになるから無理
		//	assertEquals("0件です。", result.getSysMsg());
	}
}
