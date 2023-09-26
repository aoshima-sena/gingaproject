package jp.co.ginga.infra.repository.facilitytype;

import java.sql.Date;

import jp.co.ginga.infra.repository.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacilityTypeEntity {

	private int facilityTypeId;

	private String name;

	private Date insertDate;

	private UserEntity insertUserEntity;

	private Date updateDate;

	private UserEntity updateUserEntity;

	private Date deleteDate;

	private UserEntity deleteUserEntity;

	private boolean fgDelete;

	//	private String toString;

	public String toString() {

		String str = this.facilityTypeId
				+ "," + name
				+ "," + (insertDate == null ? "null" : insertDate.toString())
				+ "," + insertUserEntity
				+ "," + (updateDate == null ? "null" : updateDate.toString())
				+ "," + updateUserEntity
				+ "," + (deleteDate == null ? "null" : deleteDate.toString())
				+ "," + deleteUserEntity
				+ "," + fgDelete;
		return str;
	}

}
