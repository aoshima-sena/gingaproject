package jp.co.ginga.web.application.validation.facility;

import java.util.Locale;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import jp.co.ginga.web.application.validation.ValidationItem;

public class FacilityNameValidatorImpl implements ConstraintValidator<FacilityNameValidator, Object> {

	@Autowired
	private ValidationItem item;

	@Autowired
	private MessageSource msg;

	public boolean isValid(Object value, ConstraintValidatorContext context) {

		String str = (String) value;

		if (item.isNull(str) || item.isEmpty(str)) {
			return item.createErrorWithMsg(msg.getMessage("Facility.required", null, Locale.getDefault()), context);

		} else if (item.isBlank(str)) {
			return item.createErrorWithMsg(msg.getMessage("Facility.blank", null, Locale.getDefault()), context);

		} else if (item.isFirstSpace(str)) {
			return item.createErrorWithMsg(msg.getMessage("Facility.blankFirst", null, Locale.getDefault()), context);

		} else if (item.isLastSpace(str)) {
			return item.createErrorWithMsg(msg.getMessage("Facility.blankLast", null, Locale.getDefault()), context);
		} else if (!item.isBetween(str, 1, 20)) {
			return item.createErrorWithMsg(
					msg.getMessage("Facility.range", new String[] { "1", "20" }, Locale.getDefault()), context);
		}
		return true;
	}
}
