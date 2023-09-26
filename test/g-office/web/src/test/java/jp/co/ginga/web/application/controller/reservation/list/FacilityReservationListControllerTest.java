package jp.co.ginga.web.application.controller.reservation.list;

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

import jp.co.ginga.web.application.controller.facilityReservation.list.FacilityReservationListController;
import jp.co.ginga.web.application.controller.facilityReservation.list.FacilityReservationListForm;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FacilityReservationListControllerTest {

	private MockMvc mockMvc;

	@Autowired
	FacilityReservationListController reservationListController;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(reservationListController).build();
	}

	//ここ無理や笑
	//できたよ～ン

	@Test
	public void getFacilityReservationListController() throws Exception {
		MvcResult result = mockMvc.perform(get("/facilityreservation/list"))
				.andExpect(status().isOk())
				.andExpect(view().name("facilityReservation/facilityReservation"))
				.andExpect(model().hasNoErrors())
				.andReturn();

		//Listにすると下のアノテーションが必要になる

		FacilityReservationListForm facilityReservation = (FacilityReservationListForm) result.getModelAndView()
				.getModel().get("facilityReservationListForm");

		assertEquals(6, facilityReservation.getFacilityFormList().size());
	}


	@Test
	public void getFacilityReservationListController2() throws Exception {
		//	int facilityId = 1;
		//	FacilityEntity facilityEntity = new FacilityEntity();
		//	facilityEntity.setFacilityId(facilityId);
		for (int i = 1; i <= 5; i++) {
			MvcResult result = mockMvc.perform(get("/facilityreservation/remake/" + i))
					.andExpect(status().isOk())
					.andExpect(view().name("facilityReservation/facilityReservation"))
					.andExpect(model().hasNoErrors())
					.andReturn();

			FacilityReservationListForm facilityReservationForm = (FacilityReservationListForm) result.getModelAndView().getModel()
					.get("facilityReservationListForm");
			assertEquals(i, facilityReservationForm.getFacilityForm().getFacilityTypeForm().getFacilityTypeId());
		}
	}
}
