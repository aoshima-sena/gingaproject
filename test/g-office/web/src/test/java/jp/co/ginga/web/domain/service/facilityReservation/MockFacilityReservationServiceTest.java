package jp.co.ginga.web.domain.service.facilityReservation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
import jp.co.ginga.infra.repository.user.UserRepository;
import jp.co.ginga.web.domain.service.facility.FacilityManagerDto;
import jp.co.ginga.web.domain.service.facility.FacilityManagerService;
import jp.co.ginga.web.domain.service.facility.FacilityManagerServiceImpl;
import jp.co.ginga.web.domain.service.util.constant.ServiceConst;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import jp.co.ginga.web.domain.service.util.dto.reservation.FacilityReservationDto;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MockFacilityReservationServiceTest {

	String datetime = "2022-11-10 11:11:11";
	private int ft_facility_type_id = 1;
	private String ft_name = "会議室";
	private Date ft_insert_date = new Date(System.currentTimeMillis());
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
	private String optimisticRockValue = f_facility_id + "," + f_name + "," + f_capacity + "," + f_facility_type_id
			+ "," + f_insert_date + "," + f_user_id + "," + f_update_date + "," + f_update_user_id;
	private int m_reservation_id = 1;
	private Timestamp m_start_time = Timestamp.valueOf(datetime);
	private Timestamp m_end_time = Timestamp.valueOf(datetime);
	private FacilityEntity m_facility_id = null;
	private Timestamp m_insert_date = null;
	private UserEntity m_insert_user_id = null;
	private Timestamp m_update_date = new Timestamp(System.currentTimeMillis());
	private UserEntity m_update_user_id = null;
	private String u_userId = "test";
	private String u_userName = "テストユーザー";
	private String u_password = "pass1";
	private Timestamp u_passUpdateDate = new Timestamp(System.currentTimeMillis());
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
	//null用
	private int f_null_facility_id = 0;
	private Timestamp m_null_start_time = null;
	private Timestamp m_null_end_time = null;

	//更新用
	private String upOptimisticRockValue = null;
	private int uf_facility_id2 = 2;
	private String uf_name2 = "会議室a";
	private int uf_facility_id3 = 3;
	private String uf_name3 = "会議室b";

	//test用entity
	private FacilityEntity facilityEntity;
	private FacilityEntity nullFacilityEntity;
	private FacilityTypeEntity facilityTypeEntity;
	private FacilityTypeEntity nullFacilityTypeEntity;
	private List<FacilityEntity> facilityEntityList;
	private List<FacilityTypeEntity> facilityTypeEntityList;
	private ReservationEntity reservationEntity;
	private ReservationEntity nullReservationEntity;
	private List<ReservationEntity> reservationEntityList;
	private UserEntity userEntity;
	private UserEntity nullUserEntity;

	//update用リスト
	private List<FacilityEntity> upFacilityEntityList;
	private List<FacilityTypeEntity> upFacilityTypeEntityList;
	private List<ReservationEntity> upReservationEntityList;
	//nullリスト
	private List<FacilityEntity> nullFacilityEntityList;
	private List<FacilityTypeEntity> nullFacilityTypeEntityList;
	private List<ReservationEntity> nullReservationEntityList;

	//テスト用Dto
	private FacilityDto facilityDto;
	private List<FacilityDto> facilityDtoList;
	private FacilityTypeDto facilityTypeDto;
	private List<FacilityTypeDto> facilityTypeDtoList;
	private FacilityReservationDto reservationDto;
	private List<FacilityReservationDto> reservationDtoList;
	//update
	private FacilityDto upFacilityDto;
	private FacilityTypeDto upFacilityTypeDto;
	private List<FacilityDto> upFacilityDtoList;
	private List<FacilityTypeDto> upFacilityTypeDtoList;
	private FacilityReservationDto upReservationDto;
	private List<FacilityReservationDto> upReservationDtoList;
	//UserDto
	private UserDto dto;
	private List<UserDto> userDtoList;
	//managerDto
	private FacilityManagerDto facilityManagerDto;
	private FacilityManagerDto upFacilityManagerDto;
	private FacilityManagerDto opFacilityManagerDto;
	//FacilityReservationDto
	private FacilityReservationManagerDto facilityReservationDto;
	private FacilityReservationManagerDto upFacilityReservationDto;
	private FacilityReservationManagerDto opFacilityReservationDto;

	@Mock
	private FacilityRepository facilityRepository;
	@Mock
	private FacilityTypeRepository facilityTypeRepository;
	@Mock
	private ReservationRepository reservationRepository;
	@Mock
	private UserRepository userRepository;

	//test実施クラス

	@InjectMocks
	@Autowired
	FacilityManagerService service = new FacilityManagerServiceImpl();
	@InjectMocks
	@Autowired
	FacilityReservationManagerService reservationService = new FacilityReservationManagerServiceImpl();

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@BeforeEach
	public void createDate() {
		//UserEntity
		this.userEntity = new UserEntity(u_userId, u_userName, u_password, u_passUpdateDate, u_gender, u_birthday,
				u_contact, u_mailAddress, u_loginMissTimes, u_unlock, u_enabled, u_userDueDate, u_insertDate,
				u_updateDate);
		this.nullUserEntity = new UserEntity();
		//facilityTypeEntity
		this.facilityTypeEntity = new FacilityTypeEntity(ft_facility_type_id, ft_name, ft_insert_date, userEntity,
				ft_update_date, this.userEntity, ft_delete_date, this.userEntity, ft_fgDelete);
		this.nullFacilityTypeEntity = new FacilityTypeEntity();
		this.facilityTypeEntityList = new ArrayList<FacilityTypeEntity>();
		this.facilityTypeEntityList.add(facilityTypeEntity);
		this.nullFacilityTypeEntityList = new ArrayList<FacilityTypeEntity>();

		//facilityEntity
		this.facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity, this.facilityTypeEntity,
				f_insert_date,
				this.userEntity, f_update_date, this.userEntity);
		this.nullFacilityEntity = new FacilityEntity();
		this.facilityEntityList = new ArrayList<FacilityEntity>();
		this.facilityEntityList.add(facilityEntity);
		this.nullFacilityEntityList = new ArrayList<FacilityEntity>();
		//reservationEntity
		this.reservationEntity = new ReservationEntity(m_reservation_id, m_start_time, m_end_time, this.facilityEntity,
				m_insert_date, this.userEntity, m_update_date, this.userEntity);
		this.nullReservationEntity = new ReservationEntity();
		this.reservationEntityList = new ArrayList<ReservationEntity>();
		this.reservationEntityList.add(reservationEntity);
		//update用reeservationEntityList
		this.upReservationEntityList = new ArrayList<ReservationEntity>();
		this.upReservationEntityList.add(reservationEntity);

		//typeDto
		this.facilityTypeDto = new FacilityTypeDto();
		this.facilityTypeDto.setFacilityTypeId(ft_facility_type_id);
		this.facilityTypeDto.setName(ft_name);
		this.facilityTypeDto.setInsertDate(ft_insert_date);
		//typeDtoList
		this.facilityTypeDtoList = new ArrayList<FacilityTypeDto>();
		this.facilityTypeDtoList.add(facilityTypeDto);

		//dto
		this.facilityDto = new FacilityDto();
		this.facilityDto.setCapacity(f_capacity);
		this.facilityDto.setFacilityId(f_facility_id);
		this.facilityDto.setName(f_name);
		this.facilityDto.setFacilityTypeDto(this.facilityTypeDto);

		//dtoList
		this.facilityDtoList = new ArrayList<FacilityDto>();
		this.facilityDtoList.add(facilityDto);

		//UserDto
		this.dto = new UserDto();
		this.dto.setUserId(u_userId);
		this.dto.setUserName(u_userName);
		this.dto.setPassword(u_password);
		this.dto.setPassUpdateDate(u_passUpdateDate);
		this.dto.setGender(u_gender);
		this.dto.setBirthday(u_birthday);
		this.dto.setContact(u_contact);
		this.dto.setMailAddress(u_mailAddress);
		this.dto.setLoginMissTimes(u_loginMissTimes);
		this.dto.setUnlock(u_unlock);
		this.dto.setEnabled(u_enabled);
		this.dto.setUserDueDate(u_userDueDate);
		this.dto.setInsertDate(u_insertDate);
		//ReservationDto

		this.reservationDto = new FacilityReservationDto();
		this.reservationDto.setReservationId(m_reservation_id);
		this.reservationDto.setStartTime(m_start_time);
		this.reservationDto.setEndTime(m_end_time);
		this.reservationDto.setInsertDate(m_insert_date);
		this.reservationDto.setUpdateDate(m_update_date);
		this.reservationDto.setFacilityDto(this.facilityDto);
		this.reservationDto.setUserDto(this.dto);

		//ReservationDtoList
		this.reservationDtoList = new ArrayList<FacilityReservationDto>();
		this.reservationDtoList.add(reservationDto);

		//optimisticRockValue
		this.optimisticRockValue = this.reservationEntity.toString();

		//managerDto
		this.facilityManagerDto = new FacilityManagerDto();
		this.facilityManagerDto.setFacilityDtoList(facilityDtoList);
		this.facilityManagerDto.setFacilityDto(facilityDto);
		this.facilityManagerDto.setFacilityTypeDto(facilityTypeDto);
		this.facilityManagerDto.setFacilityTypeDtoList(facilityTypeDtoList);
		this.facilityManagerDto.setOptimisticRockValue(optimisticRockValue);
		//update用managerDto
		this.upFacilityManagerDto = new FacilityManagerDto();
		this.upFacilityManagerDto.setFacilityDto(upFacilityDto);
		this.upFacilityManagerDto.setFacilityDtoList(upFacilityDtoList);
		this.upFacilityManagerDto.setFacilityTypeDto(upFacilityTypeDto);
		this.upFacilityManagerDto.setFacilityTypeDtoList(upFacilityTypeDtoList);
		this.upFacilityManagerDto.setOptimisticRockValue(upOptimisticRockValue);
		// update(optimisticRockValue)エラー用
		this.opFacilityManagerDto = new FacilityManagerDto();
		this.opFacilityManagerDto.setFacilityDto(facilityDto);
		this.opFacilityManagerDto.setFacilityDtoList(facilityDtoList);
		this.opFacilityManagerDto.setFacilityTypeDto(upFacilityTypeDto);
		this.opFacilityManagerDto.setFacilityTypeDtoList(upFacilityTypeDtoList);
		this.opFacilityManagerDto.setOptimisticRockValue(upOptimisticRockValue);
		//FacilityReservationDto
		this.facilityReservationDto = new FacilityReservationManagerDto();
		this.facilityReservationDto.setFacilityDto(facilityDto);
		this.facilityReservationDto.setFacilityDtoList(facilityDtoList);
		this.facilityReservationDto.setFacilityTypeDtoList(facilityTypeDtoList);
		this.facilityReservationDto.setReservationDtoList(reservationDtoList);
		this.facilityReservationDto.setReservationDto(reservationDto);
		this.facilityReservationDto.setOptimisticRockValue(optimisticRockValue);
		//updateFacilityReservationDto
		this.upFacilityReservationDto = new FacilityReservationManagerDto();
		this.upFacilityReservationDto.setReservationDto(reservationDto);
		this.upFacilityReservationDto.setReservationDtoList(reservationDtoList);
		this.upFacilityReservationDto.setFacilityDto(facilityDto);
		this.upFacilityReservationDto.setFacilityDtoList(facilityDtoList);
		this.upFacilityReservationDto.setFacilityTypeDtoList(facilityTypeDtoList);
		this.upFacilityReservationDto.setOptimisticRockValue(optimisticRockValue);
		//opFacilityReservationDto
		this.opFacilityReservationDto = new FacilityReservationManagerDto();
		this.opFacilityReservationDto.setReservationDto(upReservationDto);
		this.opFacilityReservationDto.setReservationDtoList(upReservationDtoList);
		this.opFacilityReservationDto.setFacilityDto(facilityDto);
		this.opFacilityReservationDto.setFacilityDtoList(facilityDtoList);
		this.opFacilityReservationDto.setReservationDtoList(reservationDtoList);
		this.opFacilityReservationDto.setReservationDto(reservationDto);
		this.opFacilityReservationDto.setOptimisticRockValue(upOptimisticRockValue);
	}

	//findAll ok
	@Test
	public void testGetAll_normal_001() {
		System.out.println("testGetFacilityTypeId_normal_001");

		when(this.facilityRepository.findAll()).thenReturn(this.facilityEntityList);
		when(this.facilityTypeRepository.findAll()).thenReturn(this.facilityTypeEntityList);

		FacilityReservationManagerDto result = reservationService.getFacilityList();
		System.out.println(result);
		assertEquals(1, result.getFacilityDtoList().size());
		assertEquals(f_facility_id, result.getFacilityDtoList().get(0).getFacilityId());
		assertEquals(f_name, result.getFacilityDtoList().get(0).getName());
		assertEquals(f_capacity, result.getFacilityDtoList().get(0).getCapacity());
		assertEquals(ft_facility_type_id, result.getFacilityDtoList().get(0).getFacilityTypeDto().getFacilityTypeId());
		assertEquals(ft_name, result.getFacilityDtoList().get(0).getFacilityTypeDto().getName());

		assertEquals(1,result.getFacilityTypeDtoList().size());
		assertEquals(ft_facility_type_id,result.getFacilityTypeDtoList().get(0).getFacilityTypeId());
		assertEquals(ft_name,result.getFacilityTypeDtoList().get(0).getName());

		verify(this.facilityRepository, times(1)).findAll();
		verify(this.facilityTypeRepository, times(1)).findAll();
	}

	//findAll no
	@Test
	public void testNoAll_normal_001() {
		System.out.println("testGetFacilityTypeId_normal_001");

		when(this.facilityRepository.findAll()).thenReturn(this.nullFacilityEntityList);
		when(this.facilityTypeRepository.findAll()).thenReturn(this.nullFacilityTypeEntityList);

		FacilityReservationManagerDto result = reservationService.getFacilityList();

		assertEquals(0, result.getFacilityDtoList().size());
		assertEquals(0,result.getFacilityTypeDtoList());

		verify(this.facilityRepository, times(1)).findAll();
		verify(this.facilityTypeRepository, times(1)).findAll();
	}

	//findByFacilityTypeId OK
	@Test
	public void testgetFacilityTypeId_normal_001() {
		when(this.facilityRepository.findByFacilityTypeId(ft_facility_type_id)).thenReturn(this.facilityEntityList);

		FacilityReservationManagerDto result = reservationService.getFacilityByFacilityTypeId(ft_facility_type_id);

		assertEquals(1, result.getFacilityDtoList().size());
		assertEquals(f_facility_id, result.getFacilityDtoList().get(0).getFacilityId());
		assertEquals(f_name, result.getFacilityDtoList().get(0).getName());
		assertEquals(f_capacity, result.getFacilityDtoList().get(0).getCapacity());
		assertEquals(ft_facility_type_id, result.getFacilityDtoList().get(0).getFacilityTypeDto().getFacilityTypeId());
		assertEquals(ft_name, result.getFacilityDtoList().get(0).getFacilityTypeDto().getName());

		verify(this.facilityRepository, times(1)).findByFacilityTypeId(ft_facility_type_id);
	}

	//findByFacilityTypeId NO
	@Test
	public void testgetFacilityTypeId_abnormal_001() {
		when(this.facilityRepository.findByFacilityTypeId(ft_facility_type_id)).thenReturn(this.nullFacilityEntityList);

		FacilityReservationManagerDto result = reservationService.getFacilityByFacilityTypeId(ft_facility_type_id);

		assertEquals(0, result.getFacilityDtoList().size());

		verify(this.facilityRepository, times(1)).findByFacilityTypeId(ft_facility_type_id);
	}

	/*
	 * 一覧画面までのテスト↑
	 * -----------------------------------------------------------------------------------------------------------
	 * カレンダー以降のテスト↴
	 */

	//主キー検索だからreservationIdだけじゃなくて、テーブルの題名すべてを検索する
	@Test
	public void testGetFindOneById() {

		when(this.reservationRepository.findOneById(this.reservationEntity)).thenReturn(this.reservationEntity);

		FacilityReservationManagerDto result = reservationService.getfindOneById(this.reservationEntity);
		System.out.println(result);

		assertEquals(m_reservation_id, result.getReservationDto().getReservationId());
		assertEquals(f_facility_id, result.getReservationDto().getFacilityDto().getFacilityId());
		assertEquals(f_name, result.getReservationDto().getFacilityDto().getName());
		assertEquals(m_start_time, result.getReservationDto().getStartTime());
		assertEquals(m_end_time, result.getReservationDto().getEndTime());
		assertEquals(u_userId, result.getReservationDto().getUserDto().getUserId());

		verify(this.reservationRepository, times(1)).findOneById(this.reservationEntity);
	}

	@Test
	public void testNoGetfindOneById() {

		FacilityReservationManagerDto result = reservationService.getReservationId(nullReservationEntity);

		assertEquals(0, result.getReservationDto().getReservationId());
	}

	@Test
	public void testfindByFacilityIdAndStartDateBetween() {

		FacilityReservationManagerDto result = reservationService.getFacilityIdAndStartDateBetween(f_facility_id,
				m_start_time,
				m_end_time);
		System.out.println("oioi" + reservationDtoList.get(0).getEndTime());
		//処理成功でいい　持ってくるわけではない
		assertEquals(ServiceConst.OK, result.getResult());

	}

	@Test
	public void testNoFindByFacilityIdAndStartDateBetween() {
		FacilityReservationManagerDto result = reservationService.getFacilityIdAndStartDateBetween(f_null_facility_id,
				m_null_start_time, m_null_end_time);
		//値が入ってなくても持っては来る
		assertEquals(ServiceConst.OK, result.getResult());
	}
	//canMakeは無視

	@Test
	public void testAdd() {

		when(this.reservationRepository.insert(any())).thenReturn(1);
		System.out.println(this.facilityReservationDto);

		//nullPointerException（nullじゃできないですメッセージ）だったけどUserDtoをわざわざ値で入れたら直った
		FacilityReservationManagerDto result = reservationService.add(this.facilityReservationDto);

		assertEquals(ServiceConst.THERE_IS_DATA, result.getResult());

		verify(this.reservationRepository, times(1)).insert(any());
	}

	@Test
	public void testNoAdd() {
		when(this.reservationRepository.insert(any())).thenReturn(0);

		FacilityReservationManagerDto result = reservationService.add(this.facilityReservationDto);

		assertEquals(ServiceConst.NO_DATA, result.getResult());

		verify(this.reservationRepository, times(1)).insert(any());
	}

	@Test
	public void testUpdate() {
		when(this.reservationRepository.findOneById(any())).thenReturn(this.reservationEntity);

		when(this.reservationRepository.update(any())).thenReturn(1);

		FacilityReservationManagerDto result = reservationService.update(this.upFacilityReservationDto);
		//楽観ロックになった
		assertEquals(ServiceConst.OK, result.getResult());

		verify(this.reservationRepository, times(1)).findOneById(any());
		verify(this.reservationRepository, times(1)).update(any());
	}

	@Test
	public void testNoUpdate() {
		when(this.reservationRepository.findOneById(any())).thenReturn(this.reservationEntity);

		when(this.reservationRepository.update(any())).thenReturn(1);

		FacilityReservationManagerDto result = reservationService.update(this.opFacilityReservationDto);

		assertEquals(ServiceConst.OPTIMISTIC_ROCK_ERROR, result.getResult());

		verify(this.reservationRepository, times(1)).findOneById(any());
		//optimisticでupdateしてないからupdateの回数はいらない
	}

	@Test
	public void testDelete() {
		when(this.reservationRepository.delete(this.facilityReservationDto.getReservationDto().getReservationId()))
				.thenReturn(1);

		FacilityReservationManagerDto result = reservationService.delete(this.facilityReservationDto);

		assertEquals(ServiceConst.OK, result.getResult());

		verify(this.reservationRepository, times(1))
				.delete(this.facilityReservationDto.getReservationDto().getReservationId());
	}

	@Test
	public void testNoData() {
		when(this.reservationRepository.delete(this.facilityReservationDto.getReservationDto().getReservationId()))
				.thenReturn(0);

		FacilityReservationManagerDto result = reservationService.delete(this.facilityReservationDto);

		assertEquals(ServiceConst.ERROR, result.getResult());

		verify(this.reservationRepository, times(1))
				.delete(this.facilityReservationDto.getReservationDto().getReservationId());
	}
}
