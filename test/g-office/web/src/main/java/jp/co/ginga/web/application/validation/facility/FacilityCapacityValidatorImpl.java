package jp.co.ginga.web.application.validation.facility;

import java.util.Locale;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.ginga.web.application.validation.ValidationItem;

public class FacilityCapacityValidatorImpl implements ConstraintValidator<FacilityCapacityValidator, Object> {

	@Autowired
	ValidationItem item;

	@Autowired
	MessageSource msg;

	@PostMapping(path = "facility/confirm", params = "add")
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		String str = (String) value;

		if (item.isNull(str) || item.isEmpty(str)) {
			return item.createErrorWithMsg(msg.getMessage("Facility.required", null, Locale.getDefault()), context);

		} else if (!item.isInteger(str)) {
			return item.createErrorWithMsg(msg.getMessage("Facility.halfNum", null, Locale.getDefault()), context);

		} else if (!item.isRange(str, 1, 1000)) {
			return item.createErrorWithMsg(
					msg.getMessage("Facility.range", new String[] { "1", "1000" }, Locale.getDefault()), context);

		}
		return true;

	}

}
