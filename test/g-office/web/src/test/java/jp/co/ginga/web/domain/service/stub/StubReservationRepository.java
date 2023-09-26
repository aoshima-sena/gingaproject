package jp.co.ginga.web.domain.service.stub;

import java.sql.Timestamp;
import java.util.List;

import jp.co.ginga.infra.repository.reservation.ReservationEntity;
import jp.co.ginga.infra.repository.reservation.ReservationRepository;

public class StubReservationRepository implements ReservationRepository {

	@Override
	public ReservationEntity findOneById(ReservationEntity entity) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<ReservationEntity> findByFacilityIdAndStartDateBetween(int facilityId, Timestamp startTime,
			Timestamp endTime) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public int canMakeReservation(int facilityId, Timestamp startTime, Timestamp endTime) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int insert(ReservationEntity entity) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int update(ReservationEntity entity) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int delete(int reservationId) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}



	@Override
	public int getYear() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int getMonth() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int getDay() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public List<ReservationEntity> findStartEnd(int facilityId) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ReservationEntity getReservationId(int reservationId) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ReservationEntity findReservationId(int facilityId, Timestamp startTime, Timestamp endTime) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
