package jp.co.ginga.web.application.controller.util.facility;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import jp.co.ginga.web.application.util.helper.facility.FacilityFormHelper;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FacilityFormHelperTest {

	@Autowired
	FacilityFormHelper facilityFormHelper;

	@Test
	public void dtotest() {

		int facilityId =1;
		String name = "会議室";
		String capacity = "10";
		int facilityTypeId = 2;
		String typeName = "部屋";

		FacilityTypeForm typeForm = new FacilityTypeForm();
		typeForm.setFacilityTypeId(facilityTypeId);
		typeForm.setName(typeName);
		FacilityForm form = new FacilityForm();
		form.setFacilityId(facilityId);
		form.setName(name);
		form.setCapacity(capacity);
		form.setFacilityTypeForm(typeForm);

		FacilityDto result = facilityFormHelper.convertFacilityDto(form);

		assertEquals(facilityId,result.getFacilityId());
		assertEquals(name,result.getName());
		assertEquals(10,result.getCapacity());
		assertEquals(facilityTypeId,result.getFacilityTypeDto().getFacilityTypeId());
		assertEquals(typeName,result.getFacilityTypeDto().getName());
	}

	@Test
	public void formTest() {

		int facilityId =1;
		String name = "会議室";
		int capacity = 10;
		int facilityTypeId = 2;
		String typeName = "部屋";

		FacilityTypeDto typeDto = new FacilityTypeDto();
		typeDto.setFacilityTypeId(facilityTypeId);
		typeDto.setName(typeName);
		FacilityDto dto = new FacilityDto();
		dto.setFacilityId(facilityId);
		dto.setName(name);
		dto.setCapacity(capacity);
		dto.setFacilityTypeDto(typeDto);

		FacilityForm result = facilityFormHelper.convertFacilityForm(dto);

		assertEquals(facilityId,result.getFacilityId());
		assertEquals(name,result.getName());
		assertEquals("10",result.getCapacity());
		assertEquals(facilityTypeId,result.getFacilityTypeForm().getFacilityTypeId());
		assertEquals(typeName,result.getFacilityTypeForm().getName());
	}
}
