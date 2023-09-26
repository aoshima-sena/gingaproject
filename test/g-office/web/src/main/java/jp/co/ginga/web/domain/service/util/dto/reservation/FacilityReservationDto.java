package jp.co.ginga.web.domain.service.util.dto.reservation;

import java.sql.Timestamp;
import java.util.List;

import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacilityReservationDto {
	private int reservationId;

	private Timestamp startTime;

	private Timestamp endTime;

	private Timestamp insertDate;

	private Timestamp updateDate;

	private FacilityDto facilityDto;

	private FacilityTypeDto facilityTypeDto;

	private List<FacilityDto> facilityDtoList;

	private List<FacilityTypeDto> facilityTypeDtoList;

	private UserDto userDto;


}
