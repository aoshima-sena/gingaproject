package jp.co.ginga.web.application.controller.facility.list;

import java.util.List;

import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacilityListForm {

	private String sysMsg;
	private List<FacilityForm> facilityFormList;

	public FacilityListForm getInstance() {
		return new FacilityListForm();
	}
}
