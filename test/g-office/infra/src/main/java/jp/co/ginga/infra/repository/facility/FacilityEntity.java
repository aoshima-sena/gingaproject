package jp.co.ginga.infra.repository.facility;

import java.sql.Timestamp;

import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.infra.repository.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacilityEntity {
	private int facilityId;

	private String name;

	private int capacity;

	private FacilityTypeEntity facilityTypeEntity;

	private Timestamp insertDate;

	private UserEntity insertUserEntity;

	private Timestamp updateDate;

	private UserEntity updateUserEntity;

	public String toString() {
		String str = this.facilityId
				+ "," + name
				+ "," + capacity
				+ "," + facilityTypeEntity
				+ "," + (insertDate == null ? "null" : insertDate.toString())
				+ "," + insertUserEntity
				+ "," + (updateDate == null ? "null" : updateDate.toString())
				+ "," + updateUserEntity;

		return str;
	}

}
