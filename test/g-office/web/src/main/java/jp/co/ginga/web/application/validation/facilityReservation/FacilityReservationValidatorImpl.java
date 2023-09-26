package jp.co.ginga.web.application.validation.facilityReservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import jp.co.ginga.web.application.validation.ValidationItem;

public class FacilityReservationValidatorImpl implements ConstraintValidator<FacilityReservationValidator, Object> {
	@Autowired
	ValidationItem item;

	@Autowired
	MessageSource msg;

	public boolean isValid(Object value,ConstraintValidatorContext context) {
		String str=(String) value;
		return true;


	}
}
