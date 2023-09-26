package jp.co.ginga.web.application.controller.testReservation.confirm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.helper.facilityReservation.FacilityReservationFormHelper;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;

@Component
public class TestFacilityReservationConfirmHelper {
	@Autowired
	FacilityReservationFormHelper facilityReservationFormHelper;

	public TestFacilityReservationConfirmForm createForm(FacilityReservationSession session) {
		TestFacilityReservationConfirmForm form = TestFacilityReservationConfirmForm.getInstance();
		form.setCalendarMonthForm(session.getCalendarMonthForm());
		if (session.getFacilityReservationForm() != null) {
			form.setFacilityReservationForm(session.getFacilityReservationForm());
		}
		if (session.getFacilityReservationFormList() != null) {
			form.setFacilityReservationFormList(session.getFacilityReservationFormList());
		}
		form.setStartHour(session.getStartHour());
		form.setStartMin(session.getStartMin());
		form.setEndHour(session.getEndHour());
		form.setEndMin(session.getEndMin());
		return form;
	}
}
