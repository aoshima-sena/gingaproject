package jp.co.ginga.web.domain.service.facilitytype;

import java.util.List;

import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import jp.co.ginga.web.domain.service.util.dto.role.RoleDto;
import jp.co.ginga.web.domain.service.util.dto.userrole.UserRoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacilityTypeManagerDto {

	private String optimisticRockValue;
	private int result;
	private FacilityTypeDto facilityTypeDto;
	private List<FacilityTypeDto> facilityTypeDtoList;
	private List<RoleDto> roleDtoList;
	private List<UserRoleDto> userRoleDtoList;


	public static FacilityTypeManagerDto getInstance() {
		return new FacilityTypeManagerDto();
	}

}
