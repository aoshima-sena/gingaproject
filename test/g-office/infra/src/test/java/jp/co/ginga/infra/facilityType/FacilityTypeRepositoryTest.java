package jp.co.ginga.infra.facilityType;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.List;

import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeRepository;
import jp.co.ginga.infra.repository.user.UserEntity;
import jp.co.ginga.infra.util.PostgreDataManager;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class FacilityTypeRepositoryTest {

	@Autowired
	FacilityTypeRepository facilityTypeRepository;

	//FacilityTypeRepositoryのfindAll(全件取得)を実行
	@Test
	public void findAllMultiData() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/facilityType/setup_dataset_facilityType.xml",
					DatabaseOperation.CLEAN_INSERT);
			// CLEAN_INSERTでpgadminに登録しているデータを削除して再セットする
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		List<FacilityTypeEntity> list = facilityTypeRepository.findAll();

		assertEquals(list.size(), 3);

		for (int i = 0; i < list.size(); i++) {
			assertEquals("会議室" + (i + 1), list.get(i).getName());
			assertEquals((i + 1), list.get(i).getFacilityTypeId());
		}
	}

	//FacilityTypeRepositoryのfindAll(全件取得)でデータ一つ取得を実行
	@Test
	public void findallSingleData() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/facilityType/setup_single_dataset_facilityType.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		List<FacilityTypeEntity> list = facilityTypeRepository.findAll();
		assertEquals(list.size(), 1);
		assertEquals("会議室", list.get(0).getName());
		assertEquals(1, list.get(0).getFacilityTypeId());
	}

	//findAll0件の場合
	@Test
	public void findAllNoData() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/util/setup_nodata.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}
		//強制的にfail()になる
		List<FacilityTypeEntity> list = facilityTypeRepository.findAll();

		assertEquals(list.size(), 0);
	}

	//facilityTypeId施設種別ID検索処理
	@Test
	public void findOneByIdTest() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/facilityType/setup_single_dataset_facilityType.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}
		FacilityTypeEntity facilityTypeEntity = facilityTypeRepository.findOneById(1);

		assertEquals(1, facilityTypeEntity.getFacilityTypeId());
		assertEquals("会議室", facilityTypeEntity.getName());
	}

	//facilityTypeId施設種別ID検索処理 0件の場合
	@Test
	public void findOneByIdNoDataTest() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/util/setup_nodata.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		FacilityTypeEntity result = facilityTypeRepository.findOneById(1);

		assertEquals(null, result);
	}

	//施設種別名検索処理
	@Test
	public void findByTypeNameTest() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/facilityType/setup_single_dataset_facilityType.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		List<FacilityTypeEntity> list = facilityTypeRepository.findByTypeName("会議室");

		assertEquals(list.size(), 1);

		assertEquals("会議室", list.get(0).getName());
		assertEquals(1, list.get(0).getFacilityTypeId());

	}

	//施設種別名検索処理 0件の場合
	@Test
	public void findByTypeNameNoDataTest() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/util/setup_nodata.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}
		List<FacilityTypeEntity> list = facilityTypeRepository.findByTypeName("会議室");

		assertEquals(0, list.size());
	}

	//登録処理 重複なし
	@Test
	public void insertTest() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/facilityType/setup_dataset_facilityType.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		String datetime = "2022-12-07";

		int facilityTypeId = 4;
		String name = "会議室4";
		Date insertDate = Date.valueOf(datetime);
		UserEntity insertUserEntity = null;
		Date updateDate = Date.valueOf(datetime);
		UserEntity updateUserEntity = null;
		Date deleteDate = Date.valueOf(datetime);
		UserEntity deleteUserEntity = null;
		boolean fgDelete = true;

		FacilityTypeEntity entity = new FacilityTypeEntity(facilityTypeId, name, insertDate, insertUserEntity,
				updateDate, deleteUserEntity, deleteDate, updateUserEntity, fgDelete);

		int result = facilityTypeRepository.insert(entity);

		assertEquals(1, result);

		FacilityTypeEntity result1 = facilityTypeRepository.findOneById(4);

		//int型
		assertEquals(entity.getFacilityTypeId(), result1.getFacilityTypeId());
		//String型(左に入れたい値"会議室"、右に入れられるsetupの値)
		assertEquals(true, entity.getName().equals(result1.getName()));
		//Date型
		assertEquals(false, entity.getInsertDate().equals(result1.getInsertDate()));
		//insertUserEntityに何もはいってないからね。やりたければ暇な時にやって
		assertNull(entity.getInsertUserEntity());
	}

	//登録処理 重複あり

	@Test
	public void insertNo() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/facilityType/setup_dataset_facilityType.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		String datetime = "2022-12-07";

		int facilityTypeId = 1;
		String name = "会議室2";
		Date insertDate = Date.valueOf(datetime);
		UserEntity insertUserEntity = null;
		Date updateDate = Date.valueOf(datetime);
		UserEntity updateUserEntity = null;
		Date deleteDate = Date.valueOf(datetime);
		UserEntity deleteUserEntity = null;
		boolean fgDelete = true;

		FacilityTypeEntity entity = new FacilityTypeEntity(facilityTypeId, name, insertDate, insertUserEntity,
				updateDate, updateUserEntity, deleteDate, deleteUserEntity, fgDelete);

		try {
			facilityTypeRepository.insert(entity);
			fail("例外発生なし");
		} catch (Exception e) {
			assertThat(e, is(instanceOf(DataIntegrityViolationException.class)));
		}

	}

	//登録処理 種別名20文字以上の場合
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

		String datetime = "2022-12-07";

		int facilityTypeId = 4;
		String name = "会議室12345678901234567890";
		Date insertDate = Date.valueOf(datetime);
		UserEntity insertUserEntity = null;
		Date updateDate = Date.valueOf(datetime);
		UserEntity updateUserEntity = null;
		Date deleteDate = Date.valueOf(datetime);
		UserEntity deleteUserEntity = null;
		boolean fgDelete = true;

		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(facilityTypeId, name, insertDate,
				insertUserEntity, updateDate, updateUserEntity, deleteDate, deleteUserEntity, fgDelete);

		try {
			facilityTypeRepository.insert(facilityTypeEntity);
			fail("例外発生なし");
		} catch (Exception e) {
			assertThat(e, is(instanceOf(DataIntegrityViolationException.class)));
		}
	}

	//更新処理

	@Test
	public void updateOk() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/facilityType/setup_dataset_facilityType.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}
		String datetime = "2022-12-07";

		int facilityTypeId = 1;
		String name = "会議室4";
		Date insertDate = Date.valueOf(datetime);
		UserEntity insertUserEntity = null;
		Date updateDate = Date.valueOf(datetime);
		UserEntity updateUserEntity = null;
		Date deleteDate = Date.valueOf(datetime);
		UserEntity deleteUserEntity = null;
		boolean fgDelete = true;

		FacilityTypeEntity entity = new FacilityTypeEntity(facilityTypeId, name, insertDate, insertUserEntity,
				updateDate, updateUserEntity, deleteDate, deleteUserEntity, fgDelete);

		int result = facilityTypeRepository.update(entity);

		assertEquals(1, result);
	}

	//種別名20文字以上の場合
	@Test
	public void updateNo() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/facilityType/setup_dataset_facilityType.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		String datetime = "2022-12-07";

		int facilityTypeId = 1;
		String name = "会議室12345678901234567890";
		Date insertDate = Date.valueOf(datetime);
		UserEntity insertUserEntity = null;
		Date updateDate = Date.valueOf(datetime);
		UserEntity updateUserEntity = null;
		Date deleteDate = Date.valueOf(datetime);
		UserEntity deleteUserEntity = null;
		boolean fgDelete = true;

		FacilityTypeEntity entity = new FacilityTypeEntity(facilityTypeId, name, insertDate, insertUserEntity,
				updateDate, updateUserEntity, deleteDate, deleteUserEntity, fgDelete);

		try {
			facilityTypeRepository.update(entity);
			fail("例外発生なし");
		} catch (Exception e) {
			assertThat(e, is(instanceOf(DataIntegrityViolationException.class)));
		}
	}

	@Test
	public void deleteOk() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/facilityType/setup_dataset_facilityType.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		int result = facilityTypeRepository.delete(1);

		assertEquals(1, result);
	}

	//削除データなし
	@Test
	public void deleteNoData() {
		try {
			PostgreDataManager.dataSet("./data/infra/repository/util/setup_nodata.xml",
					DatabaseOperation.CLEAN_INSERT);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データセット失敗");
			fail();
		}

		int result = facilityTypeRepository.delete(1);

		assertEquals(0, result);
	}

	/**
		//削除フラグ検索処理
		 * そもそも削除フラグを使用してない

		@Test
		public void findByFgDeleteTest() {
			try {
				PostgreDataManager.dataSet("./data/infra/repository/facilityType/setup_dataset_facilityType.xml",
						DatabaseOperation.CLEAN_INSERT);

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("データセット失敗");
				fail();
			}

			List<FacilityTypeEntity> list = facilityTypeRepository.findByFgDelete(0);

			assertEquals(list.size(), 3);
			assertEquals(0, list.get(0).isFgDelete());
		}

		**/

}
