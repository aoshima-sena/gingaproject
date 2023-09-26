package jp.co.ginga.spring.base.step4;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
*
* @author yoshi
*
*/
@Controller
public class Step4Controller {

	/**
	* selectの表示に使用するアイテム
	* MapにString型の値をペアで格納する
	*/
	final static Map<String, String> SELECT_ITEMS = Collections
			.unmodifiableMap(new LinkedHashMap<String, String>() {
				{
					put("1", "A型");
					put("2", "B型");
					put("3", "AB型");
					put("4", "O型");
				}
			});

	/**
	* radio button の表示に使用するアイテム
	* MapにString型の値をペアで格納する
	*/
	final static Map<String, String> RADIO_ITEMS = Collections
			.unmodifiableMap(new LinkedHashMap<String, String>() {
				{
					put("1", "男");
					put("2", "女");
					put("3", "どちらでもない");
				}
			});

	/**
	* check boxの表示に使用するアイテム
	* MapにString型の値をペアで格納する
	*/
	final static Map<String, String> CHECK_ITEMS = Collections
			.unmodifiableMap(new LinkedHashMap<String, String>() {
				{
					put("1", "すし");
					put("2", "とんかつ");
					put("3", "焼肉");
					put("4", "唐揚げ");
					put("5", "アイス");
					put("6", "しゃぶしゃぶ");
					put("7", "ラーメン");
					put("8", "餃子");
				}
			});

	// "/step4"への遷移処理
	@GetMapping("/step4")
	public String createIndexGet(@ModelAttribute @Validated Step4Form form, Model model) {

		// セレクトボックスで選択した値を格納
		form.setSelectItem(SELECT_ITEMS);

		// ラジオボタンで選択した値を格納
		form.setRadioItem(RADIO_ITEMS);

		// チェックボックスで選択した値を格納
		form.setCheckItem(CHECK_ITEMS);

		// 格納した値を設定
		model.addAttribute("step4form", form);

		// 表示するHTMLを返す
		return "step4/indexAnsCssTymeleaf";
	}

	// "/step4/submit"への遷移処理
	@PostMapping("/step4/submit")
	public String createConfirmPost(@ModelAttribute @Validated Step4Form form,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "step4";
		}

		form.setSelectItem(SELECT_ITEMS);
		form.setRadioItem(RADIO_ITEMS);
		form.setCheckItem(CHECK_ITEMS);

		model.addAttribute("step4form", form);

		// コンソールに表示
		System.out.println("selected->" + form.getSelectedValue());

		return "step4/confirm";
	}

}
