package jp.co.ginga.web.domain.service.user;

import java.util.List;

import jp.co.ginga.web.domain.service.util.dto.role.RoleDto;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;
import jp.co.ginga.web.domain.service.util.dto.userrole.UserRoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yoshi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserManagerDto {

	public int ERROR = -1;

	private int OPTIMISTIC_ROCKER_ERROR = -2;

	private int OK = 0;

	private int THERE_ID_DATA = 1;

	private int NO_DATA = 2;

	/**
	 * 楽観的ロック
	 */
	private String optimisticRockValue;

	/**
	 * ユーザー情報
	 */
	private UserDto userDto;

	/**
	 * ユーザー情報リスト
	 */
	private List<UserDto> userDtoList;

	/**
	 * 権限情報リスト
	 */
	private List<RoleDto> roleDtoList;

	//	/**
	//	 *ユーザー権限情報リスト
	//	 */
	private List<UserRoleDto> userRoleDtoList;

	/**
	 * 処理結果コード
	 */
	private int result;

	/**
	 * インスタンス取得
	 * @return
	 */
	public static UserManagerDto getInstance() {
		return new UserManagerDto();
	}
}
