package jp.co.ginga.web.domain.service.util.dto.facilitytype;

import java.util.Date;

import jp.co.ginga.web.domain.service.util.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
public class FacilityTypeDto {
	//種別ID
	private int facilityTypeId;
	//種別名
	private String name;
	//登録した日付
	private Date insertDate;
	//ユーザーDto
	private UserDto insertUserDto;

	public static FacilityTypeDto getInstance() {
		return new FacilityTypeDto();
	}

	public FacilityTypeDto(int facilityTypeId, String name) {
		this.facilityTypeId = facilityTypeId;
		this.name = name;
	}

}
