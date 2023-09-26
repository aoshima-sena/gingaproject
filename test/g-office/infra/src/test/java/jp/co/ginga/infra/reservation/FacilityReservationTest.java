package jp.co.ginga.infra.reservation;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.util.List;

import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jp.co.ginga.infra.repository.facility.FacilityEntity;
import jp.co.ginga.infra.repository.facility.FacilityRepository;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeRepository;
import jp.co.ginga.infra.repository.reservation.ReservationEntity;
import jp.co.ginga.infra.repository.reservation.ReservationRepository;
import jp.co.ginga.infra.repository.user.UserEntity;
import jp.co.ginga.infra.util.PostgreDataManager;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class FacilityReservationTest {

	@Autowired
	FacilityRepository facilityRepositry;
	@Autowired
	FacilityTypeRepository facilityTypeRepository;
	@Autowired
	ReservationRepository reservationRepository;

	/**
	 * findByFacilityId
	 * 正常系
	 */
	@Test
	public void findByFacilityIdMultipleTest() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/facility/setup_single_dataset_facility.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		FacilityTypeEntity entity = facilityTypeRepository.findOneById(1);

		assertEquals("会議室1", entity.getFacilityTypeId());

	}

	/**
	 * findOneById
	 * 正常系
	 */
	@Test
	public void findOneByIdTest() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/reservation/setup_dataset_reservation.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		String datetime = "2021-04-05 00:00:00";
		String endKunn = "2021-04-05 12:00:00";
		Timestamp startTime = Timestamp.valueOf(datetime);
		Timestamp endTime = Timestamp.valueOf(endKunn);
		int facilityId = 1;
		FacilityEntity facilityEntity = new FacilityEntity();
		facilityEntity.setFacilityId(facilityId);
		Timestamp insertDate = Timestamp.valueOf(datetime);
		UserEntity userEntity = new UserEntity();
		String userId = "1";
		userEntity.setUserId(userId);
		Timestamp updateDate = Timestamp.valueOf(datetime);

		ReservationEntity reservatioinEntity = new ReservationEntity(1, startTime, endTime, facilityEntity, insertDate,
				userEntity, updateDate, userEntity);
		ReservationEntity entity = reservationRepository.findOneById(reservatioinEntity);

		assertEquals(1, entity.getReservationId());
		assertEquals(startTime, entity.getStartTime());
		assertEquals(endTime, entity.getEndTime());
		assertEquals(facilityId, entity.getFacilityEntity().getFacilityId());

		//	assertEquals(userId,entity.getInsertUserEntity().getUserId());
	}

	/**
	 * findOneById
	 * 異常系
	 */
	@Test
	public void NoFindOneByIdTest() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/util/setup_nodata.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		String datetime = "2022-12-07 09:00:00";
		Timestamp startTime = Timestamp.valueOf(datetime);
		Timestamp endTime = Timestamp.valueOf(datetime);
		FacilityEntity facilityEntity = null;
		Timestamp insertDate = Timestamp.valueOf(datetime);
		UserEntity userEntity = null;
		Timestamp updateDate = Timestamp.valueOf(datetime);
		UserEntity updateUserEntity = null;

		ReservationEntity reservatioinEntity = new ReservationEntity(0, startTime, endTime, facilityEntity, insertDate,
				userEntity, updateDate, updateUserEntity);
		ReservationEntity entity = reservationRepository.findOneById(reservatioinEntity);

		assertEquals(0, entity.getFacilityEntity().getFacilityId());
	}

	/**
	 * findByFacilityIdAndStartDateBetween
	 * 正常系
	 */
	@Test
	public void findByFacilityIdAndStartDateBetweenTest() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/reservation/setup_dataset_reservation.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		String starttime = "2021-04-05 09:00:00";
		String endtime = "2021-04-05 12:00:00";
		int facilityId = 1;
		Timestamp startTime = Timestamp.valueOf(starttime);
		Timestamp endTime = Timestamp.valueOf(endtime);

		List<ReservationEntity> list = reservationRepository.findByFacilityIdAndStartDateBetween(facilityId,
				startTime, endTime);

		assertEquals(list.size(), 1);

		assertEquals(1, list.get(0).getFacilityEntity().getFacilityId());
		assertEquals(startTime, list.get(0).getStartTime());
		assertEquals(endTime, list.get(0).getEndTime());
	}

	/**
	 * findByFacilityIdAndStartDateBetween
	 * データがない場合
	 */
	@Test
	public void NofindByFacilityIdAndStartDateBetweenTest() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/util/setup_nodata.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		String starttime = "2021-04-05 09:00:00";
		String endtime = "2021-04-05 12:00:00";
		int facilityId = 1;
		Timestamp startTime = Timestamp.valueOf(starttime);
		Timestamp endTime = Timestamp.valueOf(endtime);

		List<ReservationEntity> list = reservationRepository.findByFacilityIdAndStartDateBetween(facilityId,
				startTime, endTime);

		assertEquals(list.size(), 1);

		assertEquals(0, list.get(0).getFacilityEntity().getFacilityId());
		assertEquals(startTime, list.get(0).getStartTime());
		assertEquals(endTime, list.get(0).getEndTime());
	}

	/**
	 * canMakeReservation
	 * 正常系
	 */
	@Test
	public void canMakeReservationTest() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/reservation/setup_dataset_reservation.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		String starttime = "2021-04-05 09:00:00";
		String endtime = "2021-04-05 12:00:00";
		int facilityId = 1;
		Timestamp startTime = Timestamp.valueOf(starttime);
		Timestamp endTime = Timestamp.valueOf(endtime);

		int result = reservationRepository.canMakeReservation(facilityId, startTime, endTime);

		assertEquals(1, result);

	}

	/**
	 * canMakeReservation
	 * 異常系
	 */
	@Test
	public void NocanMakeReservationTest() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/util/setup_nodata.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		String starttime = "2021-04-05 09:00:00";
		String endtime = "2021-04-05 12:00:00";
		int facilityId = 1;
		Timestamp startTime = Timestamp.valueOf(starttime);
		Timestamp endTime = Timestamp.valueOf(endtime);

		int result = reservationRepository.canMakeReservation(facilityId, startTime, endTime);

		assertEquals(0, result);
	}

	/**
	 * findStartEnd
	 * 正常系
	 */
	@Test
	public void testStartEnd() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/reservation/setup_dataset_reservation.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		String starttime = "2021-04-05 09:00:00";
		String endtime = "2021-04-05 12:00:00";
		int facilityId = 1;
		Timestamp startTime = Timestamp.valueOf(starttime);
		Timestamp endTime = Timestamp.valueOf(endtime);

		List<ReservationEntity> list = reservationRepository.findStartEnd(facilityId);
		assertEquals(1, list.size());
		for (int i = 0; i < 4; i++) {
			assertEquals("施設名" + 1, list.get(0).getFacilityEntity().getName());
			//	assertEquals(startTime,list.get(0).getStartTime());
		}
	}

	/**
	 * findReservationId
	 * 正常系
	 */
	@Test
	public void findByReservationTest() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/reservation/setup_dataset_reservation.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}
		String starttime = "2021-04-05 09:00:00";
		String endtime = "2021-04-05 12:00:00";
		Timestamp startTime = Timestamp.valueOf(starttime);
		Timestamp endTime = Timestamp.valueOf(endtime);
		int facilityId = 1;
		ReservationEntity entity = reservationRepository.findReservationId(facilityId, startTime, endTime);
		assertEquals(1, entity.getReservationId());

	}

	/**
	 * insert
	 * 正常系
	 */
	@Test
	public void insertOk() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/reservation/setup_dataset_reservation.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		String starttime = "2021-04-05 09:00:00";
		String endtime = "2021-04-05 12:00:00";
		String datetime = "2021-04-01 12:00:00";
		int reservationId = 1;
		Timestamp startTime = Timestamp.valueOf(starttime);
		Timestamp endTime = Timestamp.valueOf(endtime);
		FacilityEntity facilityEntity = null;

		Timestamp insertDate = Timestamp.valueOf(datetime);
		UserEntity insertUserEntity = null;
		Timestamp updateDate = Timestamp.valueOf(datetime);
		UserEntity updateUserEntity = null;

		ReservationEntity reservationEntity = new ReservationEntity(reservationId, startTime, endTime, facilityEntity,
				insertDate, insertUserEntity, updateDate, updateUserEntity);

		int result = reservationRepository.insert(reservationEntity);

		assertEquals(1, result);

		ReservationEntity kekka = reservationRepository.findOneById(reservationEntity);
		//int型
		assertEquals(reservationEntity.getReservationId(), kekka.getReservationId());
		//Timstamp型
		assertEquals(false, reservationEntity.getStartTime().equals(kekka.getStartTime()));
		assertEquals(true, reservationEntity.getEndTime().equals(kekka.getEndTime()));
		assertEquals(true, reservationEntity.getInsertDate().equals(kekka.getInsertDate()));
		assertEquals(false, reservationEntity.getUpdateDate().equals(kekka.getUpdateDate()));
	}

	/**
	 * insert
	 * 異常系
	 */
	@Test
	public void insertNo() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/reservation/setup_dataset_reservation.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		String starttime = "2021-04-05 09:00:00";
		String endtime = "2021-04-05 12:00:00";
		String datetime = "2021-04-01 12:00:00";
		int reservationId = 1;
		Timestamp startTime = Timestamp.valueOf(starttime);
		Timestamp endTime = null;
		FacilityEntity facilityEntity = null;

		Timestamp insertDate = Timestamp.valueOf(datetime);
		UserEntity insertUserEntity = null;
		Timestamp updateDate = Timestamp.valueOf(datetime);
		UserEntity updateUserEntity = null;

		ReservationEntity reservationEntity = new ReservationEntity(reservationId, startTime, endTime, facilityEntity,
				insertDate, insertUserEntity, updateDate, updateUserEntity);

		try {
			reservationRepository.insert(reservationEntity);
			fail("例外発生なし");
		} catch (Exception e) {
			assertThat(e, is(instanceOf(DataIntegrityViolationException.class)));
		}
	}

	/**
	 * update
	 * 正常系
	 */
	@Test
	public void updateOk() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/reservation/setup_dataset_reservation.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		String starttime = "2021-04-05 09:00:00";
		String endtime = "2021-04-05 12:00:00";
		String datetime = "2022-12-07 09:00:00";
		int reservationId = 2;
		Timestamp startTime = Timestamp.valueOf(starttime);
		Timestamp endTime = Timestamp.valueOf(endtime);
		FacilityEntity facilityEntity = null;

		Timestamp insertDate = Timestamp.valueOf(datetime);
		UserEntity insertUserEntity = null;
		Timestamp updateDate = Timestamp.valueOf(datetime);
		UserEntity updateUserEntity = null;

		ReservationEntity reservationEntity = new ReservationEntity(reservationId, startTime, endTime, facilityEntity,
				insertDate, insertUserEntity, updateDate, updateUserEntity);

		int result = reservationRepository.update(reservationEntity);

		assertEquals(1, result);
	}

	/**
	 * delete
	 * 正常系
	 */
	@Test
	public void deleteOk() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/reservation/setup_dataset_reservation.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		int result = reservationRepository.delete(1);

		assertEquals(1, result);
	}

	/**
	 * delete
	 * 異常系
	 */
	@Test
	public void deleteNg() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/util/setup_nodata.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		int result = reservationRepository.delete(1);

		assertEquals(0, result);
	}
	//一応作ったけどいらない↴
	/*	@Test
		public void testYear() {
			int result = reservationRepository.getYear();

			assertEquals(2023, result);
		}*/

	//何のためにこれ作った？
	/*	@Test
		public void updateNg() {
			try {
				PostgreDataManager.dataSet("./data/infra/repository/reservation/setup_dataset_reservation.xml",
						DatabaseOperation.CLEAN_INSERT);

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("データセット失敗");
				fail();
			}

			String starttime = "2021-04-05 09:00:00";
			String endtime = "2021-04-05 08:00:00";
			String datetime = "2022-12-07 09:00:00";
			int reservationId = 2;
			Timestamp startTime = Timestamp.valueOf(starttime);
			Timestamp endTime = Timestamp.valueOf(endtime);
			FacilityEntity facilityEntity = null;

			Timestamp insertDate = Timestamp.valueOf(datetime);
			UserEntity insertUserEntity = null;
			Timestamp updateDate = Timestamp.valueOf(datetime);
			UserEntity updateUserEntity = null;

			ReservationEntity reservationEntity = new ReservationEntity(reservationId, startTime, endTime, facilityEntity,
					insertDate, insertUserEntity, updateDate, updateUserEntity);

			try {
				reservationRepository.insert(reservationEntity);
				fail("例外発生なし");
			} catch (Exception e) {
				assertThat(e, is(instanceOf(DataIntegrityViolationException.class)));
			}
		}*/
}
