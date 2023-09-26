package jp.co.ginga.web.application.controller.facilityType.add;

import javax.validation.Valid;

import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import jp.co.ginga.web.application.util.session.facilityType.FacilityTypeSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacilityTypeAddForm {

	String sysMsg;
	@Valid
	private FacilityTypeForm facilityTypeForm;

	FacilityTypeSession facilityTypeSession;

	public FacilityTypeForm getFacilityTypeForm() {
		if (facilityTypeForm == null) {
			facilityTypeForm = FacilityTypeForm.getInstance();
		}
		return facilityTypeForm;
	}

	//あやふや
	//施設種別を保持したいクラス
	public static FacilityTypeAddForm getInstance() {
		//	FacilityTypeAddForm form = new FacilityTypeAddForm();
		//	form.setFacilityTypeForm(facilityTypeForm);

		return new FacilityTypeAddForm();
	}





}
