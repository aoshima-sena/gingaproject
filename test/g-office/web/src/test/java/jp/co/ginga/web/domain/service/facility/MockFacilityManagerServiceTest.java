package jp.co.ginga.web.domain.service.facility;

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
import jp.co.ginga.infra.repository.user.UserEntity;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerService;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerServiceImpl;
import jp.co.ginga.web.domain.service.util.constant.ServiceConst;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MockFacilityManagerServiceTest {

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
	private Date ft_insert_date = new Date(System.currentTimeMillis());
	private UserEntity ft_user_id = null;
	private Date ft_update_date = null;
	private UserEntity ft_update_user_id = null;
	private Date ft_delete_date = null;
	private UserEntity ft_delete_user_id = null;
	private boolean ft_fgDelete = true;
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

	private String optimisticRockValue = null;

	//null用
	private String upOptimisticRockValue = null;

	//test用Entity
	private FacilityEntity facilityEntity;
	private FacilityEntity nullFacilityEntity;
	private FacilityTypeEntity facilityTypeEntity;
	private UserEntity userEntity;
	private List<FacilityEntity> facilityEntityList;
	private List<FacilityTypeEntity> facilityTypeEntityList;
	private List<UserEntity> UserEntityList;
	private List<FacilityEntity> noFacilityEntityList;

	//nullリスト用
	private List<FacilityEntity> nullFacilityEntityList;
	private List<FacilityTypeEntity> nullFacilityTypeEntityList;
	private List<UserEntity> nullUserEntityList;

	//updateリスト用
	private List<FacilityEntity> upFacilityEntityList;
	private List<FacilityTypeEntity> upFacilityTypeEntityList;
	private List<UserEntity> upUserEntityList;

	//テスト用Dto
	private FacilityDto facilityDto;
	private List<FacilityDto> facilityDtoList;
	private FacilityTypeDto facilityTypeDto;
	private List<FacilityTypeDto> facilityTypeDtoList;
	private UserDto userDto;
	private List<UserDto> userDtoList;

	//update用Dto
	private FacilityDto upFacilityDto;
	private List<FacilityDto> upFacilityDtoList;
	private FacilityTypeDto upFacilityTypeDto;
	private List<FacilityTypeDto> upFacilityTypeDtoList;
	private UserDto upUserDto;
	private List<UserDto> upUserDtoList;

	//managerDto
	private FacilityManagerDto facilityManagerDto;
	private FacilityManagerDto upFacilityManagerDto;
	private FacilityManagerDto opFacilityManagerDto;

	//mock化(test実施クラス*serviceクラスに注入するためにモック化する(インジェクションできるようにする。))
	@Mock
	private FacilityRepository facilityRepository;
	@Mock
	private FacilityTypeRepository facilityTypeRepository;
	@Mock
	private FacilityManagerHelper facilityManagerHelper;

	//テスト実施クラス
	@InjectMocks
	@Autowired
	FacilityManagerService service = new FacilityManagerServiceImpl();
	@InjectMocks
	@Autowired
	FacilityTypeManagerService TypeService = new FacilityTypeManagerServiceImpl();

	//上記のmockからinject での注入処理をMockitoAnnotations.openMocksで行う

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@BeforeEach
	public void createDate() {
		//FacilityTypeEntity
		this.facilityTypeEntity = new FacilityTypeEntity(ft_facility_type_id, ft_name, ft_insert_date, ft_user_id,
				ft_update_date, ft_update_user_id, ft_delete_date, ft_delete_user_id, ft_fgDelete);
		this.facilityTypeEntityList = new ArrayList<FacilityTypeEntity>();
		this.facilityTypeEntityList.add(facilityTypeEntity);
		this.nullFacilityTypeEntityList = new ArrayList<FacilityTypeEntity>();
		//FacilityEntity
		this.facilityEntity = new FacilityEntity(f_facility_id, f_name, f_capacity, facilityTypeEntity, f_insert_date,
				f_update_user_id, f_update_date, f_user_id);
		this.nullFacilityEntity = new FacilityEntity();
		this.facilityEntityList = new ArrayList<FacilityEntity>();
		this.facilityEntityList.add(facilityEntity);
		this.noFacilityEntityList = new ArrayList<FacilityEntity>();
		this.nullFacilityEntityList = null;

		//UserEntity
		this.userEntity = new UserEntity(u_userId, u_userName, u_birthday, u_insertDate, u_contact, u_gender,
				u_mailAddress, u_password, u_loginMissTimes, u_enabled, u_unlock, u_passUpdateDate, u_updateDate,
				u_userDueDate);
		this.UserEntityList = new ArrayList<UserEntity>();
		this.UserEntityList.add(userEntity);
		this.nullUserEntityList = new ArrayList<UserEntity>();
		//optimistic
		this.optimisticRockValue = facilityEntity.toString();

		//userDto
		this.userDto = new UserDto();
		this.userDto.setUserId(u_userId);
		this.userDto.setUserName(u_userName);
		this.userDto.setPassword(u_password);
		this.userDto.setPassUpdateDate(u_passUpdateDate);
		this.userDto.setGender(u_gender);
		this.userDto.setBirthday(u_birthday);
		this.userDto.setContact(u_contact);
		this.userDto.setMailAddress(u_mailAddress);
		this.userDto.setLoginMissTimes(u_loginMissTimes);
		this.userDto.setUnlock(u_unlock);
		this.userDto.setEnabled(u_enabled);
		this.userDto.setUserDueDate(u_userDueDate);
		this.userDto.setInsertDate(u_insertDate);

		//typeDto
		this.facilityTypeDto = new FacilityTypeDto();
		this.facilityTypeDto.setFacilityTypeId(ft_facility_type_id);
		this.facilityTypeDto.setName(ft_name);
		this.facilityTypeDto.setInsertDate(ft_insert_date);
		this.facilityTypeDto.setInsertUserDto(userDto);
		//typeDtoList
		this.facilityTypeDtoList = new ArrayList<FacilityTypeDto>();
		this.facilityTypeDtoList.add(facilityTypeDto);
		//dto
		this.facilityDto = new FacilityDto();
		this.facilityDto.setCapacity(f_capacity);
		this.facilityDto.setFacilityId(f_facility_id);
		this.facilityDto.setName(f_name);
		this.facilityDto.setUserDto(userDto);
		this.facilityDto.setFacilityTypeDto(facilityTypeDto);
		//dtoList
		this.facilityDtoList = new ArrayList<FacilityDto>();
		this.facilityDtoList.add(facilityDto);

		//managerDto
		this.facilityManagerDto = new FacilityManagerDto();
		this.facilityManagerDto.setFacilityDto(facilityDto);
		this.facilityManagerDto.setFacilityDtoList(facilityDtoList);
		this.facilityManagerDto.setFacilityTypeDto(facilityTypeDto);
		this.facilityManagerDto.setFacilityTypeDtoList(facilityTypeDtoList);
		this.facilityManagerDto.setOptimisticRockValue(optimisticRockValue);
		//update用managerDto
		this.upFacilityManagerDto = new FacilityManagerDto();
		this.upFacilityManagerDto.setFacilityDto(facilityDto);
		this.upFacilityManagerDto.setFacilityDtoList(facilityDtoList);
		this.upFacilityManagerDto.setFacilityTypeDto(facilityTypeDto);
		this.upFacilityManagerDto.setFacilityTypeDtoList(facilityTypeDtoList);
		this.upFacilityManagerDto.setOptimisticRockValue(optimisticRockValue);

		//optimistic用
		this.opFacilityManagerDto = new FacilityManagerDto();
		this.opFacilityManagerDto.setFacilityDto(facilityDto);
		this.opFacilityManagerDto.setFacilityDtoList(facilityDtoList);
		this.opFacilityManagerDto.setFacilityTypeDto(facilityTypeDto);
		this.opFacilityManagerDto.setFacilityTypeDtoList(facilityTypeDtoList);
		this.opFacilityManagerDto.setOptimisticRockValue(upOptimisticRockValue);

	}

	//送信メッセージのテスト(オブジェクトが副作用のあるメッセージを送信するとき適切な引数、回数を送信しているか)
	//メッセージの受け手を偽物にしてこの偽物に検証させる。
	//引数、回数の検証
	@Test
	public void testGetFacilityListOK() {
		when(this.facilityRepository.findAll()).thenReturn(this.facilityEntityList);
	//	when(this.facilityManagerHelper.createFacilityServiceDto(this.facilityEntityList)).thenReturn(this.facilityManagerDto);

		FacilityManagerDto result = service.getFacilityList();

		assertEquals(1, result.getFacilityDtoList().size());
		assertEquals(f_facility_id, result.getFacilityDtoList().get(0).getFacilityId());
		assertEquals(f_name, result.getFacilityDtoList().get(0).getName());
		assertEquals(f_capacity, result.getFacilityDtoList().get(0).getCapacity());
		//nullの場合は持ってこないことになってるから下のテストは持ってこない処理になる(facilityDtoHelperを参照)
		assertEquals(ft_facility_type_id, result.getFacilityDtoList().get(0).getFacilityTypeDto().getFacilityTypeId());
		assertEquals(ft_name, result.getFacilityDtoList().get(0).getName());
		verify(this.facilityRepository, times(1)).findAll();
	}

	//list０の場合
	@Test
	public void testGetFacilityListNo() {
		when(this.facilityRepository.findAll()).thenReturn(this.noFacilityEntityList);

		FacilityManagerDto result = service.getFacilityList();

		assertEquals(0, result.getFacilityDtoList().size());
		verify(this.facilityRepository, times(1)).findAll();
	}

	//findOneById OK
	@Test
	public void testFindOneByIdOK() {
		when(this.facilityRepository.findByFacilityId(f_facility_id)).thenReturn(this.facilityEntity);
		when(this.facilityTypeRepository.findAll()).thenReturn(this.facilityTypeEntityList);

		FacilityManagerDto result = service.getFacilityDetailByFacilityId(f_facility_id);

		assertEquals(f_facility_id, result.getFacilityDto().getFacilityId());
		assertEquals(f_name, result.getFacilityDto().getName());
		assertEquals(f_capacity, result.getFacilityDto().getCapacity());
		//f_facility_type_idはnullだからテストしない
		//	assertEquals(f_facility_type_id, result.getFacilityDto().getFacilityTypeDto().getFacilityTypeId());
		assertEquals(ft_facility_type_id, result.getFacilityTypeDtoList().get(0).getFacilityTypeId());

		verify(this.facilityRepository, times(1)).findByFacilityId(f_facility_id);
		verify(this.facilityTypeRepository, times(1)).findAll();
	}

	//findOneById NO
	@Test
	public void testGetFindOneByIdNO() {
		when(this.facilityRepository.findByFacilityId(f_facility_id)).thenReturn(this.nullFacilityEntity);
		when(this.facilityTypeRepository.findAll()).thenReturn(this.nullFacilityTypeEntityList);

		FacilityManagerDto result = service.getFacilityDetailByFacilityId(f_facility_id);

		//intはasserEqulas,stringはasserNull
		assertEquals(0, result.getFacilityDto().getFacilityId());
		assertNull(result.getFacilityDto().getName());
		assertEquals(0, result.getFacilityDto().getCapacity());
		assertEquals(0, result.getFacilityTypeDtoList().size());

		verify(this.facilityRepository, times(1)).findByFacilityId(f_facility_id);
		verify(this.facilityTypeRepository, times(1)).findAll();
	}

	//findByName
	@Test
	public void testFindByNameOK() {
		when(this.facilityRepository.findByName(f_name)).thenReturn(this.facilityEntityList);

		FacilityManagerDto result = service.getFacilityByName(f_name);

		assertEquals(ServiceConst.THERE_IS_DATA, result.getResult());
		assertEquals(f_name, result.getFacilityDtoList().get(0).getName());

		verify(this.facilityRepository, times(1)).findByName(f_name);
	}

	//findByName NO
	@Test
	public void testFindByNameNo() {
		when(this.facilityRepository.findByName(f_name)).thenReturn(this.noFacilityEntityList);

		FacilityManagerDto result = service.getFacilityByName(f_name);

		assertEquals(ServiceConst.NO_DATA, result.getResult());
		assertEquals(0, result.getFacilityDtoList().size());

		verify(this.facilityRepository, times(1)).findByName(f_name);
	}

	@Test
	public void testFindByNameERROR() {
		when(this.facilityRepository.findByName(f_name)).thenReturn(this.nullFacilityEntityList);

		FacilityManagerDto result = service.getFacilityByName(f_name);

		assertEquals(ServiceConst.ERROR, result.getResult());
		verify(this.facilityRepository, times(1)).findByName(f_name);
	}

	//add OK
	@Test
	public void testAddOK() {
		//どんな値が入っても1を返す
		when(this.facilityRepository.insert(any())).thenReturn(1);

		FacilityManagerDto result = service.add(this.facilityManagerDto);

		assertEquals(ServiceConst.THERE_IS_DATA, result.getResult());

		verify(this.facilityRepository, times(1)).insert(any());
	}

	//add NO
	@Test
	public void testAddNO() {
		when(this.facilityRepository.insert(any())).thenReturn(0);

		FacilityManagerDto result = service.add(this.facilityManagerDto);

		assertEquals(ServiceConst.NO_DATA, result.getResult());

		verify(this.facilityRepository, times(1)).insert(any());
	}

	//ERROR
	//いらなくね？
	/*	@Test
		public void testAddError() {
			when(this.facilityRepository.insert(any())).thenReturn(2);

			FacilityManagerDto result = service.add(this.facilityManagerDto);

			assertEquals(ServiceConst.ERROR, result.getResult());

			verify(this.facilityRepository, times(1)).insert(any());
		}*/

	//update OK
	@Test
	public void updateOK() {
		when(this.facilityRepository.findByFacilityId(this.upFacilityManagerDto.getFacilityDto().getFacilityId()))
				.thenReturn(this.facilityEntity);
		when(this.facilityRepository.update(any())).thenReturn(1);


		FacilityManagerDto result = service.update(this.upFacilityManagerDto);

		assertEquals(ServiceConst.OK, result.getResult());

		verify(this.facilityRepository, times(1)).update(any());
		verify(this.facilityRepository, times(1))
				.findByFacilityId(this.upFacilityManagerDto.getFacilityDto().getFacilityId());

	}

	//update NO
	@Test
	public void updateNO() {
		when(this.facilityRepository.findByFacilityId(this.upFacilityManagerDto.getFacilityDto().getFacilityId()))
				.thenReturn(this.facilityEntity);
		when(this.facilityRepository.update(any())).thenReturn(0);

		FacilityManagerDto result = service.update(this.upFacilityManagerDto);

		assertEquals(ServiceConst.ERROR, result.getResult());

		verify(this.facilityRepository, times(1))
				.findByFacilityId(this.upFacilityManagerDto.getFacilityDto().getFacilityId());
		verify(this.facilityRepository, times(1)).update(any());
	}

	//これもいらなくね？
	/*	@Test
		public void updateNO2() {
			when(this.facilityRepository.findByFacilityId(this.upFacilityManagerDto.getFacilityDto().getFacilityId()))
					.thenReturn(this.facilityEntity);
			when(this.facilityRepository.update(any())).thenReturn(2);

			FacilityManagerDto result = service.update(this.upFacilityManagerDto);

			assertEquals(ServiceConst.ERROR, result.getResult());

			verify(this.facilityRepository, times(1))
					.findByFacilityId(this.upFacilityManagerDto.getFacilityDto().getFacilityId());
			verify(this.facilityRepository, times(1)).update(any());
		}*/

	//optimistic
	@Test
	public void updateOptimistic() {
		when(this.facilityRepository.findByFacilityId(this.upFacilityManagerDto.getFacilityDto().getFacilityId()))
				.thenReturn(this.facilityEntity);
	//	when(this.facilityRepository.update(any())).thenReturn(0);

		FacilityManagerDto result = service.update(this.opFacilityManagerDto);

		assertEquals(ServiceConst.OPTIMISTIC_ROCK_ERROR, result.getResult());

		//楽観的ロックがかかったからupdateができない(書かなくていい)↓
		//	verify(this.facilityRepository, times(1)).update(any());
		verify(this.facilityRepository, times(1))
				.findByFacilityId(this.upFacilityManagerDto.getFacilityDto().getFacilityId());
	}

	//delete OK
	@Test
	public void testDeleteOK() {
		when(this.facilityRepository.delete(this.facilityManagerDto.getFacilityDto().getFacilityId())).thenReturn(1);

		FacilityManagerDto result = service.delete(this.facilityManagerDto);

		assertEquals(ServiceConst.OK, result.getResult());

		verify(this.facilityRepository, times(1)).delete(this.facilityManagerDto.getFacilityDto().getFacilityId());
	}

	//delete NO
	@Test
	public void testDeleteNO() {
		when(this.facilityRepository.delete(this.facilityManagerDto.getFacilityDto().getFacilityId())).thenReturn(0);

		FacilityManagerDto result = service.delete(this.facilityManagerDto);

		assertEquals(ServiceConst.ERROR, result.getResult());

		verify(this.facilityRepository, times(1)).delete(this.facilityManagerDto.getFacilityDto().getFacilityId());
	}

}
