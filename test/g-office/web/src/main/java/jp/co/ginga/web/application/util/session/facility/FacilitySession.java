package jp.co.ginga.web.application.util.session.facility;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)//デフォルトだとsingletonという生存期間がめちゃくちゃ長いスコープ設定になっているため、HTMLのセッション単位でBeanのインスタンスを生成する。（寿命短め）

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacilitySession implements Serializable {

	private FacilityForm facilityForm;

	private FacilityForm beforeFacilityForm;

	private List<FacilityTypeForm> facilityTypeFormList;

	private String optimisticRockValue;

	public FacilityForm getFacilityForm() {
		if (this.facilityForm == null) {
			this.facilityForm = new FacilityForm();
		}
		return this.facilityForm;
	}

	public void clear() {
		System.out.println("session-clear");

		this.facilityForm = null;
		this.beforeFacilityForm = null;
		this.facilityTypeFormList = null;
		this.optimisticRockValue = null;
	}
}
