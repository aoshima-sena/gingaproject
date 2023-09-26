package jp.co.ginga.web.application.util.session.facilityType;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//施設種別情報のデータ保持から破棄までの処理をまとめたクラス
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacilityTypeSession implements Serializable {
	//facilityTypeIdとname
	private FacilityTypeForm facilityTypeForm;

	private List<FacilityTypeForm> facilityTypeFormList;

	private FacilityTypeForm beforeFacilityTypeForm;

	String optimisticRockValue;

	public FacilityTypeForm getFacilityTypeForm() {
		if (this.facilityTypeForm == null) {
			this.facilityTypeForm = new FacilityTypeForm();
		}
		return facilityTypeForm;
	}

	public void clear() {
		System.out.println("session-clear");

		this.facilityTypeForm = null;
		this.beforeFacilityTypeForm = null;
		this.facilityTypeFormList = null;
		this.optimisticRockValue = null;
	}
}
