package jp.co.ginga.web.application.controller.facilityType.list;

import java.util.List;

import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacilityTypeListForm {

	private List<FacilityTypeForm> facilityTypeFormList;

	public static FacilityTypeListForm getInstance() {
		return new FacilityTypeListForm();

	}
}
