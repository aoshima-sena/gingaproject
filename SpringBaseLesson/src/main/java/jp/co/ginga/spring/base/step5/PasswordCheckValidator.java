package jp.co.ginga.spring.base.step5;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PasswordCheckValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Step5Form.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Step5Form form = (Step5Form) target;

		if (!form.getInputText7().equals(form.getInputText8())) {
			errors.rejectValue("errMsg1", null, "確認用パスワードと一致しません。");
		}

	}

}
