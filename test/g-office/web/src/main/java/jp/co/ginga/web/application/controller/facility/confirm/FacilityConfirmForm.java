package jp.co.ginga.web.application.controller.facility.confirm;

import java.util.List;

import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacilityConfirmForm {

	private String sysMsg;

	private FacilityForm facilityForm;

	private List<FacilityTypeForm> facilityTypeFormList;

	private FacilityTypeForm facilityTypeForm;

	private String btnName;

	private String btnAction;

	public static FacilityConfirmForm getInstance() {
		return new FacilityConfirmForm();
	}
}
