package jp.co.ginga.web.domain.service.facility;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jp.co.ginga.infra.repository.facility.FacilityEntity;
import jp.co.ginga.infra.repository.facility.FacilityRepository;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeRepository;
import jp.co.ginga.infra.repository.user.UserEntity;
import jp.co.ginga.web.domain.service.stub.StubFacilityRepository;
import jp.co.ginga.web.domain.service.stub.StubFacilityTypeRepository;
import jp.co.ginga.web.domain.service.user.UserManagerDto;
import jp.co.ginga.web.domain.service.util.constant.ServiceConst;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;
import jp.co.ginga.web.domain.service.util.dto.userrole.UserRoleDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StubFacilityManagerServiceTest {

	@Autowired
	FacilityManagerService service;

	private int f_facility_id = 1;
	private String f_name = "会議室";
	private int f_capacity = 10;
	private FacilityTypeEntity f_facility_type_id = null;
	private Timestamp f_insert_date = null;
	private UserEntity f_user_id = null;
	private Timestamp f_update_date = null;
	private UserEntity f_update_user_id = null;
	private int ft_facility_type_id = 1;
	private String ft_name = "会議室";
	private Date ft_insert_date = null;
	private UserEntity ft_user_id = null;
	private Date ft_update_date = null;
	private UserEntity ft_update_user_id = null;
	private Date ft_delete_date = null;
	private UserEntity ft_delete_user_id = null;
	private boolean ft_fg_delete = true;
	private String ft_to_string = null;
	private String u_userId = "test";
	private String u_userName = "テストユーザー";
	private String u_password = "pass1";
	private Timestamp u_passUpdateDate = null;
	private String u_gender = "男";
	private String u_birthday = "2021-04-01";
	private String u_contact = "090-1234-5678";
	private String u_mailAddress = "test@xxx.co.jp";
	private int u_loginMissTimes = 0;
	private boolean u_unlock = true;
	private boolean u_enabled = true;
	private Timestamp u_userDueDate = null;
	private Timestamp u_insertDate = null;
	private Timestamp u_updateDate = null;
	private String ur_roleId1 = "tests2";

	private String ur_roleId;

	//サービスのクラス自体に問題がないかを検証するのがスタブ
	//ほかのクラスは無視
	//受信のテスト(オブジェクトがメッセージを受け取った時適切な値が返されるか)
	/**
	 *正常系
	 */
	@Test
	public void testGetFacilityList_normal_001() {
		System.out.println("testGetFacilityList_normal_001");

		FacilityRepository facilityRepository = new StubFacilityRepository() {

			@Override
			public List<FacilityEntity> findAll() {

				FacilityTypeEntity type = new FacilityTypeEntity();
				type.setFacilityTypeId(ft_facility_type_id);
				type.setName(ft_name);

				List<FacilityEntity> facilityEntityList = new ArrayList<FacilityEntity>();
				FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity,
						type, f_insert_date, f_user_id, f_update_date, f_update_user_id);
				facilityEntityList.add(facilityEntity);

				return facilityEntityList;
			}

		};

		service.setFacilityRepository(facilityRepository);

		FacilityManagerDto result = service.getFacilityList();

		assertEquals(1, result.getFacilityDtoList().size());
		assertEquals(f_facility_id, result.getFacilityDtoList().get(0).getFacilityId());
		assertEquals(f_name, result.getFacilityDtoList().get(0).getName());
		assertEquals(f_capacity, result.getFacilityDtoList().get(0).getCapacity());
		assertEquals(ft_facility_type_id, result.getFacilityDtoList().get(0).getFacilityTypeDto().getFacilityTypeId());
		assertEquals(ft_name, result.getFacilityDtoList().get(0).getFacilityTypeDto().getName());

	}

	/**
	 * 異常系
	 * データがない場合
	 */
	@Test
	public void testGetFacilityList_normal_002() {
		System.out.println("testGetFacilityList_normal_002");

		FacilityRepository facilityRepository = new StubFacilityRepository() {
			@Override
			public List<FacilityEntity> findAll() {
				List<FacilityEntity> facilityEntityList = new ArrayList<FacilityEntity>();

				return facilityEntityList;
			}
		};

		service.setFacilityRepository(facilityRepository);

		FacilityManagerDto result = service.getFacilityList();

		assertEquals(0, result.getFacilityDtoList().size());

	}

	/**
	 * findByfacilityId
	 * 正常系
	 */
	//m2
	@Test
	public void testGetFacilityDetailByFacilityId_normal_001() {

		System.out.println("testGetFacilityDetailByFacilityId_normal_001");
		//TEST DATA
		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity();
		facilityTypeEntity.setFacilityTypeId(ft_facility_type_id);
		facilityTypeEntity.setName(ft_name);

		FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity,
				facilityTypeEntity,
				f_insert_date, f_user_id, f_update_date, f_update_user_id);
		FacilityRepository facilityRepository = new StubFacilityRepository() {

			@Override
			public FacilityEntity findByFacilityId(int facilityId) {

				return facilityEntity;
			}

		};
		service.setFacilityRepository(facilityRepository);

		FacilityTypeRepository facilityTypeRepository = new StubFacilityTypeRepository() {
			@Override
			public List<FacilityTypeEntity> findAll() {
				List<FacilityTypeEntity> facilityTypeEntityList = new ArrayList<FacilityTypeEntity>();
				//TEST DATA
				FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity();
				facilityTypeEntity.setFacilityTypeId(ft_facility_type_id);
				facilityTypeEntity.setName(ft_name);

				facilityTypeEntityList.add(facilityTypeEntity);
				return facilityTypeEntityList;
			}
		};
		service.setFacilityTypeRepository(facilityTypeRepository);

		FacilityManagerDto result = service.getFacilityDetailByFacilityId(f_facility_id);

		//serviceとmanagerDtoを見てこい

		assertEquals(f_facility_id, result.getFacilityDto().getFacilityId());
		assertEquals(f_name, result.getFacilityDto().getName());
		assertEquals(f_capacity, result.getFacilityDto().getCapacity());
		assertEquals(ft_facility_type_id, result.getFacilityDto().getFacilityTypeDto().getFacilityTypeId());

		assertEquals(1, result.getFacilityTypeDtoList().size());
		assertEquals(ft_facility_type_id, result.getFacilityTypeDtoList().get(0).getFacilityTypeId());
			assertEquals(ft_name, result.getFacilityTypeDtoList().get(0).getName());
		}

	/**
	 * findByfacilityId
	 * 異常系　データがなかった場合
	 */
	@Test
	public void testGetFacility_normal_002() {
		System.out.println("testGetFacility_normal_002");

		FacilityRepository facilityRepository = new StubFacilityRepository() {

			@Override
			public FacilityEntity findByFacilityId(int facilityId) {
				FacilityEntity facilityEntity = new FacilityEntity();

				return facilityEntity;
			}
		};

		service.setFacilityRepository(facilityRepository);

		FacilityTypeRepository facilityTypeRepository = new StubFacilityTypeRepository() {
			@Override
			public List<FacilityTypeEntity> findAll() {
				List<FacilityTypeEntity> facilityTypeEntityList = new ArrayList<FacilityTypeEntity>();

				return facilityTypeEntityList;
			}

		};
		service.setFacilityTypeRepository(facilityTypeRepository);

		FacilityManagerDto result = service.getFacilityDetailByFacilityId(f_facility_id);

		assertEquals(0, result.getFacilityDto().getFacilityId());
		assertNull(result.getFacilityDto().getName());
		assertEquals(0, result.getFacilityDto().getCapacity());

		assertEquals(0, result.getFacilityTypeDtoList().size());

	}

	/**
	 * findByName
	 * 正常系
	 */
	@Test
	public void testName() {

		FacilityRepository facilityRepository = new StubFacilityRepository() {

			@Override
			public List<FacilityEntity> findByName(String name) {
				List<FacilityEntity> list = new ArrayList<FacilityEntity>();
				FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity(ft_facility_type_id, ft_name, null,
						ft_update_user_id, null, ft_update_user_id, null, ft_update_user_id, ft_fg_delete);
				FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity,
						facilityTypeEntity,
						f_insert_date, f_user_id, f_update_date, f_update_user_id);

				list.add(facilityEntity);
				return list;

			}
		};

		service.setFacilityRepository(facilityRepository);

		FacilityManagerDto result = service.getFacilityByName(f_name);

		assertEquals(ServiceConst.THERE_IS_DATA, result.getResult());
		assertEquals(1, result.getFacilityDtoList().size());
		assertEquals(f_name, result.getFacilityDtoList().get(0).getName());
		assertEquals(f_facility_id, result.getFacilityDtoList().get(0).getFacilityId());
	}

	/**
	 * findByName
	 * NO_DATA
	 */
	@Test
	public void testNoDate() {
		FacilityRepository facilityRepository = new StubFacilityRepository() {

			@Override
			public List<FacilityEntity> findByName(String name) {
				List<FacilityEntity> list = new ArrayList<FacilityEntity>();

				return list;

			}
		};

		service.setFacilityRepository(facilityRepository);

		FacilityManagerDto result = service.getFacilityByName(f_name);

		assertEquals(ServiceConst.NO_DATA, result.getResult());

	}

	/**
	 * findByName
	 * ERROR
	 */
	@Test
	public void testErrorName() {
		FacilityRepository facilityRepository = new StubFacilityRepository() {

			@Override
			public List<FacilityEntity> findByName(String name) {
				List<FacilityEntity> list = new ArrayList<FacilityEntity>();
				list = null;

				return list;
			}
		};

		service.setFacilityRepository(facilityRepository);

		FacilityManagerDto result = service.getFacilityByName(f_name);

		assertEquals(ServiceConst.ERROR, result.getResult());

	}

	/**
	 * insert
	 * THERE_IS_DATA
	 */
	@Test
	public void testinsert_normal_001() {

		FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity,
				f_facility_type_id, f_insert_date, f_update_user_id, f_insert_date, f_update_user_id);
		FacilityManagerDto facilityDto = new FacilityManagerDto();
		List<FacilityTypeDto> facilityList = new ArrayList<FacilityTypeDto>();
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto(ft_facility_type_id, ft_name, ft_insert_date, null);
		facilityList.add(facilityTypeDto);

		UserManagerDto umsDto = new UserManagerDto();
		List<UserRoleDto> urDtoList = new ArrayList<UserRoleDto>();
		UserRoleDto urDto = new UserRoleDto(u_userId, ur_roleId);
		urDtoList.add(urDto);
		UserDto userDto = new UserDto(u_userId, u_userName, u_password, u_passUpdateDate, u_gender, u_birthday,
				u_contact, u_mailAddress, u_loginMissTimes, u_unlock, u_enabled, u_userDueDate, u_insertDate,
				u_updateDate, urDtoList);

		facilityDto.setFacilityDto(new FacilityDto(f_facility_id, f_name, f_capacity, facilityTypeDto, userDto));
		//	facilityDto.setFacilityTypeDtoList(facilityList);

		//楽観ロックはuodate deleteの時にしか使わない
		//	facilityDto.setOptimisticRockValue(facilityEntity.toString());

		FacilityRepository facilityRepository = new StubFacilityRepository() {

			@Override
			public int insert(FacilityEntity facilityEntity) {
				return 1;

			}
		};
		service.setFacilityRepository(facilityRepository);

		FacilityManagerDto result = service.add(facilityDto);

		assertEquals(ServiceConst.THERE_IS_DATA, result.getResult());
	}

	/**
	 * add
	 * 異常系（NO＿DATA）
	 */
	@Test
	public void testAdd_abnormal_001() {
		System.out.println("testAdd_abnormal_001");

		FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity,
				f_facility_type_id, f_insert_date, f_update_user_id, f_insert_date, f_update_user_id);
		FacilityManagerDto facilityDto = new FacilityManagerDto();
		List<FacilityTypeDto> facilityList = new ArrayList<FacilityTypeDto>();
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto(ft_facility_type_id, ft_name, ft_insert_date, null);
		facilityList.add(facilityTypeDto);

		UserManagerDto umsDto = new UserManagerDto();
		List<UserRoleDto> urDtoList = new ArrayList<UserRoleDto>();
		UserRoleDto urDto = new UserRoleDto(u_userId, ur_roleId);
		urDtoList.add(urDto);
		UserDto userDto = new UserDto(u_userId, u_userName, u_password, u_passUpdateDate, u_gender, u_birthday,
				u_contact, u_mailAddress, u_loginMissTimes, u_unlock, u_enabled, u_userDueDate, u_insertDate,
				u_updateDate, urDtoList);

		facilityDto.setFacilityDto(new FacilityDto(f_facility_id, f_name, f_capacity, facilityTypeDto, userDto));
		facilityDto.setFacilityTypeDtoList(facilityList);
		facilityDto.setOptimisticRockValue(facilityEntity.toString());

		FacilityRepository facilityRepository = new StubFacilityRepository() {

			@Override
			public int insert(FacilityEntity facilityEntity) {
				return 0;

			}
		};
		service.setFacilityRepository(facilityRepository);

		//引数の中身はnullじゃダメだと言われるから中身を用意しないといけない
		FacilityManagerDto result = service.add(facilityDto);

		assertEquals(ServiceConst.NO_DATA, result.getResult());

	}

	/**
	 * update
	 * 正常系
	 */
	@Test
	public void testUpdate_normal_001() {
		System.out.println("testUpdate_normal_001");

		FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity,
				f_facility_type_id, f_insert_date, f_update_user_id, f_insert_date, f_update_user_id);
		FacilityManagerDto facilityDto = new FacilityManagerDto();
		List<FacilityTypeDto> facilityList = new ArrayList<FacilityTypeDto>();
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto(ft_facility_type_id, ft_name, ft_insert_date, null);
		facilityList.add(facilityTypeDto);

		List<UserRoleDto> urDtoList = new ArrayList<UserRoleDto>();
		UserRoleDto urDto = new UserRoleDto(u_userId, ur_roleId);
		urDtoList.add(urDto);
		UserDto userDto = new UserDto(u_userId, u_userName, u_password, u_passUpdateDate, u_gender, u_birthday,
				u_contact, u_mailAddress, u_loginMissTimes, u_unlock, u_enabled, u_userDueDate, u_insertDate,
				u_updateDate, urDtoList);

		facilityDto.setFacilityDto(new FacilityDto(f_facility_id, f_name, f_capacity, facilityTypeDto, userDto));
		facilityDto.setFacilityTypeDtoList(facilityList);
		facilityDto.setOptimisticRockValue(facilityEntity.toString());

		FacilityRepository facilityRepository = new StubFacilityRepository() {

			@Override
			public int update(FacilityEntity facilityEntity) {
				return 1;

			}

			@Override
			public FacilityEntity findByFacilityId(int facilityId) {

				return facilityEntity;

			}
		};

		service.setFacilityRepository(facilityRepository);

		FacilityManagerDto result = service.update(facilityDto);

		assertEquals(ServiceConst.OK, result.getResult());

	}

	/**
	 * update
	 * 異常系（OPTIMISTIC_ROCK_ERROR）
	 */
	@Test
	public void testUpdate_normal_004() {
		System.out.println("testUpdate_normal_004");

		FacilityManagerDto facilityDto = new FacilityManagerDto();
		List<FacilityTypeDto> facilityList = new ArrayList<FacilityTypeDto>();
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto(ft_facility_type_id, ft_name, ft_insert_date, null);
		facilityList.add(facilityTypeDto);

		UserManagerDto umsDto = new UserManagerDto();
		List<UserRoleDto> urDtoList = new ArrayList<UserRoleDto>();
		UserRoleDto urDto = new UserRoleDto(u_userId, ur_roleId);
		urDtoList.add(urDto);
		UserDto userDto = new UserDto(u_userId, u_userName, u_password, u_passUpdateDate, u_gender, u_birthday,
				u_contact, u_mailAddress, u_loginMissTimes, u_unlock, u_enabled, u_userDueDate, u_insertDate,
				u_updateDate, urDtoList);

		facilityDto.setFacilityDto(new FacilityDto(f_facility_id, f_name, f_capacity, facilityTypeDto, userDto));
		facilityDto.setFacilityTypeDtoList(facilityList);

		FacilityRepository facilityRepository = new StubFacilityRepository() {

			@Override
			public FacilityEntity findByFacilityId(int facilityId) {
				FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity,
						f_facility_type_id, f_insert_date, f_update_user_id, f_insert_date, f_update_user_id);
				return facilityEntity;

			}
		};
		service.setFacilityRepository(facilityRepository);
		//	service.setFacilityTypeRepository(facilityTypeRepository);

		FacilityManagerDto result = service.update(facilityDto);

		assertEquals(ServiceConst.OPTIMISTIC_ROCK_ERROR, result.getResult());

	}

	/**
	 * update
	 * 異常系(ERROR)
	 */
	@Test
	public void testUpdate_abnormal_001() {
		System.out.println("testUpdate_abnormal_001");

		FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity,
				f_facility_type_id, f_insert_date, f_update_user_id, f_insert_date, f_update_user_id);
		FacilityManagerDto facilityDto = new FacilityManagerDto();
		List<FacilityTypeDto> facilityList = new ArrayList<FacilityTypeDto>();
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto(ft_facility_type_id, ft_name, ft_insert_date, null);
		facilityList.add(facilityTypeDto);

		UserManagerDto umsDto = new UserManagerDto();
		List<UserRoleDto> urDtoList = new ArrayList<UserRoleDto>();
		UserRoleDto urDto = new UserRoleDto(u_userId, ur_roleId);
		urDtoList.add(urDto);
		UserDto userDto = new UserDto(u_userId, u_userName, u_password, u_passUpdateDate, u_gender, u_birthday,
				u_contact, u_mailAddress, u_loginMissTimes, u_unlock, u_enabled, u_userDueDate, u_insertDate,
				u_updateDate, urDtoList);

		facilityDto.setFacilityDto(new FacilityDto(f_facility_id, f_name, f_capacity, facilityTypeDto, userDto));
		facilityDto.setFacilityTypeDtoList(facilityList);
		facilityDto.setOptimisticRockValue(facilityEntity.toString());

		FacilityRepository facilityRepository = new StubFacilityRepository() {

			@Override
			public FacilityEntity findByFacilityId(int facilityId) {
				FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity,
						f_facility_type_id, f_insert_date, f_update_user_id, f_insert_date, f_update_user_id);
				return facilityEntity;

			}
		};
		service.setFacilityRepository(facilityRepository);

		FacilityManagerDto result = service.update(facilityDto);

		assertEquals(ServiceConst.ERROR, result.getResult());

	}

	/**
	 * update
	 * 異常系(ERROR) 2の場合
	 */
	@Test
	public void testUpdate_abnormal_002() {
		System.out.println("testUpdate_abnormal_002");

		FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity,
				f_facility_type_id, f_insert_date, f_update_user_id, f_insert_date, f_update_user_id);
		FacilityManagerDto facilityDto = new FacilityManagerDto();
		List<FacilityTypeDto> facilityList = new ArrayList<FacilityTypeDto>();
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto(ft_facility_type_id, ft_name, ft_insert_date, null);
		facilityList.add(facilityTypeDto);

		List<UserRoleDto> urDtoList = new ArrayList<UserRoleDto>();
		UserRoleDto urDto = new UserRoleDto(u_userId, ur_roleId);
		UserRoleDto urDto1 = new UserRoleDto(u_userId, ur_roleId1);
		urDtoList.add(urDto);
		urDtoList.add(urDto1);

		UserDto userDto = new UserDto(u_userId, u_userName, u_password, u_passUpdateDate, u_gender, u_birthday,
				u_contact, u_mailAddress, u_loginMissTimes, u_unlock, u_enabled, u_userDueDate, u_insertDate,
				u_updateDate, urDtoList);

		facilityDto.setFacilityDto(new FacilityDto(f_facility_id, f_name, f_capacity, facilityTypeDto, userDto));
		facilityDto.setFacilityTypeDtoList(facilityList);
		facilityDto.setOptimisticRockValue(facilityEntity.toString());

		FacilityRepository facilityRepository = new StubFacilityRepository() {

			@Override
			public int update(FacilityEntity facilityEntity) {
				return 2;
			}

			@Override
			public FacilityEntity findByFacilityId(int facilityId) {
				FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity,
						f_facility_type_id, f_insert_date, f_update_user_id, f_insert_date, f_update_user_id);
				return facilityEntity;

			}
		};
		service.setFacilityRepository(facilityRepository);

		FacilityManagerDto result = service.update(facilityDto);

		assertEquals(ServiceConst.ERROR, result.getResult());

	}

	/**
	 * delete
	 * 正常系
	 */
	@Test
	public void testDelete_normal_001() {
		System.out.println("testDelete_normal_001");

		FacilityManagerDto facilityManagerDto = new FacilityManagerDto();
		List<FacilityTypeDto> facilityTypeDtoList = new ArrayList<FacilityTypeDto>();
		FacilityTypeDto faclityTypeDto = new FacilityTypeDto(ft_facility_type_id, ft_name, ft_insert_date, null);
		facilityTypeDtoList.add(faclityTypeDto);

		UserManagerDto umsDto = new UserManagerDto();
		List<UserRoleDto> urDtoList = new ArrayList<UserRoleDto>();
		UserRoleDto urDto = new UserRoleDto(u_userId, ur_roleId);
		urDtoList.add(urDto);
		UserDto userDto = new UserDto(u_userId, u_userName, u_password, u_passUpdateDate, u_gender, u_birthday,
				u_contact, u_mailAddress, u_loginMissTimes, u_unlock, u_enabled, u_userDueDate, u_insertDate,
				u_updateDate, urDtoList);

		facilityManagerDto.setFacilityDto(new FacilityDto(f_facility_id, f_name, f_capacity, faclityTypeDto, userDto));

		FacilityRepository facilityRepository = new StubFacilityRepository() {

			@Override
			public int delete(int facilityId) {
				return 1;
			}
		};

		service.setFacilityRepository(facilityRepository);

		FacilityManagerDto result = service.delete(facilityManagerDto);

		assertEquals(ServiceConst.OK, result.getResult());
	}

	/**
	 * delete
	 * 異常系
	 */
	@Test
	public void testDelete_abnormal_001() {
		System.out.println("testDelete_abnormal_001");

		FacilityManagerDto facilityManagerDto = new FacilityManagerDto();
		List<FacilityTypeDto> facilityTypeDtoList = new ArrayList<FacilityTypeDto>();
		FacilityTypeDto faclityTypeDto = new FacilityTypeDto(ft_facility_type_id, ft_name, ft_insert_date, null);
		facilityTypeDtoList.add(faclityTypeDto);

		UserManagerDto umsDto = new UserManagerDto();
		List<UserRoleDto> urDtoList = new ArrayList<UserRoleDto>();
		UserRoleDto urDto = new UserRoleDto(u_userId, ur_roleId);
		urDtoList.add(urDto);
		UserDto userDto = new UserDto(u_userId, u_userName, u_password, u_passUpdateDate, u_gender, u_birthday,
				u_contact, u_mailAddress, u_loginMissTimes, u_unlock, u_enabled, u_userDueDate, u_insertDate,
				u_updateDate, urDtoList);

		facilityManagerDto.setFacilityDto(new FacilityDto(f_facility_id, f_name, f_capacity, faclityTypeDto, userDto));

		FacilityRepository facilityRepository = new StubFacilityRepository() {

			@Override
			public int delete(int facilityId) {
				return 0;
			}
		};

		service.setFacilityRepository(facilityRepository);

		FacilityManagerDto result = service.delete(facilityManagerDto);

		assertEquals(ServiceConst.ERROR, result.getResult());
	}

	/*	@Test
		public void testGetTypeList_normal_001() {
			System.out.println("testGetTypeList_normal_001");

			FacilityRepository facilityRepository = new StubFacilityRepository() {
				@Override
				public List<FacilityEntity> findAll() {

					List<FacilityEntity> FacilityEntityList = new ArrayList<FacilityEntity>();
					FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity,
							f_facility_type_id, f_insert_date, f_update_user_id, f_insert_date, f_update_user_id);
					FacilityEntityList.add(facilityEntity);

					return FacilityEntityList;
				}
			};
			service.setFacilityRepository(facilityRepository);

			FacilityManagerDto result = service.getFacilityList();

			assertEquals(1, result.getFacilityDtoList().size());
			assertEquals(f_facility_id, result.getFacilityDtoList().get(0).getFacilityId());
			assertEquals(f_name, result.getFacilityDtoList().get(0).getName());

		}
		*/

	/*
		//権限変更有
		@Test
		public void testUpdate_normal_002() {
			System.out.println("testUpdate_normal_002");
			FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity,
					f_facility_type_id, f_insert_date, f_update_user_id, f_insert_date, f_update_user_id);
			FacilityManagerDto facilityDto = new FacilityManagerDto();
			List<FacilityTypeDto> facilityList = new ArrayList<FacilityTypeDto>();
			FacilityTypeDto facilityTypeDto = new FacilityTypeDto(ft_facility_type_id, ft_name, ft_insert_date, null);
			facilityList.add(facilityTypeDto);

			List<UserRoleDto> urDtoList = new ArrayList<UserRoleDto>();
			UserRoleDto urDto = new UserRoleDto(u_userId, ur_roleId);
			UserRoleDto urDto1 = new UserRoleDto(u_userId, ur_roleId1);
			urDtoList.add(urDto);
			urDtoList.add(urDto1);

			UserDto userDto = new UserDto(u_userId, u_userName, u_password, u_passUpdateDate, u_gender, u_birthday,
					u_contact, u_mailAddress, u_loginMissTimes, u_unlock, u_enabled, u_userDueDate, u_insertDate,
					u_updateDate, urDtoList);

			facilityDto.setFacilityDto(new FacilityDto(f_facility_id, f_name, f_capacity, facilityTypeDto, userDto));
			facilityDto.setFacilityTypeDtoList(facilityList);
			facilityDto.setOptimisticRockValue(facilityEntity.toString());

			FacilityRepository facilityRepository = new StubFacilityRepository() {

				@Override
				public int update(FacilityEntity entity) {
					return 1;
				}

				@Override
				public FacilityEntity findByFacilityId(int facilityId) {
					FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity,
							f_facility_type_id, f_insert_date, f_update_user_id, f_insert_date, f_update_user_id);
					return facilityEntity;

				}
			};

			service.setFacilityRepository(facilityRepository);

			FacilityManagerDto result = service.update(facilityDto);

			assertEquals(ServiceConst.OK, result.getResult());
		}
			//権限削除

	@Test
	public void testUpdate_normal_003() {
		System.out.println("testUpdate_normal_003");

		FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity,
				f_facility_type_id, f_insert_date, f_update_user_id, f_insert_date, f_update_user_id);
		FacilityManagerDto facilityDto = new FacilityManagerDto();
		List<FacilityTypeDto> facilityList = new ArrayList<FacilityTypeDto>();
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto(ft_facility_type_id, ft_name, ft_insert_date, null);
		facilityList.add(facilityTypeDto);

		List<UserRoleDto> urDtoList = new ArrayList<UserRoleDto>();
		UserRoleDto urDto = new UserRoleDto(u_userId, ur_roleId);
		urDtoList.add(urDto);
		UserDto userDto = new UserDto(u_userId, u_userName, u_password, u_passUpdateDate, u_gender, u_birthday,
				u_contact, u_mailAddress, u_loginMissTimes, u_unlock, u_enabled, u_userDueDate, u_insertDate,
				u_updateDate, urDtoList);

		facilityDto.setFacilityDto(new FacilityDto(f_facility_id, f_name, f_capacity, facilityTypeDto, userDto));
		facilityDto.setFacilityTypeDtoList(facilityList);
		facilityDto.setOptimisticRockValue(facilityEntity.toString());

		FacilityRepository facilityRepository = new StubFacilityRepository() {

			@Override
			public int update(FacilityEntity facilityEntity) {
				return 1;

			}

			@Override
			public FacilityEntity findByFacilityId(int facilityTypeId) {
				FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity,
						f_facility_type_id, f_insert_date, f_update_user_id, f_insert_date, f_update_user_id);
				return facilityEntity;
			}
		};

		service.setFacilityRepository(facilityRepository);

		FacilityManagerDto result = service.update(facilityDto);

		assertEquals(ServiceConst.OK, result.getResult());
	}
		*
		*/
}
