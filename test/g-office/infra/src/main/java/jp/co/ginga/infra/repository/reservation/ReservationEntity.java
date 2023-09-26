package jp.co.ginga.infra.repository.reservation;

import java.sql.Timestamp;

import jp.co.ginga.infra.repository.facility.FacilityEntity;
import jp.co.ginga.infra.repository.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservationEntity {


	private int reservationId;
	private Timestamp startTime;
	private Timestamp endTime;
	private FacilityEntity facilityEntity;
	private Timestamp insertDate;
	private UserEntity insertUserEntity;
	private Timestamp updateDate;
	private UserEntity updateUserEntity;

	//いるかどうか分からない↓
	public static ReservationEntity getInstance() {
		// TODO 自動生成されたメソッド・スタブ
		return new ReservationEntity();
	}

}
