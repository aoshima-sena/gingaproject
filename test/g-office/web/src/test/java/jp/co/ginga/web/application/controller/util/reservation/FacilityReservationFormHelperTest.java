package jp.co.ginga.web.application.controller.util.reservation;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import jp.co.ginga.web.application.util.helper.facilityReservation.FacilityReservationFormHelper;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FacilityReservationFormHelperTest {

	@Autowired
	FacilityReservationFormHelper reservationFormHelper;

	@Test
	public void testconvertReservationForm() {

		String datetime = "2019-05-01 01:02:03";

		int reservationId = 1;
		Timestamp startTime = Timestamp.valueOf(datetime);
		Timestamp endTime = Timestamp.valueOf(datetime);
		int facilityId = 2;
		String name = "会議室";


		FacilityForm facilityForm = new FacilityForm();
		facilityForm.setFacilityId(facilityId);
		facilityForm.setName(name);


		FacilityReservationForm reservationForm = new FacilityReservationForm();
		reservationForm.setReservationId(reservationId);
		reservationForm.setStartTime(startTime);
		reservationForm.setEndTime(endTime);
		reservationForm.setFacilityForm(facilityForm);

		FacilityReservationDto result = reservationFormHelper.convertReservationDto(reservationForm);

		assertEquals(reservationId,result.getReservationId());
		assertEquals(startTime,result.getStartTime());
		assertEquals(endTime,result.getEndTime());
		assertEquals(facilityId,result.getFacilityDto().getFacilityId());
		assertEquals(name,result.getFacilityDto().getName());
	}

	@Test
	public void DtoKaraFormTest() {

		String datetime = "2019-05-01 01:02:03";

		int reservationId = 1;
		Timestamp startTime = Timestamp.valueOf(datetime);
		Timestamp endTime = Timestamp.valueOf(datetime);
		int facilityId = 2;
		String name = "会議室";


		FacilityDto facilityDto = new FacilityDto();
		facilityDto.setFacilityId(facilityId);
		facilityDto.setName(name);


		FacilityReservationDto dto = new FacilityReservationDto();
		dto.setReservationId(reservationId);
		dto.setStartTime(startTime);
		dto.setEndTime(endTime);
		dto.setFacilityDto(facilityDto);
//		dto.setFacilityTypeDto(typeDto);

		FacilityReservationForm result =reservationFormHelper.convertReservationForm(dto);

		assertEquals(reservationId,result.getReservationId());
		assertEquals(startTime,result.getStartTime());
		assertEquals(endTime,result.getEndTime());
		assertEquals(facilityId,result.getFacilityForm().getFacilityId());
		assertEquals(name,result.getFacilityForm().getName());
	}
}
