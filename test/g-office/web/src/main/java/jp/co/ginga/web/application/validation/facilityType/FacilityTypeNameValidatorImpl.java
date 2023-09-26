package jp.co.ginga.web.application.validation.facilityType;

import java.util.Locale;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import jp.co.ginga.web.application.validation.ValidationItem;

public class FacilityTypeNameValidatorImpl implements ConstraintValidator<FacilityTypeNameValidator, Object> {

	@Autowired
	private ValidationItem item;

	@Autowired
	private MessageSource msg;

	public boolean isValid(Object value, ConstraintValidatorContext context) {
		String str = (String) value;

		if (item.isNull(str) || item.isEmpty(str)) {
			return item.createErrorWithMsg(msg.getMessage("FacilityType.required", null, Locale.getDefault()), context);

		} else if (item.isBlank(str)) {
			return item.createErrorWithMsg(msg.getMessage("FacilityType.blank", null, Locale.getDefault()), context);

		} else if (item.isFirstSpace(str)) {
			return item.createErrorWithMsg(msg.getMessage("FacilityType.blankFirst", null, Locale.getDefault()),
					context);

		} else if (item.isLastSpace(str)) {
			return item.createErrorWithMsg(msg.getMessage("FacilityType.blankLast", null, Locale.getDefault()),
					context);
		} else if (!item.isBetween(str, 1, 10)) {
			return item.createErrorWithMsg(
					msg.getMessage("FacilityType.range", new String[] { "1", "10" }, Locale.getDefault()), context);
		}
		return true;
	}
}
