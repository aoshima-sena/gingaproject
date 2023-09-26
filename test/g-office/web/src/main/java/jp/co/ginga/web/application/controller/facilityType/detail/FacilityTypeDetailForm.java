package jp.co.ginga.web.application.controller.facilityType.detail;

import javax.validation.Valid;

import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacilityTypeDetailForm {

	@Valid
	private FacilityTypeForm facilityTypeForm;

	private String sysMsg;

	public FacilityTypeForm getFacilityTypeForm() {
		if (facilityTypeForm == null) {
			facilityTypeForm = new FacilityTypeForm();

		}
		return facilityTypeForm;
	}

	public static FacilityTypeDetailForm getInstance() {

		return new FacilityTypeDetailForm();
	}
}
