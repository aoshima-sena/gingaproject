package jp.co.ginga.spring.base.step5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author someya
 *
 */
@Controller
public class Step5Controller {

	/**
	 * セッションとして使用
	 */
	@Autowired
	Step5SessionForm step5SessionForm;

	/**
	 * パスワード確認用バリデータ―
	 */
	@Autowired
	PasswordCheckValidator passwordCheckValidator;

	@ModelAttribute(name = "step5Form")
	public Step5Form step5Form() {
		return new Step5Form();
	}

	/**
	 * カスタムバリデータ―の登録
	 *
	 * @param binder
	 */
	@InitBinder("step5Form")
	public void validatorBinder(WebDataBinder binder) {
		binder.addValidators(passwordCheckValidator);
	}

	/**
	 * step5 URLリクエスト処理 Get送信
	 *
	 * @param modelMap
	 * @return
	 */
	@GetMapping("/step5")
	public String createIndexGet(ModelMap modelMap) {
		String key = BindingResult.MODEL_KEY_PREFIX + "step5Form";
		System.out.println("createIndexGet() start");

		if (modelMap.containsKey("errors")) {
			System.out.println("createIndexGet() errors");
			System.out.println("key->" + key);
			modelMap.addAttribute(key, modelMap.get("errors"));

		} else if (step5SessionForm.getStep5Form() != null) {
			modelMap.addAttribute("step5Form", step5SessionForm.getStep5Form());

		} else {
			modelMap.addAttribute("step5Form", new Step5Form());
		}

		System.out.println("createIndexGet() end");
		return "step5/index";
	}

	/**
	 * step5/submit name = foward URLリクエスト処理 Post送信
	 *
	 * @param form   Step5Form
	 * @param result バリデータチェック結果
	 * @param model  Modelオブジェクト
	 * @return 遷移画面名、若しくは URL
	 */
	@PostMapping(path = "/step5/submit", params = "foward")
	public String createConfirmFowardPost(@Validated Step5Form form, BindingResult result, Model model) {
		System.out.println("createConfirmFowardPost() start");

		// バリデータチェック
		if (result.hasErrors()) {
			return "step5/index";
		}

		// sessionデータを設定
		step5SessionForm.createSession();
		step5SessionForm.getStep5Form().setInputText1(form.getInputText1());
		step5SessionForm.getStep5Form().setInputText2(form.getInputText2());
		step5SessionForm.getStep5Form().setInputText3(form.getInputText3());
		step5SessionForm.getStep5Form().setInputText4(form.getInputText4());
		step5SessionForm.getStep5Form().setInputText5(form.getInputText5());
		step5SessionForm.getStep5Form().setInputText6(form.getInputText6());
		step5SessionForm.getStep5Form().setInputText7(form.getInputText7());
		step5SessionForm.getStep5Form().setInputText8(form.getInputText8());
		step5SessionForm.getStep5Form().setInputNo1(form.getInputNo1());

		model.addAttribute("step5Form", form);

		System.out.println("createConfirmFowardPost() end");
		return "step5/confirm";
	}

	/**
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @param ra
	 * @return
	 */
	@PostMapping(path = "/step5/submit", params = "redirect")
	public String createConfirmRidirectPost(@Validated Step5Form form, BindingResult result, Model model,
			RedirectAttributes ra) {

		System.out.println("createConfirmRidirectPost() start");

		// バリデータチェック
		if (result.hasErrors()) {
			System.out.println("createConfirmRidirectPost() redirect");
			ra.addFlashAttribute("errors", result);
			return "redirect:/step5";
		}

		// sessionデータを設定
		step5SessionForm.createSession();
		step5SessionForm.getStep5Form().setInputText1(form.getInputText1());
		step5SessionForm.getStep5Form().setInputText2(form.getInputText2());
		step5SessionForm.getStep5Form().setInputText3(form.getInputText3());
		step5SessionForm.getStep5Form().setInputText4(form.getInputText4());
		step5SessionForm.getStep5Form().setInputText5(form.getInputText5());
		step5SessionForm.getStep5Form().setInputText6(form.getInputText6());
		step5SessionForm.getStep5Form().setInputText7(form.getInputText7());
		step5SessionForm.getStep5Form().setInputText8(form.getInputText8());
		step5SessionForm.getStep5Form().setInputNo1(form.getInputNo1());

		model.addAttribute("step5form", form);

		System.out.println("createConfirmRidirectPost() end");
		return "step5/confirm";
	}

	/**
	 *
	 * @param sessionStatus
	 * @return
	 */
	@PostMapping(path = "/step5/submit", params = "sessionComplete")
	public String sessionCompletePost(SessionStatus sessionStatus) {
		System.out.println("sessionCompletePost() start");

		step5SessionForm.clear();

		System.out.println("sessionCompletePost() end");
		return "redirect:/step5";
	}

}