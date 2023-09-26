package jp.co.ginga.web.application.util.form.facility;

import java.io.Serializable;

import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import jp.co.ginga.web.application.validation.facility.FacilityCapacityValidator;
import jp.co.ginga.web.application.validation.facility.FacilityNameValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//オブジェクトを文字列にして保存できるようになる

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacilityForm implements Serializable {
	//下４つの情報を保持するクラス
	private int facilityId;

	@FacilityNameValidator
	private String name;

	@FacilityCapacityValidator
	private String capacity;
	//facilityTypeIDとnameを保持する
	private FacilityTypeForm facilityTypeForm;

	public static FacilityForm getInstance() {
		return new FacilityForm();

	}

	public FacilityTypeForm getFacilityTypeForm() {
		if (facilityTypeForm == null) {
			facilityTypeForm = new FacilityTypeForm();
		}
		return facilityTypeForm;

	}
}
