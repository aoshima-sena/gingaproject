package jp.co.ginga.web.application.controller.testReservation.list;

import java.util.List;

import jp.co.ginga.web.application.controller.facilityReservation.list.FacilityReservationListForm;
import jp.co.ginga.web.application.util.form.facility.FacilityForm;
import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestFacilityReservationListForm {
	private String sysmsg;
	private FacilityForm facilityForm;
	private List<FacilityForm> facilityFormList;
	private List<FacilityTypeForm> facilityTypeFormList;

	public static FacilityReservationListForm getInstance() {
		return new FacilityReservationListForm();
	}
}
