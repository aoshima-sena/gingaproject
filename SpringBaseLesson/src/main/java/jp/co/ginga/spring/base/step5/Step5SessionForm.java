package jp.co.ginga.spring.base.step5;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Step5SessionForm クラス
 *
 * @author yoshi
 *
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Step5SessionForm implements Serializable {

	// メモリがいっぱいになってHDにこのクラスを保存することがあり、
	// HDのファイルに保存（Serializable）するときにバージョン管理をする際に以下の定義が必要
	// デシリアライズ（HDのファイルからメモリに戻す（バイナリからjavaのオブジェクトに戻す））時に、
	// 以下で定義しているserialVersionUIDの初期値が異なっていたらエラーを返す仕組み
	private static final long serialVersionUID = 1L;

	/**
	 * Step5Form
	 */
	private Step5Form step5Form;

	/**
	 * Step5Formの取得
	 *
	 * @return
	 */
	public Step5Form getStep5Form() {

		return this.step5Form;

	}

	/**
	 * Step5Formのセット
	 *
	 * @param step5Form
	 */
	public void setStep5Form(Step5Form step5Form) {
		this.step5Form = step5Form;

	}

	/**
	 * セッションの生成
	 */
	public void createSession() {
		if (this.step5Form == null) {
			this.step5Form = new Step5Form();
		}
	}

	/**
	 * セッションの初期化
	 */
	public void clear() {
		this.step5Form = null;

	}

}
