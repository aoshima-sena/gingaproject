package jp.co.ginga.web.domain.service.facility;

import java.util.List;

import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacilityManagerDto {

	//楽観的ロック
	private String optimisticRockValue;
	//処理結果
	private int result;
	//施設情報
	private FacilityDto facilityDto;
	//施設情報リスト
	private List<FacilityDto> facilityDtoList;
	//施設種別情報リスト
	private List<FacilityTypeDto> facilityTypeDtoList;
	//種別情報
	private FacilityTypeDto facilityTypeDto;

	public static FacilityManagerDto getInstance() {
		return new FacilityManagerDto();
	}
}
