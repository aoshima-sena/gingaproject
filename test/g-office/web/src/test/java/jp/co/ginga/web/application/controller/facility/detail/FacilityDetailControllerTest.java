package jp.co.ginga.web.application.controller.facility.detail;

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

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FacilityDetailControllerTest {

	private MockMvc mockMvc;

	@Autowired
	FacilityDetailController facilityDetailController;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(facilityDetailController).build();

	}

	@Test
	public void getFacilityDetailController() throws Exception {
		//	int facilityId = 1;
		//	FacilityEntity facilityEntity = new FacilityEntity();
		//	facilityEntity.setFacilityId(facilityId);
		for (int i = 1; i <= 5; i++) {
			MvcResult result = mockMvc.perform(get("/facility/detail/" + i))
					.andExpect(status().isOk())
					.andExpect(view().name("facility/facility-detail"))
					.andExpect(model().hasNoErrors())
					.andReturn();

			FacilityDetailForm facilityDetailForm = (FacilityDetailForm) result.getModelAndView().getModel()
					.get("facilityDetailForm");
			assertEquals(i, facilityDetailForm.getFacilityForm().getFacilityId());
		}
	}

}
