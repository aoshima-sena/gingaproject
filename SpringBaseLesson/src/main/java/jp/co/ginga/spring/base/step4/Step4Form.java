package jp.co.ginga.spring.base.step4;

import java.io.Serializable;
import java.util.Map;

public class Step4Form implements Serializable {

	//selectタグ 選択した値
	public Integer selectedValue;

	//selectタグ 選択した見出し
	public String selectedLabel;

	//selectタグ 見出しリスト
	public Map<String, String> selectItem;

	//入力内容
	public String text;

	//パスワード
	public String password;

	//radioタグ 選択した値
	public String radioValue;

	//radioタグ 選択した見出し
	public String radioLabel;

	//radioタグ 見出しリスト
	public Map<String, String> radioItem;

	//checkboxタグ チェック済みの値の配列
	public String[] checkedValue;

	//checkboxタグ 見出しリスト
	public Map<String, String> checkItem;

	/**
	 * @return selectedValue
	 */
	public Integer getSelectedValue() {
		return selectedValue;
	}

	/**
	 * @param selectedValue セットする selectedValue
	 */
	public void setSelectedValue(Integer selectedValue) {
		this.selectedValue = selectedValue;
	}

	/**
	 * @return selectedLabel
	 */
	public String getSelectedLabel() {
		return selectedLabel;
	}

	/**
	 * @param selectedLabel セットする selectedLabel
	 */
	public void setSelectedLabel(String selectedLabel) {
		this.selectedLabel = selectedLabel;
	}

	/**
	 * @return selectItem
	 */
	public Map<String, String> getSelectItem() {
		return selectItem;
	}

	/**
	 * @param selectItem セットする selectItem
	 */
	public void setSelectItem(Map<String, String> selectItem) {
		this.selectItem = selectItem;
	}

	/**
	 * @return text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text セットする text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return radioValue
	 */
	public String getRadioValue() {
		return radioValue;
	}

	/**
	 * @param radioValue セットする radioValue
	 */
	public void setRadioValue(String radioValue) {
		this.radioValue = radioValue;
	}

	/**
	 * @return radioLabel
	 */
	public String getRadioLabel() {
		return radioLabel;
	}

	/**
	 * @param radioLabel セットする radioLabel
	 */
	public void setRadioLabel(String radioLabel) {
		this.radioLabel = radioLabel;
	}

	/**
	 * @return radioItem
	 */
	public Map<String, String> getRadioItem() {
		return radioItem;
	}

	/**
	 * @param radioItem セットする radioItem
	 */
	public void setRadioItem(Map<String, String> radioItem) {
		this.radioItem = radioItem;
	}

	/**
	 * @return checkedValue
	 */
	public String[] getCheckedValue() {
		return checkedValue;
	}

	/**
	 * @param checkedValue セットする checkedValue
	 */
	public void setCheckedValue(String[] checkedValue) {
		this.checkedValue = checkedValue;
	}

	/**
	 * @return checkItem
	 */
	public Map<String, String> getCheckItem() {
		return checkItem;
	}

	/**
	 * @param checkItem セットする checkItem
	 */
	public void setCheckItem(Map<String, String> checkItem) {
		this.checkItem = checkItem;
	}



}
