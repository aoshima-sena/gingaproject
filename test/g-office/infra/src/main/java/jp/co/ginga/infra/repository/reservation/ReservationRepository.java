package jp.co.ginga.infra.repository.reservation;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ReservationRepository {

	//予約情報　主キー検索処理
	public ReservationEntity findOneById(ReservationEntity entity);

	//@Param　クエリで使用する値の指定
	//予約情報　施設IDかつ期間検索処理
	public List<ReservationEntity> findByFacilityIdAndStartDateBetween(@Param("facilityId") int facilityId,
			@Param("startTime") Timestamp startTime,
			@Param("endTime") Timestamp endTime);

	//予約情報可否取得処理
	public int canMakeReservation(@Param("facilityId") int facilityId, @Param("startTime") Timestamp startTime,
			@Param("endTime") Timestamp endTime);

	//予約情報　登録処理
	public int insert(ReservationEntity entity);

	//更新処理
	public int update(ReservationEntity entity);

	//削除機能
	public int delete(int reservationId);

	public ReservationEntity getReservationId(int reservationId);

	public List<ReservationEntity> findStartEnd(int facilityId);

	//reservationId検索処理
	public ReservationEntity findReservationId(@Param("facilityId") int facilityId,
			@Param("startTime") Timestamp startTime, @Param("endTime") Timestamp endTime);

	//年取得
	@Select("select extract(year from current_date)")
	public int getYear();

	//月取得
	@Select("select extract(month from current_date)")
	public int getMonth();

	//日付取得
	@Select("select extract(day from current_date)")
	public int getDay();
}
