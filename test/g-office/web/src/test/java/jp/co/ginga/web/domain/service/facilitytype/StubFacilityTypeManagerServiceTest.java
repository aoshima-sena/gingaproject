package jp.co.ginga.web.domain.service.facilitytype;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jp.co.ginga.infra.repository.facility.FacilityEntity;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeRepository;
import jp.co.ginga.infra.repository.user.UserEntity;
import jp.co.ginga.web.domain.service.stub.StubFacilityTypeRepository;
import jp.co.ginga.web.domain.service.util.constant.ServiceConst;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StubFacilityTypeManagerServiceTest {

	@Autowired
	FacilityTypeManagerService service;

	private int ft_facility_type_id = 1;
	private String ft_name = "会議室";
	private Date ft_insert_date = null;
	private UserEntity ft_user_id = null;
	private Date ft_update_date = null;
	private UserEntity ft_update_user_id = null;
	private Date ft_delete_date = null;
	private UserEntity ft_delete_user_id = null;
	private boolean ft_fgDelete = true;
	private int f_facility_id = 1;
	private String f_name = "会議室";
	private int f_capacity = 10;
	private FacilityTypeEntity f_facility_type_id = null;
	private Timestamp f_insert_date = null;
	private UserEntity f_user_id = null;
	private Timestamp f_update_date = null;
	private UserEntity f_update_user_id = null;

	//findAll リストあり
	@Test
	public void testGetFacilityTypeList_normal_001() {
		System.out.println("testGetFacilityTypeList_normal_001");

		FacilityTypeRepository facilityTypeRepository = new StubFacilityTypeRepository() {
			//スタブの要素を書き換え
			@Override
			public List<FacilityTypeEntity> findAll() {
				List<FacilityTypeEntity> facilityTypeEntityList = new ArrayList<FacilityTypeEntity>();
				FacilityTypeEntity entity = new FacilityTypeEntity(ft_facility_type_id, ft_name, ft_insert_date,
						ft_user_id, ft_update_date, ft_update_user_id, ft_delete_date, ft_delete_user_id, ft_fgDelete);
				facilityTypeEntityList.add(entity);

				return facilityTypeEntityList;

			}
		};

		service.setFacilityTypeRepository(facilityTypeRepository);
		//FacilityTypeManagerDtoをインポートする必要がなさそう
		FacilityTypeManagerDto result = service.getFacilityTypeList();

		assertEquals(1, result.getFacilityTypeDtoList().size());
		assertEquals(ft_facility_type_id, result.getFacilityTypeDtoList().get(0).getFacilityTypeId());
		assertEquals(ft_name, result.getFacilityTypeDtoList().get(0).getName());
		assertEquals(ft_insert_date, result.getFacilityTypeDtoList().get(0).getInsertDate());
		assertEquals(ft_user_id, result.getFacilityTypeDtoList().get(0).getInsertUserDto());
		assertEquals(ft_update_date, result.getFacilityTypeDtoList().get(0).getInsertDate());
		assertEquals(ft_delete_user_id, result.getFacilityTypeDtoList().get(0).getInsertUserDto());
		assertEquals(ft_delete_date, result.getFacilityTypeDtoList().get(0).getInsertDate());
	}

	//データなしb

	@Test
	public void test_NoGetFacilityTypelist_normal_002() {

		System.out.println("test_NoGetFacilityTypeList_normal_002");

		FacilityTypeRepository facilityTypeRepository = new StubFacilityTypeRepository() {

			@Override
			public List<FacilityTypeEntity> findAll() {
				List<FacilityTypeEntity> list = new ArrayList<FacilityTypeEntity>();

				return list;

			}
		};

		service.setFacilityTypeRepository(facilityTypeRepository);

		FacilityTypeManagerDto result = service.getFacilityTypeList();

		assertEquals(0, result.getFacilityTypeDtoList().size());
	}

	//getFacilityTypeDetailByFacilityTypeId データあり

	@Test
	public void testGetFacilityTypeId_normal_001() {
		System.out.println("testGetFacilityTypeId_normal_001");

		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity();
		facilityTypeEntity.setFacilityTypeId(ft_facility_type_id);
		facilityTypeEntity.setName(ft_name);
		FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity, facilityTypeEntity,
				f_insert_date, f_update_user_id, f_insert_date, f_update_user_id);

		FacilityTypeRepository facilityTypeRepository = new StubFacilityTypeRepository() {

			@Override
			public List<FacilityTypeEntity> findAll() {
				List<FacilityTypeEntity> facilityTypeEntityList = new ArrayList<FacilityTypeEntity>();
				FacilityTypeEntity entity = new FacilityTypeEntity(ft_facility_type_id, ft_name, ft_insert_date,
						ft_user_id, ft_update_date, ft_update_user_id, ft_delete_date, ft_delete_user_id, ft_fgDelete);
				facilityTypeEntityList.add(entity);

				return facilityTypeEntityList;

			}

			@Override
			public FacilityTypeEntity findOneById(int facilityTypeId) {
				//		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(ft_facility_type_id, ft_name,
				//				ft_insert_date,
				//				ft_user_id, ft_update_date, ft_update_user_id, ft_delete_date, ft_delete_user_id, ft_fgDelete);
				return facilityTypeEntity;
			}

		};

		//	FacilityRepository facilityRepository = new StubFacilityRepository() {

		//		@Override
		//		public List<FacilityEntity> findAll() {
		//			List<FacilityEntity> EntityList = new ArrayList<FacilityEntity>();
		//		FacilityEntity entity = new FacilityEntity(f_facility_id, f_name, facilityTypeId, f_facility_type_id,
		//				f_insert_date, f_update_user_id, f_insert_date, f_update_user_id);
		//			EntityList.add(facilityEntity);
		//			return EntityList;
		//		}
		//	};
		//	service.setFacilityRepository(facilityRepository);

		service.setFacilityTypeRepository(facilityTypeRepository);

		FacilityTypeManagerDto result = service.getFacilityTypeDetailByFacilityTypeId(ft_facility_type_id);

		assertEquals(ft_facility_type_id, result.getFacilityTypeDto().getFacilityTypeId());
		assertEquals(ft_name, result.getFacilityTypeDto().getName());

	}

	@Test
	public void testNoGetFacilityTypeId_normal_2() {
		System.out.println("testNoGetFacilityTypeId_normal_2");

		FacilityTypeRepository facilityTypeRepository = new StubFacilityTypeRepository() {

			@Override
			public FacilityTypeEntity findOneById(int facilityTypeId) {
				FacilityTypeEntity entity = new FacilityTypeEntity();
				return entity;
			}
		};

		service.setFacilityTypeRepository(facilityTypeRepository);

		FacilityTypeManagerDto result = service.getFacilityTypeDetailByFacilityTypeId(ft_facility_type_id);

		assertNull(result.getFacilityTypeDto().getFacilityTypeId());
		assertNull(result.getFacilityTypeDto().getName());

	}

	//種別名検索処理 データあり
	@Test
	public void testGetName_normal_001() {
		System.out.println("testGetName_normal_001");

		FacilityTypeRepository facilityTypeRepository = new StubFacilityTypeRepository() {

			@Override
			public List<FacilityTypeEntity> findByTypeName(String name) {
				List<FacilityTypeEntity> list = new ArrayList<FacilityTypeEntity>();
				FacilityTypeEntity entity = new FacilityTypeEntity(ft_facility_type_id, ft_name, ft_insert_date,
						ft_user_id, ft_update_date, ft_update_user_id, ft_delete_date, ft_delete_user_id, ft_fgDelete);
				list.add(entity);
				return list;
			}

		};

		service.setFacilityTypeRepository(facilityTypeRepository);

		FacilityTypeManagerDto result = service.getFacilityTypeByName(ft_name);

		assertEquals(ServiceConst.THERE_IS_DATA, result.getResult());
		assertEquals(ft_name, result.getFacilityTypeDtoList().get(0).getName());
	}

	//種別名検索処理 データなし
	@Test
	public void testNoGetName_normal_002() {
		System.out.println("testNoGetName_normal_002");

		FacilityTypeRepository facilityTypeRepository = new StubFacilityTypeRepository() {

			@Override
			public List<FacilityTypeEntity> findByTypeName(String name) {
				List<FacilityTypeEntity> list = new ArrayList<FacilityTypeEntity>();
				return list;

			}

		};

		service.setFacilityTypeRepository(facilityTypeRepository);

		FacilityTypeManagerDto result = service.getFacilityTypeByName(ft_name);

		assertEquals(ServiceConst.NO_DATA, result.getResult());
		assertEquals(0, result.getFacilityTypeDtoList().size());
	}

	//add データあり
	@Test
	public void testAdd_normal_001() {
		System.out.println("testAdd_normal_001");

		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(ft_facility_type_id, ft_name, ft_insert_date,
				ft_user_id, ft_update_date, ft_update_user_id, ft_delete_date, ft_delete_user_id, ft_fgDelete);
		FacilityTypeManagerDto facilityTypeManagerDto = new FacilityTypeManagerDto();

		facilityTypeManagerDto.setFacilityTypeDto(new FacilityTypeDto(ft_facility_type_id, f_name));
		facilityTypeManagerDto.setOptimisticRockValue(facilityTypeEntity.toString());

		FacilityTypeRepository facilityTypeRepository = new StubFacilityTypeRepository() {

			@Override
			public int insert(FacilityTypeEntity facilityTypeEntity) {
				return 1;
			}
		};

		service.setFacilityTypeRepository(facilityTypeRepository);

		FacilityTypeManagerDto result = service.add(facilityTypeManagerDto);

		assertEquals(ServiceConst.THERE_IS_DATA, result.getResult());

	}

	@Test
	public void testAdd_abnormal_001() {
		System.out.println("testAdd_abnormal_001");

		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(ft_facility_type_id, ft_name, ft_insert_date,
				ft_user_id, ft_update_date, ft_update_user_id, ft_delete_date, ft_delete_user_id, ft_fgDelete);
		FacilityTypeManagerDto facilityTypeManagerDto = new FacilityTypeManagerDto();

		facilityTypeManagerDto.setFacilityTypeDto(new FacilityTypeDto(ft_facility_type_id, ft_name));
		facilityTypeManagerDto.setOptimisticRockValue(facilityTypeEntity.toString());

		FacilityTypeRepository facilityTypeRepository = new StubFacilityTypeRepository() {

			@Override
			public int insert(FacilityTypeEntity facilityTypeEntity) {
				return 2;
			}
		};

		service.setFacilityTypeRepository(facilityTypeRepository);

		FacilityTypeManagerDto result = service.add(facilityTypeManagerDto);

		assertEquals(ServiceConst.NO_DATA, result.getResult());
	}

	@Test
	public void testUpdate_normal_001() {
		System.out.println("testUpdate_normal_001");

		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(ft_facility_type_id, ft_name, ft_insert_date,
				ft_user_id, ft_update_date, ft_update_user_id, ft_delete_date, ft_delete_user_id, ft_fgDelete);
		FacilityTypeManagerDto facilityTypeManagerDto = new FacilityTypeManagerDto();

		facilityTypeManagerDto.setFacilityTypeDto(new FacilityTypeDto(ft_facility_type_id, ft_name));
		facilityTypeManagerDto.setOptimisticRockValue(facilityTypeEntity.toString());

		FacilityTypeRepository facilityTypeRepository = new StubFacilityTypeRepository() {

			@Override
			public int update(FacilityTypeEntity facilityTypeEntity) {
				return 1;
			}

			//FacilityTypeIdが一致するときはupdateする条件があるから
			@Override
			public FacilityTypeEntity findOneById(int facilityTypeId) {
				return facilityTypeEntity;
			}
		};

		service.setFacilityTypeRepository(facilityTypeRepository);

		FacilityTypeManagerDto result = service.update(facilityTypeManagerDto);

		assertEquals(ServiceConst.OK, result.getResult());
	}

	@Test
	public void testUpdate_abnormal_001() {
		System.out.println("testUpdate_abnormal_001");

		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(ft_facility_type_id, ft_name, ft_insert_date,
				ft_user_id, ft_update_date, ft_update_user_id, ft_delete_date, ft_delete_user_id, ft_fgDelete);

		FacilityTypeManagerDto facilityTypeManagerDto = new FacilityTypeManagerDto();

		facilityTypeManagerDto.setFacilityTypeDto(new FacilityTypeDto(ft_facility_type_id, ft_name));
		facilityTypeManagerDto.setOptimisticRockValue(facilityTypeEntity.toString());

		FacilityTypeRepository facilityTypeRepository = new StubFacilityTypeRepository() {

			public int update(FacilityTypeEntity facilityTypeEntity) {
				return 1;
			}

			//FacilityTypeIdが一致するときはupdateする条件があるから
			@Override
			public FacilityTypeEntity findOneById(int facilityTypeId) {
				FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(ft_facility_type_id, ft_name,
						ft_insert_date, ft_user_id, ft_update_date, ft_update_user_id, ft_delete_date,
						ft_delete_user_id, ft_fgDelete);

				return facilityTypeEntity;
			}

		};

		service.setFacilityTypeRepository(facilityTypeRepository);

		FacilityTypeManagerDto result = service.update(facilityTypeManagerDto);

		assertEquals(ServiceConst.OK, result.getResult());

	}

	//楽観的ロック

	@Test
	public void testUpdate_normal_002() {
		System.out.println("testUpdate_normal_002");

		//	FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(ft_facility_type_id, ft_name, ft_insert_date,
		//			ft_user_id, ft_update_date, ft_update_user_id, ft_delete_date, ft_delete_user_id, ft_fgDelete);

		FacilityTypeManagerDto facilityTypeManagerDto = new FacilityTypeManagerDto();

		facilityTypeManagerDto.setFacilityTypeDto(new FacilityTypeDto(ft_facility_type_id, f_name));

		FacilityTypeRepository facilityTypeRepository = new StubFacilityTypeRepository() {

			@Override
			public FacilityTypeEntity findOneById(int facilityTypeId) {
				FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(ft_facility_type_id, ft_name,
						ft_insert_date, ft_user_id, ft_update_date, ft_update_user_id, ft_delete_date,
						ft_delete_user_id, ft_fgDelete);

				return facilityTypeEntity;
			}
		};
		service.setFacilityTypeRepository(facilityTypeRepository);

		FacilityTypeManagerDto result = service.update(facilityTypeManagerDto);

		assertEquals(ServiceConst.OPTIMISTIC_ROCK_ERROR, result.getResult());
	}

	@Test
	public void testNoDataUpdate_abnormal_001() {
		System.out.println("testNoDataUpdate_abmormal_001");

		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(ft_facility_type_id, ft_name, ft_insert_date,
				ft_user_id, ft_update_date, ft_update_user_id, ft_delete_date, ft_delete_user_id, ft_fgDelete);
		FacilityTypeManagerDto facilityTypeManagerDto = new FacilityTypeManagerDto();

		facilityTypeManagerDto.setFacilityTypeDto(new FacilityTypeDto(ft_facility_type_id, ft_name));
		facilityTypeManagerDto.setOptimisticRockValue(facilityTypeEntity.toString());

		FacilityTypeRepository facilityTypeRepository = new StubFacilityTypeRepository() {

			@Override
			public FacilityTypeEntity findOneById(int facilityTypeId) {
				FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(ft_facility_type_id, ft_name,
						ft_insert_date, ft_user_id, ft_update_date, ft_update_user_id, ft_delete_date,
						ft_delete_user_id, ft_fgDelete);

				return facilityTypeEntity;
			}
		};

		service.setFacilityTypeRepository(facilityTypeRepository);
		FacilityTypeManagerDto result = service.update(facilityTypeManagerDto);

		assertEquals(ServiceConst.ERROR, result.getResult());

	}

	@Test
	public void testDeleteOK_normal_001() {
		System.out.println("testDeleteOk_normal_001");

		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(ft_facility_type_id, ft_name, ft_insert_date,
				ft_user_id, ft_update_date, ft_update_user_id, ft_delete_date, ft_delete_user_id, ft_fgDelete);

		FacilityTypeManagerDto facilityTypeManagerDto = new FacilityTypeManagerDto();
		facilityTypeManagerDto.setFacilityTypeDto(new FacilityTypeDto(ft_facility_type_id, ft_name));
		facilityTypeManagerDto.setOptimisticRockValue(facilityTypeEntity.toString());

		FacilityTypeRepository facilityTypeRepository = new StubFacilityTypeRepository() {

			@Override
			public int delete(int facilityTypeId) {
				return 1;
			}
		};
		service.setFacilityTypeRepository(facilityTypeRepository);

		FacilityTypeManagerDto result = service.delete(facilityTypeManagerDto);

		assertEquals(ServiceConst.OK, result.getResult());

	}

	@Test
	public void testDeleteNo_normal_001() {
		System.out.println("testDeleteOk_normal_001");

		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(ft_facility_type_id, ft_name, ft_insert_date,
				ft_user_id, ft_update_date, ft_update_user_id, ft_delete_date, ft_delete_user_id, ft_fgDelete);

		FacilityTypeManagerDto facilityTypeManagerDto = new FacilityTypeManagerDto();
		facilityTypeManagerDto.setFacilityTypeDto(new FacilityTypeDto(ft_facility_type_id, ft_name));
		facilityTypeManagerDto.setOptimisticRockValue(facilityTypeEntity.toString());

		FacilityTypeRepository facilityTypeRepository = new StubFacilityTypeRepository() {

			@Override
			public int delete(int facilityTypeId) {
				return 0;
			}
		};
		service.setFacilityTypeRepository(facilityTypeRepository);

		FacilityTypeManagerDto result = service.delete(facilityTypeManagerDto);

		assertEquals(ServiceConst.ERROR, result.getResult());

	}
}
