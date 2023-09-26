package jp.co.ginga.web.application.controller.facility.add;

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
public class FacilityAddForm {

	String sysMsg;
	@Valid
	FacilityForm facilityForm;

	List<FacilityTypeForm> facilityTypeFormList;

	public FacilityForm getFacilityForm() {
		if (facilityForm == null) {
			facilityForm = FacilityForm.getInstance();

		}
		return facilityForm;
	}

	public static FacilityAddForm getInstance() {
		return new FacilityAddForm();
	}

}
