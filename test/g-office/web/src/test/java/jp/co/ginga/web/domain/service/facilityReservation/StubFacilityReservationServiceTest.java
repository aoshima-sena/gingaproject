package jp.co.ginga.web.domain.service.facilityReservation;

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
import jp.co.ginga.infra.repository.facility.FacilityRepository;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeRepository;
import jp.co.ginga.infra.repository.reservation.ReservationEntity;
import jp.co.ginga.infra.repository.reservation.ReservationRepository;
import jp.co.ginga.infra.repository.user.UserEntity;
import jp.co.ginga.web.domain.service.stub.StubFacilityRepository;
import jp.co.ginga.web.domain.service.stub.StubFacilityTypeRepository;
import jp.co.ginga.web.domain.service.stub.StubReservationRepository;
import jp.co.ginga.web.domain.service.util.constant.ServiceConst;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;
import jp.co.ginga.web.domain.service.util.dto.userrole.UserRoleDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StubFacilityReservationServiceTest {

	@Autowired
	FacilityReservationManagerService service;

	String datetime = "2022-11-10 11:11:11";
	private int ft_facility_type_id = 1;
	private String ft_name = "会議室";
	private Date ft_insert_date = Date.valueOf(datetime);
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
	private int m_reservation_id = 1;
	private Timestamp m_start_time = Timestamp.valueOf(datetime);
	private Timestamp m_end_time = Timestamp.valueOf(datetime);
	private FacilityEntity m_facility_id = null;
	private Timestamp m_insert_date = null;
	private UserEntity m_insert_user_id = null;
	private Timestamp m_update_date = null;
	private UserEntity m_update_user_id = null;
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

	@Test
	public void testGetFacilityTypeId_normal_001() {
		//TEST DATA
		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity();
		facilityTypeEntity.setFacilityTypeId(ft_facility_type_id);
		facilityTypeEntity.setName(ft_name);

		System.out.println("testGetFacilityDetailByFacilityId_normal_001");

		FacilityRepository facilityRepository = new StubFacilityRepository() {

			@Override
			public List<FacilityEntity> findByFacilityTypeId(int facilityTypeId) {
				List<FacilityEntity> list = new ArrayList<FacilityEntity>();
				FacilityEntity entity = new FacilityEntity(f_facility_id, f_name, ft_facility_type_id,
						facilityTypeEntity, f_insert_date, f_update_user_id, f_update_date, f_user_id);
				list.add(entity);
				return list;
			}

			//		@Override
			//		public List<FacilityEntity> findAll() {
			//			List<FacilityEntity> list = new ArrayList<FacilityEntity>();
			//			FacilityEntity entity = new FacilityEntity(f_facility_id, f_name, ft_facility_type_id,
			//					facilityTypeEntity, f_insert_date, f_update_user_id, f_update_date, f_user_id);
			//			list.add(entity);
			//			return list;
			//		}
			//		@Override
			//		public FacilityEntity findByFacilityId(int facilityId) {
			//			return facilityEntity;
			//		}

		};

		service.setFacilityRepository(facilityRepository);
		//	FacilityTypeRepository facilityTypeRepository = new StubFacilityTypeRepository() {
		//		@Override
		//		public List<FacilityTypeEntity> findAll() {
		//			List<FacilityTypeEntity> facilityTypeEntityList = new ArrayList<FacilityTypeEntity>();

		//		facilityTypeEntityList.add(facilityTypeEntity);
		//		return facilityTypeEntityList;
		//		}
		//	};
		//	service.setFacilityTypeRepository(facilityTypeRepository);

		FacilityReservationManagerDto result = service.getFacilityByFacilityTypeId(f_facility_id);

		//		assertEquals(ServiceConst.THERE_IS_DATA, result.getResult());

		assertEquals(1, result.getFacilityDtoList().size());
		assertEquals(f_facility_id, result.getFacilityDtoList().get(0).getFacilityId());
		assertEquals(f_name, result.getFacilityDtoList().get(0).getName());
		//	assertEquals(f_capacity, result.getFacilityDtoList().get(0).getCapacity());
		//	assertEquals(ft_facility_type_id, result.getFacilityDtoList().get(0).getFacilityTypeDto().getFacilityTypeId());

		//	assertEquals(1, result.getFacilityTypeDtoList().size());
		//	assertEquals(ft_facility_type_id, result.getFacilityTypeDtoList().get(0).getFacilityTypeId());
		//	assertEquals(ft_name, result.getFacilityTypeDtoList().get(0).getName());

		//	assertEquals(facilityEntity.toString(), result.getOptimisticRockValue());
	}

	@Test
	public void testNoGetFacilityTypeId_normal_002() {
		System.out.println("testGetFacilityTypeId_normal_002");

		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity();
		facilityTypeEntity.setFacilityTypeId(ft_facility_type_id);
		facilityTypeEntity.setName(ft_name);

		FacilityRepository facilityRepository = new StubFacilityRepository() {

			@Override
			public List<FacilityEntity> findByFacilityTypeId(int facilityTypeId) {
				List<FacilityEntity> list = new ArrayList<FacilityEntity>();
				return list;
			}

		};

		service.setFacilityRepository(facilityRepository);

		FacilityReservationManagerDto result = service.getFacilityByFacilityTypeId(f_facility_id);

		assertEquals(0, result.getFacilityDtoList().size());

	}
	@Test
	public void getList() {

		FacilityTypeEntity facilityTypeEntity = new FacilityTypeEntity();
		facilityTypeEntity.setFacilityTypeId(f_facility_id);
		facilityTypeEntity.setName(ft_name);

		List<FacilityTypeEntity> typeEntityList = new ArrayList<FacilityTypeEntity>();
		typeEntityList.add(facilityTypeEntity);

		FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity, facilityTypeEntity, f_insert_date, f_user_id, f_update_date, ft_update_user_id);

		List<FacilityEntity> entityList = new ArrayList<FacilityEntity>();
		entityList.add(facilityEntity);

		FacilityRepository facilityRepository = new StubFacilityRepository() {

			@Override
			public List<FacilityEntity> findAll() {
				return entityList;
			}
		};

		service.setFacilityRepository(facilityRepository);

		FacilityTypeRepository facilityTypeRepository = new StubFacilityTypeRepository() {
			@Override
			public List<FacilityTypeEntity> findAll() {
				return typeEntityList;
			}
		};

		service.setFacilityTypeRepository(facilityTypeRepository);

		FacilityReservationManagerDto result = service.getFacilityList();

		assertEquals(f_facility_id,result.getFacilityDtoList().get(0).getFacilityId());
		assertEquals(f_name,result.getFacilityDtoList().get(0).getName());
		assertEquals(f_capacity,result.getFacilityDtoList().get(0).getCapacity());
		assertEquals(ft_facility_type_id,result.getFacilityDtoList().get(0).getFacilityTypeDto().getFacilityTypeId());
		assertEquals(ft_name,result.getFacilityDtoList().get(0).getFacilityTypeDto().getName());

	}

	@Test
	public void reservationIdOK() {
		ReservationEntity reservationEntity = new ReservationEntity(m_reservation_id, m_start_time, m_end_time,
				m_facility_id, m_insert_date, m_insert_user_id, m_update_date, m_update_user_id);

		ReservationRepository repository = new StubReservationRepository() {

			@Override
			public ReservationEntity findOneById(ReservationEntity entity) {
				return reservationEntity;
			}

		};

		service.setReservationRepository(repository);
		FacilityReservationManagerDto result = service.getReservationId(reservationEntity);
		//m_reservation_id
		assertEquals(m_reservation_id, result.getReservationDto().getReservationId());
		assertEquals(m_start_time, result.getReservationDto().getStartTime());
		assertEquals(m_end_time, result.getReservationDto().getEndTime());
		//	assertEquals(null, result.getReservationDto().getFacilityDto().getFacilityId());
		//	assertNull(result.getReservationDto().getInsertDate());
		//	assertNull(result.getReservationDto().getUserDto().getUserId());
		//	assertNull(result.getReservationDto().getUpdateDate());
		//	assertNull(result.getReservationDto().getUserDto().getUserId());

	}

	@Test
	public void reservationIdNo() {
		ReservationEntity reservationEntity = new ReservationEntity();
		ReservationRepository repository = new StubReservationRepository() {
			@Override
			public ReservationEntity findOneById(ReservationEntity entity) {
				ReservationEntity reservationEntity = new ReservationEntity();
				return reservationEntity;
			}
		};

		service.setReservationRepository(repository);
		FacilityReservationManagerDto result = service.getReservationId(reservationEntity);
		//↑ReservationEntity型の引数だからreservationEntityを入れる
		assertEquals(0, result.getReservationDto().getReservationId());
		assertEquals(null, result.getReservationDto().getStartTime());
		assertEquals(null, result.getReservationDto().getEndTime());
	}

	@Test
	public void facilityIdandStartTimeandEndTime() {
		ReservationEntity entity = new ReservationEntity(m_reservation_id, m_start_time, m_end_time, m_facility_id,
				m_insert_date, m_insert_user_id, m_update_date, m_update_user_id);

		ReservationRepository repository = new StubReservationRepository() {

			@Override
			public List<ReservationEntity> findByFacilityIdAndStartDateBetween(int facilityId, Timestamp startTime,
					Timestamp endTime) {
				List<ReservationEntity> list = new ArrayList<ReservationEntity>();
				list.add(entity);
				return list;
			}
		};

		service.setReservationRepository(repository);
		FacilityReservationManagerDto result = service.getFacilityIdAndStartDateBetween(m_reservation_id, m_start_time,
				m_end_time);

		assertEquals(m_reservation_id, result.getReservationDtoList().get(0).getReservationId());
		assertEquals(m_start_time, result.getReservationDtoList().get(0).getStartTime());
		assertEquals(m_end_time, result.getReservationDtoList().get(0).getEndTime());

	}

	@Test
	public void NoFacilityIdandStartTimeandEndTime() {
		//repositoryの引数の中にはEntityは入らないから生成する必要がない
		//	ReservationEntity reservationEntity = new ReservationEntity();
		ReservationRepository reservationRepository = new StubReservationRepository() {
			@Override
			public List<ReservationEntity> findByFacilityIdAndStartDateBetween(int facilityId, Timestamp startTime,
					Timestamp endTime) {
				List<ReservationEntity> list = new ArrayList<ReservationEntity>();
				return list;
			}
		};

		service.setReservationRepository(reservationRepository);
		FacilityReservationManagerDto result = service.getFacilityIdAndStartDateBetween(m_reservation_id, m_start_time,
				m_end_time);
		assertEquals(0, result.getReservationDtoList().size());

	}

	//一旦無視
	@Test
	public void canMakeReservationTest() {
		ReservationEntity entity = new ReservationEntity(m_reservation_id, m_start_time, m_insert_date, m_facility_id,
				m_end_time, m_insert_user_id, m_update_date, m_update_user_id);
		ReservationRepository repository = new StubReservationRepository() {
			@Override
			public int canMakeReservation(int facilityId, Timestamp startTime, Timestamp endTime) {

				return 1;
			}
		};

		service.setReservationRepository(repository);
		int result = service.getCanMakeReservation(m_reservation_id, m_start_time, m_end_time);

	//	assertEquals(1, result.getReservationDto().getReservationId());
		//		assertEquals(m_reservation_id, result.getReservationDto().getReservationId());
		//		assertEquals(m_start_time, result.getReservationDto().getStartTime());
		//		assertEquals(m_end_time, result.getReservationDto().getEndTime());
	}

	@Test
	public void testStartEnd() {
		FacilityEntity facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity, f_facility_type_id, f_insert_date, f_update_user_id, f_update_date, f_update_user_id);
		ReservationEntity entity = new ReservationEntity(m_reservation_id, m_start_time, m_end_time, facilityEntity, m_insert_date, m_update_user_id, m_update_date, m_insert_user_id);

		ReservationRepository reservationRepository = new StubReservationRepository() {
			@Override
			public List<ReservationEntity> findStartEnd(int facilityId) {
				List<ReservationEntity> list = new ArrayList<ReservationEntity>();
				list.add(entity);
				return list;
			}
		};

		service.setReservationRepository(reservationRepository);

		FacilityReservationManagerDto result = service.findStartEnd(f_facility_id);

		assertEquals(m_reservation_id,result.getReservationDtoList().get(0).getReservationId());
		assertEquals(m_start_time,result.getReservationDtoList().get(0).getStartTime());
		assertEquals(m_end_time,result.getReservationDtoList().get(0).getEndTime());
		assertEquals(f_facility_id,result.getReservationDtoList().get(0).getFacilityDto().getFacilityId());
		assertEquals(f_name,result.getReservationDtoList().get(0).getFacilityDto().getName());
	}

	@Test
	public void reservationIdTest() {
		ReservationEntity entity = new ReservationEntity(m_reservation_id, m_start_time, m_end_time, m_facility_id,
				m_insert_date, m_insert_user_id, m_update_date, m_update_user_id);

		ReservationRepository reservationRepository = new StubReservationRepository() {
			@Override
			public ReservationEntity findReservationId(int facilityId, Timestamp startTime, Timestamp endTime) {

				return entity;
			}
		};

		service.setReservationRepository(reservationRepository);

		FacilityReservationManagerDto result = service.reservationId(f_facility_id, m_start_time, m_end_time);

		assertEquals(m_reservation_id,result.getReservationDto().getReservationId());
	}

	@Test
	public void addTest() {
		ReservationEntity entity = new ReservationEntity();

		FacilityReservationManagerDto reservationDto = new FacilityReservationManagerDto();
		//	UserDtoのやつ
		List<UserRoleDto> urDtoList = new ArrayList<UserRoleDto>();
		UserRoleDto urDto = new UserRoleDto(u_userId, ur_roleId);
		urDtoList.add(urDto);
		UserDto userDto = new UserDto(u_userId, u_userName, u_password, u_passUpdateDate, u_gender, u_birthday,
				u_contact, u_mailAddress, u_loginMissTimes, u_unlock, u_enabled, u_userDueDate, u_insertDate,
				u_updateDate, urDtoList);
		//facilityDtoのやつ
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto(ft_facility_type_id, ft_name);
		FacilityDto facilityDto = new FacilityDto(f_facility_id, f_name, f_capacity, facilityTypeDto, userDto);

		//reservationDtoに値を入れる
		reservationDto.setReservationDto(new FacilityReservationDto(m_reservation_id, m_start_time, m_end_time, m_insert_date,
				m_update_date, facilityDto, null, null, null, userDto));
		reservationDto.setOptimisticRockValue(entity.toString());

		ReservationRepository repostiory = new StubReservationRepository() {
			@Override
			public int insert(ReservationEntity entity) {
				return 1;
			}
		};

		service.setReservationRepository(repostiory);
		FacilityReservationManagerDto result = service.add(reservationDto);

		assertEquals(ServiceConst.THERE_IS_DATA, result.getResult());
	}

	@Test
	public void NoInsertTest() {
		ReservationEntity entity = new ReservationEntity(m_reservation_id, m_start_time, m_end_time, m_facility_id,
				m_insert_date, m_insert_user_id, m_update_date, m_update_user_id);

		FacilityReservationManagerDto reservationDto = new FacilityReservationManagerDto();
		//	UserDtoのやつ
		List<UserRoleDto> urDtoList = new ArrayList<UserRoleDto>();
		UserRoleDto urDto = new UserRoleDto(u_userId, ur_roleId);
		urDtoList.add(urDto);
		UserDto userDto = new UserDto(u_userId, u_userName, u_password, u_passUpdateDate, u_gender, u_birthday,
				u_contact, u_mailAddress, u_loginMissTimes, u_unlock, u_enabled, u_userDueDate, u_insertDate,
				u_updateDate, urDtoList);
		//facilityDtoのやつ
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto(ft_facility_type_id, ft_name);
		FacilityDto facilityDto = new FacilityDto(f_facility_id, f_name, f_capacity, facilityTypeDto, userDto);

		//reservationDtoに値を入れる
		reservationDto.setReservationDto(new FacilityReservationDto(m_reservation_id, m_start_time, m_end_time, m_insert_date,
				m_update_date, facilityDto, null, null, null, userDto));
		reservationDto.setOptimisticRockValue(entity.toString());

		ReservationRepository repostiory = new StubReservationRepository() {
			@Override
			public int insert(ReservationEntity entity) {
				return 0;
			}
		};

		service.setReservationRepository(repostiory);
		FacilityReservationManagerDto result = service.add(reservationDto);

		assertEquals(ServiceConst.NO_DATA, result.getResult());
	}

	@Test
	public void testUpdate() {
		ReservationEntity reservationEntity = new ReservationEntity(m_reservation_id, m_start_time, m_end_time,
				m_facility_id, m_insert_date, m_insert_user_id, m_update_date, m_update_user_id);
		FacilityReservationManagerDto reservationDto = new FacilityReservationManagerDto();
		//	UserDtoのやつ
		List<UserRoleDto> urDtoList = new ArrayList<UserRoleDto>();
		UserRoleDto urDto = new UserRoleDto(u_userId, ur_roleId);
		urDtoList.add(urDto);
		UserDto userDto = new UserDto(u_userId, u_userName, u_password, u_passUpdateDate, u_gender, u_birthday,
				u_contact, u_mailAddress, u_loginMissTimes, u_unlock, u_enabled, u_userDueDate, u_insertDate,
				u_updateDate, urDtoList);
		//facilityDtoのやつ
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto(ft_facility_type_id, ft_name);
		FacilityDto facilityDto = new FacilityDto(f_facility_id, f_name, f_capacity, facilityTypeDto, userDto);

		//reservationDtoに値を入れる
		reservationDto.setReservationDto(new FacilityReservationDto(m_reservation_id, m_start_time, m_end_time, m_insert_date,
				m_update_date, facilityDto, null, null, null, userDto));
		reservationDto.setOptimisticRockValue(reservationEntity.toString());

		ReservationRepository repository = new StubReservationRepository() {
			@Override
			public int update(ReservationEntity entity) {
				return 1;

			}

			@Override
			public ReservationEntity findOneById(ReservationEntity entity) {
				return reservationEntity;
			}
		};

		service.setReservationRepository(repository);
		FacilityReservationManagerDto result = service.update(reservationDto);

		assertEquals(ServiceConst.OK, result.getResult());

	}

	@Test
	public void testUpdate_opotimistic() {
		ReservationEntity reservationEntity = new ReservationEntity(m_reservation_id, m_start_time, m_end_time,
				m_facility_id, m_insert_date, m_insert_user_id, m_update_date, m_update_user_id);
		FacilityReservationManagerDto reservationDto = new FacilityReservationManagerDto();
		//	UserDtoのやつ
		List<UserRoleDto> urDtoList = new ArrayList<UserRoleDto>();
		UserRoleDto urDto = new UserRoleDto(u_userId, ur_roleId);
		urDtoList.add(urDto);
		UserDto userDto = new UserDto(u_userId, u_userName, u_password, u_passUpdateDate, u_gender, u_birthday,
				u_contact, u_mailAddress, u_loginMissTimes, u_unlock, u_enabled, u_userDueDate, u_insertDate,
				u_updateDate, urDtoList);
		//facilityDtoのやつ
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto(ft_facility_type_id, ft_name);
		FacilityDto facilityDto = new FacilityDto(f_facility_id, f_name, f_capacity, facilityTypeDto, userDto);

		//reservationDtoに値を入れる
		reservationDto.setReservationDto(new FacilityReservationDto(m_reservation_id, m_start_time, m_end_time, m_insert_date,
				m_update_date, facilityDto, null, null, null, userDto));

		ReservationRepository repository = new StubReservationRepository() {
			@Override
			public int update(ReservationEntity entity) {
				return 1;

			}

			@Override
			public ReservationEntity findOneById(ReservationEntity entity) {
				return reservationEntity;
			}
		};

		service.setReservationRepository(repository);
		FacilityReservationManagerDto result = service.update(reservationDto);

		assertEquals(ServiceConst.OPTIMISTIC_ROCK_ERROR, result.getResult());
	}

	@Test
	public void NotestUpdate1() {
		ReservationEntity reservationEntity = new ReservationEntity(m_reservation_id, m_start_time, m_end_time,
				m_facility_id, m_insert_date, m_insert_user_id, m_update_date, m_update_user_id);
		FacilityReservationManagerDto reservationDto = new FacilityReservationManagerDto();
		//	UserDtoのやつ
		List<UserRoleDto> urDtoList = new ArrayList<UserRoleDto>();
		UserRoleDto urDto = new UserRoleDto(u_userId, ur_roleId);
		urDtoList.add(urDto);
		UserDto userDto = new UserDto(u_userId, u_userName, u_password, u_passUpdateDate, u_gender, u_birthday,
				u_contact, u_mailAddress, u_loginMissTimes, u_unlock, u_enabled, u_userDueDate, u_insertDate,
				u_updateDate, urDtoList);
		//facilityDtoのやつ
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto(ft_facility_type_id, ft_name);
		FacilityDto facilityDto = new FacilityDto(f_facility_id, f_name, f_capacity, facilityTypeDto, userDto);

		//reservationDtoに値を入れる
		reservationDto.setReservationDto(new FacilityReservationDto(m_reservation_id, m_start_time, m_end_time, m_insert_date,
				m_update_date, facilityDto, null, null, null, userDto));
		reservationDto.setOptimisticRockValue(reservationEntity.toString());

		ReservationRepository repository = new StubReservationRepository() {

			@Override
			public ReservationEntity findOneById(ReservationEntity entity) {
				return reservationEntity;
			}
		};

		service.setReservationRepository(repository);
		FacilityReservationManagerDto result = service.update(reservationDto);

		assertEquals(ServiceConst.ERROR, result.getResult());
	}

	@Test
	public void NotestUpdate2() {
		ReservationEntity reservationEntity = new ReservationEntity(m_reservation_id, m_start_time, m_end_time,
				m_facility_id, m_insert_date, m_insert_user_id, m_update_date, m_update_user_id);
		FacilityReservationManagerDto reservationDto = new FacilityReservationManagerDto();
		//	UserDtoのやつ
		List<UserRoleDto> urDtoList = new ArrayList<UserRoleDto>();
		UserRoleDto urDto = new UserRoleDto(u_userId, ur_roleId);
		urDtoList.add(urDto);
		UserDto userDto = new UserDto(u_userId, u_userName, u_password, u_passUpdateDate, u_gender, u_birthday,
				u_contact, u_mailAddress, u_loginMissTimes, u_unlock, u_enabled, u_userDueDate, u_insertDate,
				u_updateDate, urDtoList);
		//facilityDtoのやつ
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto(ft_facility_type_id, ft_name);
		FacilityDto facilityDto = new FacilityDto(f_facility_id, f_name, f_capacity, facilityTypeDto, userDto);

		//reservationDtoに値を入れる
		reservationDto.setReservationDto(new FacilityReservationDto(m_reservation_id, m_start_time, m_end_time, m_insert_date,
				m_update_date, facilityDto, null, null, null, userDto));
		reservationDto.setOptimisticRockValue(reservationEntity.toString());

		ReservationRepository repository = new StubReservationRepository() {
			@Override
			public int update(ReservationEntity entity) {
				return 2;

			}

			@Override
			public ReservationEntity findOneById(ReservationEntity entity) {
				return reservationEntity;
			}
		};

		service.setReservationRepository(repository);
		FacilityReservationManagerDto result = service.update(reservationDto);

		assertEquals(ServiceConst.ERROR, result.getResult());
	}

	@Test
	public void testDelete() {

		FacilityReservationManagerDto reservationDto = new FacilityReservationManagerDto();
		//	UserDtoのやつ
		List<UserRoleDto> urDtoList = new ArrayList<UserRoleDto>();
		UserRoleDto urDto = new UserRoleDto(u_userId, ur_roleId);
		urDtoList.add(urDto);
		UserDto userDto = new UserDto(u_userId, u_userName, u_password, u_passUpdateDate, u_gender, u_birthday,
				u_contact, u_mailAddress, u_loginMissTimes, u_unlock, u_enabled, u_userDueDate, u_insertDate,
				u_updateDate, urDtoList);
		//facilityDtoのやつ
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto(ft_facility_type_id, ft_name);
		FacilityDto facilityDto = new FacilityDto(f_facility_id, f_name, f_capacity, facilityTypeDto, userDto);

		//reservationDtoに値を入れる
		reservationDto.setReservationDto(new FacilityReservationDto(m_reservation_id, m_start_time, m_end_time, m_insert_date,
				m_update_date, facilityDto, null, null, null, userDto));

		ReservationRepository repository = new StubReservationRepository() {
			@Override
			public int delete(int reservationId) {
				return 1;
			}
		};

		service.setReservationRepository(repository);
		FacilityReservationManagerDto result = service.delete(reservationDto);

		assertEquals(ServiceConst.OK, result.getResult());
	}

	@Test
	public void testNoDelete() {

		FacilityReservationManagerDto reservationDto = new FacilityReservationManagerDto();
		//	UserDtoのやつ
		List<UserRoleDto> urDtoList = new ArrayList<UserRoleDto>();
		UserRoleDto urDto = new UserRoleDto(u_userId, ur_roleId);
		urDtoList.add(urDto);
		UserDto userDto = new UserDto(u_userId, u_userName, u_password, u_passUpdateDate, u_gender, u_birthday,
				u_contact, u_mailAddress, u_loginMissTimes, u_unlock, u_enabled, u_userDueDate, u_insertDate,
				u_updateDate, urDtoList);
		//facilityDtoのやつ
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto(ft_facility_type_id, ft_name);
		FacilityDto facilityDto = new FacilityDto(f_facility_id, f_name, f_capacity, facilityTypeDto, userDto);

		//reservationDtoに値を入れる
		reservationDto.setReservationDto(new FacilityReservationDto(m_reservation_id, m_start_time, m_end_time, m_insert_date,
				m_update_date, facilityDto, null, null, null, userDto));

		ReservationRepository repository = new StubReservationRepository() {
			@Override
			public int delete(int reservationId) {
				return 0;
			}
		};

		service.setReservationRepository(repository);
		FacilityReservationManagerDto result = service.delete(reservationDto);

		assertEquals(ServiceConst.ERROR, result.getResult());
	}

}