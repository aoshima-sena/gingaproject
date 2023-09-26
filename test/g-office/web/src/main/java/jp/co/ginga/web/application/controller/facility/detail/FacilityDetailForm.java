package jp.co.ginga.web.application.controller.facility.detail;

import java.util.List;

import javax.validation.Valid;

import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacilityDetailForm {

	private String sysMsg;
	@Valid
	private FacilityForm facilityForm;

	private List<FacilityTypeForm> facilityTypeFormList;

	public FacilityForm getFacilityForm() {
		if (facilityForm == null) {
			facilityForm = new FacilityForm();

		}
		return facilityForm;
	}

	public static FacilityDetailForm getInstance() {
		return new FacilityDetailForm();
	}

}
