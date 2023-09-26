package jp.co.ginga.web.domain.service.util.dto.facility;


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
public class FacilityDto {
	//施設ID
		private int facilityId;
	//施設名
		private String name;
	//定員
		private int capacity;
	//種別Dto
		private FacilityTypeDto FacilityTypeDto;
	//ユーザーDto
		private UserDto userDto;

		public static FacilityDto getInstance() {
			return new FacilityDto();
		}
}
