package jp.co.ginga.web.application.controller.facilityType.add;

import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.session.facilityType.FacilityTypeSession;

@Component
public class FacilityTypeAddHelper {

	public FacilityTypeAddForm createFacilityTypeAddForm(final FacilityTypeSession facilityTypeSession) {
		FacilityTypeAddForm form = FacilityTypeAddForm.getInstance();
		form.setFacilityTypeForm(facilityTypeSession.getFacilityTypeForm());


		return form;
	}
}
