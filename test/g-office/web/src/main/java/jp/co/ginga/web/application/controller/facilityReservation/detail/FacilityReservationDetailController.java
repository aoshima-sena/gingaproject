package jp.co.ginga.web.application.controller.facilityReservation.detail;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import jp.co.ginga.web.application.util.helper.facilityReservation.FacilityReservationFormHelper;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerService;

@Controller
public class FacilityReservationDetailController {

	@Autowired
	FacilityReservationSession facilityReservationSession;
	@Autowired
	FacilityReservationManagerService service;
	@Autowired
	FacilityReservationDetailHelper facilityReservationDetailHelper;
	@Autowired
	FacilityReservationFormHelper facilityReservationFormHelper;

	@GetMapping("/facilityreservation/detail/{reservationId}")
	public String getFacilityReservationDetail(ModelMap mdMap, @PathVariable int reservationId) {
		FacilityReservationDetailForm facilityReservationDetailForm = null;
		if (mdMap.containsKey("error")) {
			facilityReservationDetailForm = facilityReservationDetailHelper
					.createFacilityReservationDetailForm(facilityReservationSession);
			mdMap.addAttribute("facilityReservationDetailForm", facilityReservationDetailForm);
			String key = BindingResult.MODEL_KEY_PREFIX + "facilityReservationDetailForm";
			mdMap.addAttribute(key, mdMap.get("error"));
		} else {
			facilityReservationSession.clear();
			FacilityReservationManagerDto facilityReservationManagerDto = service.getReservationId(reservationId);
			facilityReservationDetailForm = facilityReservationDetailHelper
					.createFacilityReservationDetailForm(facilityReservationManagerDto);
			facilityReservationSession.setFacilityForm(facilityReservationDetailForm.getFacilityForm());

			//FacilityReservationManagerDtoをfacilityReservationDetailFormのfacilityReservationListに入れたい
			FacilityReservationManagerDto dto = service.findStartEnd(
					facilityReservationDetailForm.getFacilityReservationForm().getFacilityForm().getFacilityId());
			List<FacilityReservationForm> list = new ArrayList<FacilityReservationForm>();

			list = facilityReservationFormHelper.convertReservationForm(dto.getReservationDtoList());

			facilityReservationDetailForm.setFacilityReservationFormList(list);
			mdMap.addAttribute("facilityReservationDetailForm", facilityReservationDetailForm);

			//何とかfacilityReservationDetailFormListを入れたいけどできないものか？
		}
		return "facilityReservation/facilityReservation-detail";
	}

	@ResponseBody
	@GetMapping("/facilityreservation/detail/remake/{reservationId}")
	public FacilityReservationDetailForm getFacilityReservationDetailForm(@PathVariable int reservationId) {

		FacilityReservationManagerDto facilityReservationManagerDto = service.getReservationId(reservationId);
		FacilityReservationDetailForm facilityReservationDetailForm = facilityReservationDetailHelper
				.createFacilityReservationDetailForm(facilityReservationManagerDto);
		facilityReservationSession.setFacilityForm(facilityReservationDetailForm.getFacilityForm());

		//FacilityReservationManagerDtoをfacilityReservationDetailFormのfacilityReservationListに入れたい
		FacilityReservationManagerDto dto = service.findStartEnd(
				facilityReservationDetailForm.getFacilityReservationForm().getFacilityForm().getFacilityId());
		List<FacilityReservationForm> list = new ArrayList<FacilityReservationForm>();

		list = facilityReservationFormHelper.convertReservationForm(dto.getReservationDtoList());

		facilityReservationDetailForm.setFacilityReservationFormList(list);
		return facilityReservationDetailForm;
	}
}
