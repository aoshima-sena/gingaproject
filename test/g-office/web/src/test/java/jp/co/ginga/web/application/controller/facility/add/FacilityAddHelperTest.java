package jp.co.ginga.web.application.controller.facility.add;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import jp.co.ginga.web.application.util.session.facility.FacilitySession;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FacilityAddHelperTest {

	@Autowired
	FacilityAddHelper facilityAddHelper;

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
	public void createFacilityAddFormDtoTest() {
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto(facilityTypeId, typeName, insertDate, null);
		List<FacilityTypeDto> list = new ArrayList<FacilityTypeDto>();
		list.add(facilityTypeDto);
		FacilityTypeManagerDto facilityTypeManagerDto = new FacilityTypeManagerDto();
		facilityTypeManagerDto.setFacilityTypeDtoList(list);
		FacilityAddForm result = facilityAddHelper.createFacilityAddForm(facilityTypeManagerDto);

		assertEquals(facilityTypeId, result.getFacilityTypeFormList().get(0).getFacilityTypeId());
		assertEquals(typeName, result.getFacilityTypeFormList().get(0).getName());
	}

	@Test
	public void createFacilityAddFormSessionTest() {
		String capacityString = "capa";
		FacilityForm facilityForm = new FacilityForm(facilityId, name, capacityString, null);
		FacilityTypeForm typeForm = new FacilityTypeForm(facilityTypeId, typeName);
		List<FacilityTypeForm> list = new ArrayList<FacilityTypeForm>();
		list.add(typeForm);
		FacilitySession session = new FacilitySession();
		session.setFacilityForm(facilityForm);
		session.setFacilityTypeFormList(list);

		FacilityAddForm result = facilityAddHelper.createFacilityAddForm(session);

		assertEquals(facilityId, result.getFacilityForm().getFacilityId());
		assertEquals(name, result.getFacilityForm().getName());
		assertEquals("capa", result.getFacilityForm().getCapacity());
		assertEquals(facilityTypeId, result.getFacilityTypeFormList().get(0).getFacilityTypeId());
		assertEquals(typeName, result.getFacilityTypeFormList().get(0).getName());
	}
}
