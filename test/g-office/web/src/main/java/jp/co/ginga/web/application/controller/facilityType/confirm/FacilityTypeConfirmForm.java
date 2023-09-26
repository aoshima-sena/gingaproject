package jp.co.ginga.web.application.controller.facilityType.confirm;

import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacilityTypeConfirmForm {
	//facilityTypeIdとnameの呼び出し
	private FacilityTypeForm facilityTypeForm;
	//システムメッセージの呼び出し
	private String sysMsg;
	//登録、更新、削除の名前
	private String btnName;
	//登録、更新、削除のボタンのaction
	private String btnAction;

	public static FacilityTypeConfirmForm getInstance() {
		return new FacilityTypeConfirmForm();
	}
}
