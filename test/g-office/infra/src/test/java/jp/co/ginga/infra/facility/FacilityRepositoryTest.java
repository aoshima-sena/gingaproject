package jp.co.ginga.infra.facility;

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
import jp.co.ginga.infra.repository.user.UserEntity;
import jp.co.ginga.infra.util.PostgreDataManager;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class FacilityRepositoryTest {
	@Autowired
	FacilityRepository facilityRepository;

	/**
	 * findAll
	 * 正常系
	 */
	@Test
	public void findAllMultiData() {
		//CLEAN_INSERTをやることによってDELETE_ALLとINSERTを同時に行ってくれる。
		//データセットで指定されたデータを消してデータの登録が行われる。
		try {
			PostgreDataManager.dataSet("./data/infra/repository/facility/setup_dataset_facility.xml",
					DatabaseOperation.CLEAN_INSERT);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		List<FacilityEntity> list = facilityRepository.findAll();

		assertEquals(list.size(), 3);

		for (int i = 0; i < list.size(); i++) {
			assertEquals((i + 1), list.get(i).getFacilityId());
			assertEquals("会議室" + (i + 1), list.get(i).getName());
			assertEquals((i + 1) * 10, list.get(i).getCapacity());
			assertEquals((i + 1), list.get(i).getFacilityTypeEntity().getFacilityTypeId());
			assertEquals("会議室" + (i + 1), list.get(i).getFacilityTypeEntity().getName());
		}
	}

	/**
	 * findAll
	 * データが１つだった場合
	 */
	@Test
	public void findAllSingleData() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/facility/setup_single_dataset_facility.xml",
					DatabaseOperation.CLEAN_INSERT);
			PostgreDataManager.dataSet("./data/infra/repository/facilityType/setup_single_dataset_facilityType.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		List<FacilityEntity> list = facilityRepository.findAll();

		assertEquals(list.size(), 1);
		assertEquals((1), list.get(0).getFacilityId());
		assertEquals("会議室" + (1), list.get(0).getName());
		assertEquals((1) * 10, list.get(0).getCapacity());
		assertEquals((1), list.get(0).getFacilityTypeEntity().getFacilityTypeId());

	}

	/**
	 * findAll
	 * データがない場合
	 */
	@Test
	public void findAllNoData() {

		try {
			PostgreDataManager.dataSet("./data/infra/repository/util/setup_nodata.xml", DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}
		List<FacilityEntity> list = facilityRepository.findAll();

		assertEquals(list.size(), 0);

	}

	//m2 UserRepositoryTestの114から
	/**
	 * findByFacilityId
	 * 正常系
	 */
	@Test
	public void findByFacilityIdTest() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/facility/setup_dataset_facility.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		FacilityEntity result = facilityRepository.findByFacilityId(1);

		assertEquals(1, result.getFacilityId());
	}

	/**
	 * findByFacilityId
	 * データがない場合
	 */
	@Test
	public void findFacilityIdNoData() {

		try {
			PostgreDataManager.dataSet("./data/infra/repository/util/setup_nodata.xml", DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}
		FacilityEntity result = facilityRepository.findByFacilityId(1);

		assertEquals(null, result);

	}

	//m4
	/**
	 * findByName
	 * 正常系
	 */
	@Test
	public void findByNameMultipleTest() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/facility/setup_dataset_facility.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}
		//list<>いらないかも
		List<FacilityEntity> list = facilityRepository.findByName("会議室1");

		assertEquals(1, list.size());
		assertEquals("会議室1", list.get(0).getName());

	}

	//M5
	/**
	 * findByName
	 * データがない場合
	 */
	@Test
	public void findByNameMultipleDataNoHit() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/util/setup_nodata.xml", DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		List<FacilityEntity> list = facilityRepository.findByName("会議室2");

		assertEquals(0, list.size());

	}

	/**
	 * insert
	 * 正常系
	 */
	@Test
	public void insertOk() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/facility/setup_dataset_facility.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		String datetime = "2022-11-10 11:11:11";

		int facilityId = 4;
		String name = "会議室1";
		int capacity = 10;
		FacilityTypeEntity facilityTypeEntity = null;
		Timestamp insertDate = Timestamp.valueOf(datetime);
		Timestamp updateDate = Timestamp.valueOf(datetime);
		UserEntity insertUserEntity = null;

		UserEntity updateUserEntity = null;

		FacilityEntity entity = new FacilityEntity(facilityId, name, capacity, facilityTypeEntity, insertDate,
				insertUserEntity, updateDate, updateUserEntity);

		int result = facilityRepository.insert(entity);
		//result = facilityRepository.insert(entity);
		//検証結果
		assertEquals(1, result);

		FacilityEntity result1 = facilityRepository.findByFacilityId(4);

		assertEquals(entity.getFacilityId(), result1.getFacilityId());
		assertEquals(true, entity.getName().equals(result1.getName()));
		assertEquals(entity.getCapacity(), result1.getCapacity());
		assertEquals(false, entity.getInsertDate().equals(result1.getInsertDate()));
		//	assertEquals(true,entity.getFacilityTypeEntity(),result1.getFacilityTypeEntity());

	}

	//登録処理 重複あり
	//主キーの重複はありえないから
	/*	@Test
		public void insertNo() {
			try {
				PostgreDataManager.dataSet("./data/infra/repository/facilityType/setup_dataset_facilityType.xml",
						DatabaseOperation.CLEAN_INSERT);

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("データセット失敗");
				fail();
			}

			String datetime = "2022-11-10 11:11:11";

			int facilityId = 1;
			String name = "会議室1";
			int capacity = 10;
			FacilityTypeEntity facilityTypeEntity = null;
			Timestamp insertDate = Timestamp.valueOf(datetime);
			Timestamp updateDate = Timestamp.valueOf(datetime);
			UserEntity insertUserEntity = null;

			UserEntity updateUserEntity = null;

			FacilityEntity entity = new FacilityEntity(facilityId, name, capacity, facilityTypeEntity, updateDate,
					insertUserEntity, insertDate, updateUserEntity);

			try {
				facilityRepository.insert(entity);
				fail("例外発生なし");
			} catch (Exception e) {
				assertThat(e, is(instanceOf(DataIntegrityViolationException.class)));
			}

		}*/
	/**
	 * insert
	 * 異常系
	 */
	@Test
	public void insertNg() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/facilityType/setup_dataset_facilityType.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		String datetime = "2022-11-10 11:11:11";

		int facilityId = 1;
		String name = "会議室12345678901234567890";
		int capacity = 10;
		FacilityTypeEntity facilityTypeEntity = null;
		Timestamp insertDate = Timestamp.valueOf(datetime);
		Timestamp updateDate = Timestamp.valueOf(datetime);
		UserEntity insertUserEntity = null;

		UserEntity updateUserEntity = null;

		FacilityEntity entity = new FacilityEntity(facilityId, name, capacity, facilityTypeEntity, updateDate,
				insertUserEntity, insertDate, updateUserEntity);

		try {
			facilityRepository.insert(entity);
			fail("例外発生なし");
		} catch (Exception e) {
			assertThat(e, is(instanceOf(DataIntegrityViolationException.class)));
		}

	}

	//m6
	/**
	 * update
	 * 正常系
	 */
	@Test
	public void updateOK() {

		try {
			PostgreDataManager.dataSet("./data/infra/repository/facility/setup_dataset_facility.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		String datetime = "2022-11-10 11:11:11";

		int facilityId = 1;
		String name = "会議室2";
		int capacity = 30;
		FacilityTypeEntity facilityTypeEntity = null;
		Timestamp insertDate = Timestamp.valueOf(datetime);
		Timestamp updateDate = Timestamp.valueOf(datetime);
		UserEntity insertUserEntity = null;

		UserEntity updateUserEntity = null;

		FacilityEntity faEntity = new FacilityEntity(facilityId, name, capacity, facilityTypeEntity, insertDate,
				insertUserEntity, updateDate, updateUserEntity);

		int result = facilityRepository.update(faEntity);
		//検証処理
		assertEquals(1, result);
	}

	/**
	 * 	update
	 * 文字数が多いとき
	 */
	@Test
	public void updateNo() {

		try {
			PostgreDataManager.dataSet("./data/infra/repository/facility/setup_dataset_facility.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		String datetime = "2022-11-10 11:11:11";

		int facilityId = 1;
		String name = "会議室123456789012345678901234567890";
		int capacity = 10;
		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity();
		facilityTypeEntity.setFacilityTypeId(1);
		Timestamp insertDate = Timestamp.valueOf(datetime);
		Timestamp updateDate = Timestamp.valueOf(datetime);
		UserEntity insertUserEntity = null;

		UserEntity updateUserEntity = null;

		FacilityEntity faEntity = new FacilityEntity(facilityId, name, capacity, facilityTypeEntity, insertDate,
				insertUserEntity, updateDate, updateUserEntity);

		try {
			facilityRepository.insert(faEntity);
			fail("例外発生なし");
		} catch (Exception e) {
			assertThat(e, is(instanceOf(DataIntegrityViolationException.class)));
		}
	}

	/**
	 * delete
	 * 正常系
	 */
	@Test
	public void deleteOk() {

		try {
			PostgreDataManager.dataSet("./data/infra/repository/facility/setup_dataset_facility.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		int facility = 1;

		int result = facilityRepository.delete(facility);

		assertEquals(1, result);

	}

	/**
	 * delete
	 * 異常系
	 */
	@Test
	public void deleteNg() {

		try {
			PostgreDataManager.dataSet("./data/infra/repository/util/setup_nodata.xml", DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		int facilityId = 1;

		int result = facilityRepository.delete(facilityId);

		assertEquals(0, result);

	}

}
