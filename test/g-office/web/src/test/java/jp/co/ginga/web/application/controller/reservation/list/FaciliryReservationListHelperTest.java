package jp.co.ginga.web.application.controller.reservation.list;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jp.co.ginga.web.application.controller.facilityReservation.list.FacilityReservationListForm;
import jp.co.ginga.web.application.controller.facilityReservation.list.FacilityReservationListHelper;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FaciliryReservationListHelperTest {


	@Autowired
	FacilityReservationListHelper reservationListHelper;

	@Test
	public void createFacilityReservationListHelper() {
		int facilityId = 1;
		String name = "会議室1";
		int capacity = 10;
		int facilityTypeId = 2;
		String typeName = "会議室";
	//	String userId = "1";

		FacilityTypeDto facilityTypeDto = new FacilityTypeDto();
		facilityTypeDto.setFacilityTypeId(facilityTypeId);
		facilityTypeDto.setName(typeName);

		FacilityDto facilityDto = new FacilityDto(facilityId, name, capacity, facilityTypeDto, null);
		List<FacilityDto> dtoList = new ArrayList<FacilityDto>();
		dtoList.add(facilityDto);
		FacilityReservationManagerDto reservationDto = new FacilityReservationManagerDto();
		reservationDto.setFacilityDtoList(dtoList);

		FacilityReservationListForm result = reservationListHelper.createFacilityListForm(reservationDto);

		assertEquals(1,result.getFacilityFormList().size());
		assertEquals(facilityId,result.getFacilityFormList().get(0).getFacilityId());
		assertEquals(name,result.getFacilityFormList().get(0).getName());
		assertEquals("10",result.getFacilityFormList().get(0).getCapacity());

		assertEquals(facilityTypeId,result.getFacilityFormList().get(0).getFacilityTypeForm().getFacilityTypeId());
		assertEquals(typeName,result.getFacilityFormList().get(0).getFacilityTypeForm().getName());


	}

	@Test
	public void createFacilityReservationListFormNoTest() {
		List<FacilityDto> dtoList = new ArrayList<FacilityDto>();
		List<FacilityTypeDto> typeDtoList = new ArrayList<FacilityTypeDto>();

		FacilityReservationManagerDto reservationDto = new FacilityReservationManagerDto();
		reservationDto.setFacilityDtoList(dtoList);
		reservationDto.setFacilityTypeDtoList(typeDtoList);

		FacilityReservationListForm result = reservationListHelper.createFacilityListForm(reservationDto);

		assertEquals(0,result.getFacilityFormList().size());
	}

}
