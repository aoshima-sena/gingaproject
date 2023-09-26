package jp.co.ginga.web.application.controller.reservation.calendar;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jp.co.ginga.web.application.controller.facilityReservation.calendar.FacilityReservationCalendarForm;
import jp.co.ginga.web.application.controller.facilityReservation.calendar.FacilityReservationCalendarHelper;
import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FacilityReservationCalendarHelperTest {

	@Autowired
	FacilityReservationCalendarHelper facilityReservationcalendarHelper;

	@Test
	public void createFacilityReservationCalendaHelperTest() {
		int facilityId = 1;
		String name = "会議室1";
		int capacity = 10;
		int reservationId = 3;
		String datetime = "2022-12-07 09:00:00";
		Timestamp startTime = Timestamp.valueOf(datetime);
		Timestamp endTime = Timestamp.valueOf(datetime);



		FacilityDto facilityDto = new FacilityDto(facilityId, name, capacity, null, null);

//		List<FacilityDto> list = new ArrayList<FacilityDto>();
//		list.add(facilityDto);

		FacilityReservationDto facilityReservationDto = new FacilityReservationDto();
		facilityReservationDto.setReservationId(reservationId);
		facilityReservationDto.setStartTime(startTime);
		facilityReservationDto.setEndTime(endTime);

		facilityReservationDto.setFacilityDto(facilityDto);
//		facilityReservationDto.setFacilityDtoList(list);
		//	facilityReservationDto.setFacilityTypeDtoList(facilityTypeDtoList);

		FacilityReservationManagerDto reservationManagerDto = new FacilityReservationManagerDto();
		reservationManagerDto.setReservationDto(facilityReservationDto);
//		reservationManagerDto.setFacilityDtoList(list);
		//
		//		reservationManagerDto.setFacilityTypeDtoList(facilityTypeDtoList);

		FacilityReservationCalendarForm result = facilityReservationcalendarHelper
				.createFacilityListForm(reservationManagerDto);



		assertEquals(reservationId, result.getFacilityReservationForm().getReservationId());
		assertEquals(startTime, result.getFacilityReservationForm().getStartTime());
		assertEquals(endTime, result.getFacilityReservationForm().getEndTime());
		assertEquals(facilityId, result.getFacilityReservationForm().getFacilityForm().getFacilityId());
		assertEquals(name, result.getFacilityReservationForm().getFacilityForm().getName());
//		assertEquals("10",result.getFacilityReservationForm().getFacilityForm().getCapacity());


	}

	//FormからDtoはないから書かなくていい
	//sessionからfacilityReservationCalenderFormのテスト

	@Test
	public void test() {
		int facilityId = 1;
		String name = "会議室1";

		int reservationId = 3;
		String datetime = "2022-12-07 09:00:00";
		Timestamp startTime = Timestamp.valueOf(datetime);
		Timestamp endTime = Timestamp.valueOf(datetime);

		FacilityForm facilityForm = new FacilityForm();
		facilityForm.setFacilityId(facilityId);
		facilityForm.setName(name);


		FacilityReservationForm form = new FacilityReservationForm();
		form.setReservationId(reservationId);
		form.setStartTime(startTime);
		form.setEndTime(endTime);
		form.setFacilityForm(facilityForm);

		FacilityReservationSession session = new FacilityReservationSession();
		session.setFacilityReservationForm(form);

		FacilityReservationCalendarForm result = facilityReservationcalendarHelper.createFacilityReservationForm(session);

		assertEquals(reservationId,result.getFacilityReservationForm().getReservationId());
		assertEquals(startTime,result.getFacilityReservationForm().getStartTime());
		assertEquals(endTime,result.getFacilityReservationForm().getEndTime());
		assertEquals(facilityId,result.getFacilityReservationForm().getFacilityForm().getFacilityId());
		assertEquals(name,result.getFacilityReservationForm().getFacilityForm().getName());


	}

	/*	@Test
		public void getYear() {
			int year = 2023;
			FacilityReservationManagerDto dto = new FacilityReservationManagerDto();
			CalendarYearForm form = new CalendarYearForm();
			dto.setYear(year);

			FacilityReservationCalendarForm result = facilityReservationcalendarHelper.createYear(dto);

			assertEquals(year,result.getCalenderYearForm().getYear());
		}*/


}
