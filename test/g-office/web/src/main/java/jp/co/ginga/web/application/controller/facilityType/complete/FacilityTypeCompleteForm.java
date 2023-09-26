package jp.co.ginga.web.application.controller.facilityType.complete;

import lombok.Data;

@Data
public class FacilityTypeCompleteForm {
	//システムメッセージの呼び出し
	private String sysMsg;
	//登録、更新、削除の名前
	private String btnName;

	public static FacilityTypeCompleteForm getInstance() {
		return new FacilityTypeCompleteForm();
	}
}
