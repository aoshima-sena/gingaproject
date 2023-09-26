package jp.co.ginga.web.application.controller.facility.complete;

import lombok.Data;

@Data
public class FacilityCompleteForm {

	private String sysMsg;
	private String btnName;
	private String btnText;

	public static FacilityCompleteForm getInstance() {
		return new FacilityCompleteForm();
	}
}
