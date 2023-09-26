package jp.co.ginga.web.domain.service.facilityReservation;

import java.util.List;

import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacilityReservationManagerDto {

	//楽観的ロック
	private String optimisticRockValue;
	//施設情報リスト
	private List<FacilityDto> facilityDtoList;
	//施設種別情報リスト
	private List<FacilityTypeDto> facilityTypeDtoList;

	private List<FacilityReservationDto> reservationDtoList;

	private FacilityReservationDto reservationDto;

	private int result;

	private FacilityDto facilityDto;

	private FacilityTypeDto facilityTypeDto;

	private String year;

	private String month;

	private String day;

	public static FacilityReservationManagerDto getInstance() {
		return new FacilityReservationManagerDto();
	}
}
