package jp.co.ginga.web.application.controller.facility.add;

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
public class FacilityAddControllerTest {
	private MockMvc mockMvc;

	@Autowired
	FacilityAddController facilityAddController;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(facilityAddController).build();

	}

	@Test
	public void createFacilityAddController() throws Exception {
		MvcResult result = mockMvc.perform(get("/facility/add")).andExpect(status().isOk())
				.andExpect(view().name("facility/facility-add")).andExpect(model().hasNoErrors()).andReturn();

		FacilityAddForm facilityAddForm = (FacilityAddForm) result.getModelAndView().getModel().get("facilityAddForm");
		assertEquals(3, facilityAddForm.getFacilityTypeFormList().size());
	}

}
