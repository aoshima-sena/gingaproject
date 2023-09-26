package jp.co.ginga.spring.base.step5;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

/**
 * Step5Formクラス
 *
 * @Dataを使用することで、getter,setterを自動生成
 */
@Data
public class Step5Form {

	/**
	 * 入力データ1
	 *
	 *
	 * 文字列、配列、コレクションなど、
	 * 多数の値をまとめて管理するオブジェクトで、
	 * 要素数の最小値と最大値を指定するものです。
	 */
	@Size(message = "5文字以上、10文字以下での入力してください。", min = 5, max = 10)
	private String inputText1;

	/**
	 * 入力データ2
	 *
	 * 空の値を禁ずるものです。
	 */
	@NotEmpty(message = "入力必須項目です。")
	/**
	 * 文字列、配列、コレクションなど、
	 * 多数の値をまとめて管理するオブジェクトで、
	 * 要素数の最小値と最大値を指定するものです。
	 */
	@Size(message = "5文字以上、10文字以下での入力してください。", min = 5, max = 10)
	private String inputText2;

	/**
	 * 入力データ3
	 *
	 * 空の値を禁ずるものです。
	 *
	 * 文字列の値がメールアドレスの形式になっているかをチェック
	 */
	@NotEmpty(message = "入力必須項目です。")
	@Email
	private String inputText3;

	/**
	 * 入力データ4
	 *
	 * 空の値を禁ずるものです。
	 */
	@NotEmpty(message = "入力必須項目です。")
	/**
	 * 正規表現のパターンを使って値をチェックするものです。
	 */
	@Pattern(message = "正規表現 [0-9] にマッチさせてください", regexp = "[0-9]")
	public String inputText4;

	/**
	 * 入力データ5
	 *
	 * 空の値を禁ずるものです。
	 * 正規表現のパターンを使って値をチェックするものです。
	 */
	@NotEmpty(message = "入力必須項目です。")
	@Pattern(message = "070,080,090で始まる携帯電話番号を入力してください", regexp = "^0[789]0-[0-9]{4}-[0-9]{4}$")
	private String inputText5;

	/**
	 * 入力データ6
	 * 空の値を禁ずるものです。
	 * 正規表現のパターンを使って値をチェックするものです。
	 * 文字列、配列、コレクションなど、
	 * 多数の値をまとめて管理するオブジェクトで、
	 * 要素数の最小値と最大値を指定するものです。
	 */
	@NotEmpty(message = "入力必須項目です。")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "半角英数字を入力してください")
	@Size(message = "4文字以上8文字以内で入力してください", min = 4, max = 8)
	private String inputText6;

	/**
	 * 入力データ7
	 * 空の値を禁ずるものです。
	 * 正規表現のパターンを使って値をチェックするものです。
	 * 文字列、配列、コレクションなど、
	 * 多数の値をまとめて管理するオブジェクトで、
	 * 要素数の最小値と最大値を指定するものです。
	 */
	@NotEmpty(message = "入力必須項目です。")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "半角英数字を入力してください")
	@Size(message = "5文字以上10文字以内で入力してください", min = 5, max = 10)
	private String inputText7;

	/**
	 * 入力データ8
	 * 空の値を禁ずるものです。
	 * 正規表現のパターンを使って値をチェックするものです。
	 * 文字列、配列、コレクションなど、
	 * 多数の値をまとめて管理するオブジェクトで、
	 * 要素数の最小値と最大値を指定するものです。
	 * nullのみチェックする場合に使用する
	 * 数値の値で、最小値と最大値を指定するものです。
	 * @Min、@Maxをまとめて設定するものと考えて下さい。
	 */
	@NotEmpty(message = "入力必須項目です。")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "半角英数字を入力してください")
	@Size(message = "5文字以上10文字以内で入力してください", min = 5, max = 10)
	private String inputText8;

	@NotNull(message = "入力必須項目です。")
	@Range(message = "10以上20以内で入力してください", min = 10, max = 20)
	private Integer inputNo1;

	/**
	 * パスワード不一致時のエラーメッセージ
	 */
	private String errMsg1;

}
