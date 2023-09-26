package jp.co.ginga.web.application.util.form.facilitytype;

import java.io.Serializable;

import jp.co.ginga.web.application.validation.facilityType.FacilityTypeNameValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacilityTypeForm implements Serializable {

	private int facilityTypeId;
	@FacilityTypeNameValidator
	private String name;

	public static FacilityTypeForm getInstance() {
		return new FacilityTypeForm();
	}
}
