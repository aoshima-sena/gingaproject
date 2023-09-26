package jp.co.ginga.web.application.controller.reservation.calendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import jp.co.ginga.web.application.controller.facilityReservation.calendar.FacilityReservationCalendarController;
import jp.co.ginga.web.application.controller.facilityReservation.calendar.FacilityReservationCalendarForm;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FacilityReservationCalendarControllerTest {

	private MockMvc mockMvc;

	@Autowired
	FacilityReservationCalendarController calendarController;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(calendarController).build();
	}

	@Test
	public void getCalendarController() throws Exception {
		MvcResult result = mockMvc.perform(get("/facilityreservation/calendar/1"))
				.andExpect(status().isOk())
				.andExpect(view().name("facilityReservation/reservationCalender"))
				.andExpect(model().hasNoErrors())
				.andReturn();


		FacilityReservationCalendarForm calenderForm = (FacilityReservationCalendarForm) result
				.getModelAndView().getModel().get("calendarForm");

		assertEquals(12, calenderForm.getFacilityReservationFormList().size());
	}
}
