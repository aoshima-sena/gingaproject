package jp.co.ginga.web.application.controller.facility.list;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import jp.co.ginga.web.application.util.form.facility.FacilityForm;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FacilityListContorollerTest {

	private MockMvc mockMvc;

	@Autowired
	FacilityListController facilityListController;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(facilityListController).build();

	}

	@Test
	public void getFacilityListController() throws Exception {
		//get post fileUploadで持ってくる
		MvcResult result = mockMvc.perform(get("/facility/list"))
				// HTTPステータスがOKであることを確認
				.andExpect(status().isOk())
				// 次画面の遷移先がindex.htmlであることを確認
				.andExpect(view().name("facility/facility-list"))
				// Modelオブジェクトにエラーが無いことを確認
				.andExpect(model().hasNoErrors())
				//実行結果をデバックレベルでログ出力
				.andDo(log())
				.andReturn();

		//modelに正しい値が詰められているか確認
		@SuppressWarnings("unchecked")
		List<FacilityForm> facilityListForm = (List<FacilityForm>) result.getModelAndView().getModel()
				.get("facilityListForm");
		assertEquals(6, facilityListForm.size());
		//興味本位で作ったやつ。普通に動く↴
		//assertEquals(1,facilityListForm.get(0).getFacilityId());
	}
}
