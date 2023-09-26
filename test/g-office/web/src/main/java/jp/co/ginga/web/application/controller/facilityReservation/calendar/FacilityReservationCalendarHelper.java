package jp.co.ginga.web.application.controller.facilityReservation.calendar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ginga.web.application.util.form.FacilityReservation.FacilityReservationForm;
import jp.co.ginga.web.application.util.helper.facility.FacilityFormHelper;
import jp.co.ginga.web.application.util.helper.facilityReservation.CalenderYearFormHelper;
import jp.co.ginga.web.application.util.helper.facilityReservation.FacilityReservationFormHelper;
import jp.co.ginga.web.application.util.helper.facilitytype.FacilityTypeFormHelper;
import jp.co.ginga.web.application.util.session.faciliyReservation.FacilityReservationSession;
import jp.co.ginga.web.domain.service.facilityReservation.FacilityReservationManagerDto;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;

@Component
public class FacilityReservationCalendarHelper {

	@Autowired
	FacilityFormHelper facilityHelper;
	@Autowired
	FacilityTypeFormHelper facilityTypeHelper;
	@Autowired
	FacilityReservationFormHelper reservationFormHelper;
	@Autowired
	CalenderYearFormHelper yearHelper;

	//FacilityReservationCalendarFormにFacilityReservationSessionのFacilityReservationFormを入れる
	public FacilityReservationCalendarForm createFacilityReservationForm(FacilityReservationSession session) {
		FacilityReservationCalendarForm form = FacilityReservationCalendarForm.getIntance();
		form.setFacilityReservationForm(session.getFacilityReservationForm());
		form.setFacilityForm(session.getFacilityForm());

		return form;
	}

	//使ってない
	//FacilityReservationCalendarFormにFacilityReservationDtoを入れる
	public FacilityReservationCalendarForm createFacilityListForm(FacilityReservationManagerDto dto) {
		FacilityReservationCalendarForm form = FacilityReservationCalendarForm.getIntance();

		//	FacilityTypeDto facilityTypeDto = FacilityTypeDto.getInstance();

		FacilityReservationDto reservationDto = dto.getReservationDto();
		if (reservationDto != null) {
			reservationDto.setFacilityDto(dto.getReservationDto().getFacilityDto());
			FacilityReservationForm facilityReservationForm = reservationFormHelper
					.convertReservationForm(reservationDto);
			form.setFacilityReservationForm(facilityReservationForm);
		}

		if (dto.getFacilityDto() != null) {
			form.setFacilityForm(facilityHelper.convertFacilityForm(dto.getFacilityDto()));
		}

		//		List<FacilityReservationDto> list = dto.getReservationDtoList();
		//		List<FacilityReservationForm> formList = new ArrayList<FacilityReservationForm>();
		//
		//		if(list !=null) {
		//			for(FacilityReservationDto facilityReservationDto : list) {
		//				formList.add(new FacilityReservationForm(facilityReservationDto.getReservationId(), facilityReservationDto.getStartTime(),facilityReservationDto.getEndTime(), null));
		//			}
		//			/*	reservationDto.setStartTime(list.get(0).getStartTime());
		//				reservationDto.setEndTime(list.get(0).getEndTime());
		//				List<FacilityReservationForm> formList = new ArrayList<FacilityReservationForm>();*/
		//			form.setFacilityReservationFormList(formList);
		//		}

		//		FacilityDto facilityDto = dto.getFacilityDto();
		//		FacilityForm facilityForm = facilityHelper.convertFacilityForm(facilityDto);
		//		facilityReservationForm.setFacilityForm(facilityForm);
		//		if(dto.getFacilityTypeDtoList() !=null) {
		//			List<FacilityTypeDto> facilityTypeDto = dto.getFacilityTypeDtoList();
		//			List<FacilityTypeForm> facilityTypeForm = facilityTypeHelper.convertFacilityTypeFormList(facilityTypeDto);
		//			facilityReservationForm.setFacilityTypeFormList(facilityTypeForm);
		//		}

		//		form.setFacilityFormList(facilityFormList);
		//ReservationCalendarFormからReservationDtoに飛んで（ここからあやふや）facilityFormListを入れる
		return form;

	}

	public FacilityReservationCalendarForm createStartEnd(FacilityReservationManagerDto dto) {
		FacilityReservationCalendarForm form = FacilityReservationCalendarForm.getIntance();
		List<FacilityReservationDto> list = dto.getReservationDtoList();
		List<FacilityReservationForm> formList = new ArrayList<FacilityReservationForm>();

		if (list != null) {
			for (FacilityReservationDto facilityReservationDto : list) {
				FacilityReservationForm facilityReservationForm = reservationFormHelper
						.convertReservationForm(facilityReservationDto);
				formList.add(new FacilityReservationForm(facilityReservationDto.getReservationId(),
						facilityReservationDto.getStartTime(), facilityReservationDto.getEndTime(),
						facilityReservationForm.getFacilityForm(), null, null, null));
			}
			/*	FacilityReservationDto reservationDto = dto.getReservationDto();
				if (reservationDto != null) {
					reservationDto.setFacilityDto(dto.getReservationDto().getFacilityDto());
					FacilityReservationForm facilityReservationForm = reservationFormHelper
							.convertReservationForm(reservationDto);
					form.setFacilityReservationForm(facilityReservationForm);
				}
				if (dto.getFacilityDto() != null) {
					form.setFacilityForm(facilityHelper.convertFacilityForm(dto.getFacilityDto()));
				}*/
			/*	reservationDto.setStartTime(list.get(0).getStartTime());
				reservationDto.setEndTime(list.get(0).getEndTime());
				List<FacilityReservationForm> formList = new ArrayList<FacilityReservationForm>();*/
			form.setFacilityReservationFormList(formList);
		}
		return form;
	}
	/*
		//FacilityReservationManagerDtoからCalenderFormからfacilityReservationCalenderFormへ
		public FacilityReservationCalendarForm createYear(FacilityReservationManagerDto dto) {
			FacilityReservationCalendarForm form = FacilityReservationCalendarForm.getIntance();
			CalendarYearForm yearForm = CalendarYearForm.getInstance();
			yearForm.setYear(dto.getYear());
			form.setCalenderYearForm(yearForm);

			//		yearForm.setCalenderYearForm(yearHelper.getYear(dto.getYear()));
			return form;

		}

		public FacilityReservationCalendarForm createMonth(FacilityReservationManagerDto dto) {
			FacilityReservationCalendarForm form = FacilityReservationCalendarForm.getIntance();
			CalendarMonthForm monthForm = CalendarMonthForm.getInstance();
			monthForm.setMonth(dto.getMonth());
			form.setCalenderMonthForm(monthForm);
			return form;
		}
	*/

	public FacilityReservationCalendarForm getFacilityForm(FacilityReservationManagerDto dto) {
		FacilityReservationCalendarForm form = FacilityReservationCalendarForm.getIntance();
		FacilityDto facilityDto = dto.getFacilityDto();
		if(facilityDto != null) {
			FacilityReservationForm facilityReservationForm = FacilityReservationForm.getInstance();
		facilityReservationForm.setFacilityForm(facilityHelper.convertFacilityForm(facilityDto));
		form.setFacilityReservationForm(facilityReservationForm);
		}
		return form;

	}
}
