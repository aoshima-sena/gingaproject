package jp.co.ginga.web.domain.service.facilitytype;

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

import jp.co.ginga.infra.repository.facility.FacilityRepository;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeRepository;
import jp.co.ginga.infra.repository.user.UserEntity;
import jp.co.ginga.web.domain.service.util.constant.ServiceConst;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import jp.co.ginga.web.domain.service.util.dto.role.RoleDto;
import jp.co.ginga.web.domain.service.util.dto.user.UserDto;
import jp.co.ginga.web.domain.service.util.dto.userrole.UserRoleDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MockFacilityTypeManagerServiceTest {

	private int ft_facility_type_id = 1;
	private String ft_name = "会議室";
	private Date ft_insert_date = null;
	private UserEntity ft_user_id = null;
	private Date ft_update_date = new Date(System.currentTimeMillis());
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
	private String optimisticRockValue = null;//ft_facility_type_id+","+ft_name+","+ft_insert_date+","+ft_user_id+","+ft_update_date+","+ft_update_user_id+","+ft_delete_date+","+ft_delete_user_id;

	//更新用
	private String upOptimisticRockValue = null;
	private int up_ft_facility_type_id2 = 2;
	private String up_ft_name2 = "会議室2";
	private Date up_ft_insert_date = null;
	private UserEntity up_ft_user_id = null;
	private Date up_ft_update_date = new Date(System.currentTimeMillis());
	private UserEntity up_ft_update_user_id = null;
	private Date up_ft_delete_date = null;
	private UserEntity up_ft_delete_user_id = null;
	private boolean up_ft_fgDelete = true;
	private int up_ft_facility_type_id3 = 3;
	private String up_ft_name3 = "会議室3";
	private String r_roleId = "tests";
	private String r_roleName = "ROLE_Test";
	private String ur_userId = "test";
	private String ur_roleId = "tests";
	private String ur_userId2 = "test";
	private String ur_roleId2 = "tests2";

	//test用Entity
	private FacilityTypeEntity facilityTypeEntity;
	private FacilityTypeEntity nullFacilityTypeEntity;
	//	private FacilityTypeEntity updateFacilityTypeEntity;
	private List<FacilityTypeEntity> facilityTypeEntityList;
	//	private List<FacilityTypeEntity> updateFacilityTypeEntityList;
	private List<FacilityTypeEntity> nullFacilityTypeEntityList;

	//test用Dto

	private FacilityTypeDto facilityTypeDto;
	private List<FacilityTypeDto> facilityTypeDtoList;
	//update用facilityTypeDto
	private FacilityTypeDto updateFacilityTypeDto;
	//update用facilityTypeDtoList
	private List<FacilityTypeDto> updateFacilityTypeDtoList;
	private List<RoleDto> roleDtoList;
	private List<UserRoleDto> userRoleDtoList;
	private List<RoleDto> updateDtoList;
	private List<UserRoleDto> updateRoleDtoList;
	private UserDto userDto;
	private List<UserDto> userDtoList;
	private RoleDto roleDto;
	private UserRoleDto userRoleDto;
	private UserRoleDto updateUserRoleDto;

	//test用ManagerDto

	private FacilityTypeManagerDto facilityTypeManagerDto;
	private FacilityTypeManagerDto updateFacilityTypeManagerDto;
	//optimisticValue
	private FacilityTypeManagerDto optFacilityTypeManagerDto;

	@Mock
	private FacilityTypeRepository facilityTypeRepository;
	@Mock
	private FacilityRepository facilityRepository;

	//test実施クラス
	@InjectMocks
	@Autowired
	FacilityTypeManagerService service = new FacilityTypeManagerServiceImpl();

	//宣言したインスタンスを初期化してMock化
	//@Test, @RepeatedTest, @ParameterizedTest, @TestFactory)が実行される前(before)に実行されるメソッドを意味します↓

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@BeforeEach
	public void createData() {
		//entity
		this.facilityTypeEntity = new FacilityTypeEntity(ft_facility_type_id, ft_name, ft_insert_date, ft_user_id,
				ft_update_date, ft_update_user_id, ft_delete_date, ft_delete_user_id, ft_fgDelete);
		this.nullFacilityTypeEntity = new FacilityTypeEntity();
		//	this.updateFacilityTypeEntity = new FacilityTypeEntity(up_ft_facility_type_id2, up_ft_name2, up_ft_insert_date,
		//			up_ft_user_id, up_ft_update_date, up_ft_update_user_id, up_ft_delete_date, up_ft_delete_user_id,
		//			up_ft_fgDelete);
		this.facilityTypeEntityList = new ArrayList<FacilityTypeEntity>();
		this.facilityTypeEntityList.add(facilityTypeEntity);
		this.nullFacilityTypeEntityList = new ArrayList<FacilityTypeEntity>();
		//Dto
		this.facilityTypeDto = new FacilityTypeDto();
		this.facilityTypeDto.setFacilityTypeId(ft_facility_type_id);
		this.facilityTypeDto.setName(ft_name);
		this.facilityTypeDto.setInsertDate(ft_insert_date);

		//roleDto
		this.roleDto = new RoleDto();
		this.roleDto.setRoleId(r_roleId);
		this.roleDto.setRoleName(r_roleName);
		//roleDtoList
		this.roleDtoList = new ArrayList<RoleDto>();
		this.roleDtoList.add(roleDto);

		this.facilityTypeDtoList = new ArrayList<FacilityTypeDto>();
		this.facilityTypeDtoList.add(facilityTypeDto);
		//update用Dto
		this.updateFacilityTypeDto = new FacilityTypeDto();
		this.updateFacilityTypeDto.setFacilityTypeId(up_ft_facility_type_id2);
		this.updateFacilityTypeDto.setFacilityTypeId(up_ft_facility_type_id3);

		this.updateFacilityTypeDtoList = new ArrayList<FacilityTypeDto>();
		this.updateFacilityTypeDtoList.add(updateFacilityTypeDto);

		this.userRoleDto = new UserRoleDto();
		this.userRoleDto.setRoleId(ur_roleId);
		this.userRoleDto.setUserId(ur_userId);

		this.updateDtoList = new ArrayList<RoleDto>();
		this.updateDtoList.add(roleDto);

		this.updateRoleDtoList = new ArrayList<UserRoleDto>();
		this.updateRoleDtoList.add(userRoleDto);

		this.updateUserRoleDto = new UserRoleDto();
		this.updateUserRoleDto.setRoleId(ur_roleId2);
		this.updateUserRoleDto.setUserId(ur_userId2);

		this.userRoleDtoList = new ArrayList<UserRoleDto>();
		this.userRoleDtoList.add(userRoleDto);
		this.userRoleDtoList.add(updateUserRoleDto);

		this.optimisticRockValue = this.facilityTypeEntity.toString();

		//ManagerDto
		this.facilityTypeManagerDto = new FacilityTypeManagerDto();
		this.facilityTypeManagerDto.setFacilityTypeDto(facilityTypeDto);
		this.facilityTypeManagerDto.setFacilityTypeDtoList(facilityTypeDtoList);
		this.facilityTypeManagerDto.setRoleDtoList(roleDtoList);
		this.facilityTypeManagerDto.setUserRoleDtoList(userRoleDtoList);
		this.facilityTypeManagerDto.setOptimisticRockValue(optimisticRockValue);

		//update用ManagerDto
		this.updateFacilityTypeManagerDto = new FacilityTypeManagerDto();
		this.updateFacilityTypeManagerDto.setFacilityTypeDto(facilityTypeDto);
		this.updateFacilityTypeManagerDto.setFacilityTypeDtoList(facilityTypeDtoList);
		this.updateFacilityTypeManagerDto.setRoleDtoList(roleDtoList);
		this.updateFacilityTypeManagerDto.setUserRoleDtoList(userRoleDtoList);
		this.updateFacilityTypeManagerDto.setOptimisticRockValue(optimisticRockValue);

		//update(optimisticRockValue)エラー用
		this.optFacilityTypeManagerDto = new FacilityTypeManagerDto();
		this.optFacilityTypeManagerDto.setFacilityTypeDto(facilityTypeDto);
		this.optFacilityTypeManagerDto.setFacilityTypeDtoList(facilityTypeDtoList);
		this.optFacilityTypeManagerDto.setRoleDtoList(roleDtoList);
		this.optFacilityTypeManagerDto.setUserRoleDtoList(updateRoleDtoList);
		this.optFacilityTypeManagerDto.setOptimisticRockValue(upOptimisticRockValue);

	}

	//list正常系
	@Test
	public void testGetFacilityTypeList_normal_001() {
		System.out.println("testGetFacilityTypeList_normal_001");

		when(this.facilityTypeRepository.findAll()).thenReturn(this.facilityTypeEntityList);

		FacilityTypeManagerDto result = service.getFacilityTypeList();

		assertEquals(ft_facility_type_id, result.getFacilityTypeDtoList().get(0).getFacilityTypeId());
		assertEquals(ft_name, result.getFacilityTypeDtoList().get(0).getName());
		assertEquals(ft_insert_date, result.getFacilityTypeDtoList().get(0).getInsertDate());
		assertEquals(ft_user_id, result.getFacilityTypeDtoList().get(0).getInsertUserDto());

		verify(this.facilityTypeRepository, times(1)).findAll();
	}

	//listサイズ０
	@Test
	public void testGetFacilityTypeList_normal_002() {
		System.out.println("testGetFacilityTypeList_normal_002");

		when(this.facilityTypeRepository.findAll()).thenReturn(this.nullFacilityTypeEntityList);

		FacilityTypeManagerDto result = service.getFacilityTypeList();

		assertEquals(0, result.getFacilityTypeDtoList().size());

		verify(this.facilityTypeRepository, times(1)).findAll();
	}

	//getFacilityTypeDetailByFacilityTypeId データあり

	@Test
	public void testGetFacilityTypeDetailByFacilityTypeId_normal_001() {
		System.out.println("testGetFacilityTypeDetailByFacilityTypeId_normal_001");

		when(this.facilityTypeRepository.findOneById(ft_facility_type_id)).thenReturn(this.facilityTypeEntity);

		FacilityTypeManagerDto result = service.getFacilityTypeDetailByFacilityTypeId(ft_facility_type_id);

		assertEquals(ft_facility_type_id, result.getFacilityTypeDto().getFacilityTypeId());
		assertEquals(ft_name, result.getFacilityTypeDto().getName());

		verify(this.facilityTypeRepository, times(1)).findOneById(ft_facility_type_id);
	}

	//facilityTypeId データなし
	@Test
	public void testNoGetFacilityTypeId_normal_2() {
		System.out.println("testNoGetFacilityTypeId_normal_2");

		when(this.facilityTypeRepository.findOneById(ft_facility_type_id)).thenReturn(this.nullFacilityTypeEntity);

		FacilityTypeManagerDto result = service.getFacilityTypeDetailByFacilityTypeId(ft_facility_type_id);

		assertEquals(0, result.getFacilityTypeDtoList().size());

		verify(this.facilityTypeRepository, times(1)).findOneById(ft_facility_type_id);

	}

	//name 検索処理
	@Test
	public void testGetFacilityTypeName_normal_001() {
		System.out.println("testGetFacilityTypeName_normal_001");

		when(this.facilityTypeRepository.findByTypeName(ft_name)).thenReturn(this.facilityTypeEntityList);

		FacilityTypeManagerDto result = service.getFacilityTypeByName(ft_name);

		assertEquals(ServiceConst.THERE_IS_DATA, result.getResult());
		assertEquals(ft_name, result.getFacilityTypeDtoList().get(0).getName());

		verify(this.facilityTypeRepository, times(1)).findByTypeName(ft_name);
	}

	//name データなし
	@Test
	public void testNoGetFacilityTypeName_normal_002() {
		System.out.println("testNoGetFacilityTypeName_normal_002");

		when(this.facilityTypeRepository.findByTypeName(ft_name)).thenReturn(nullFacilityTypeEntityList);

		FacilityTypeManagerDto result = service.getFacilityTypeByName(ft_name);

		assertEquals(0, result.getFacilityTypeDtoList().size());

		assertEquals(ServiceConst.NO_DATA, result.getResult());

		verify(this.facilityTypeRepository, times(1)).findByTypeName(ft_name);
	}

	//add

	@Test
	public void testAdd_normal_001() {
		System.out.println("testAdd_normal_001");

		when(this.facilityTypeRepository.insert(any())).thenReturn(1);

		FacilityTypeManagerDto result = service.add(this.facilityTypeManagerDto);

		assertEquals(ServiceConst.THERE_IS_DATA, result.getResult());

		verify(this.facilityTypeRepository, times(1)).insert(any());

	}

	//add データがなかった時

	@Test
	public void testAdd_abnormal_002() {
		System.out.println("testAdd_abnormal_002");

		when(this.facilityTypeRepository.insert(any())).thenReturn(2);

		FacilityTypeManagerDto result = service.add(this.facilityTypeManagerDto);

		assertEquals(ServiceConst.NO_DATA, result.getResult());

		verify(this.facilityTypeRepository, times(1)).insert(any());
	}

	//update データあり なんかおかしい
	@Test
	public void testUpdate_normal_001() {
		System.out.println("testUpdate_normal_001");

		when(this.facilityTypeRepository
				.findOneById(this.updateFacilityTypeManagerDto.getFacilityTypeDto().getFacilityTypeId()))
						.thenReturn(this.facilityTypeEntity);
		//	when(this.facilityTypeRepository
		//			.findOneById(this.updateFacilityTypeManagerDto.getFacilityTypeDto().getFacilityTypeId()))
		//					.thenReturn(this.facilityTypeEntity);
		when(this.facilityTypeRepository.update(any())).thenReturn(1);
		when(this.facilityTypeRepository.insert(any())).thenReturn(1);

		FacilityTypeManagerDto result = service.update(this.updateFacilityTypeManagerDto);

		assertEquals(ServiceConst.OK, result.getResult());

		verify(this.facilityTypeRepository, times(1)).update(any());
		verify(this.facilityTypeRepository, times(1))
				.findOneById(this.updateFacilityTypeManagerDto.getFacilityTypeDto().getFacilityTypeId());
	}

	//データなし

	@Test
	public void testUpdate_abnormal_001() {
		System.out.println("testUpdate_abnormal_001");

		when(this.facilityTypeRepository
				.findOneById(this.facilityTypeManagerDto.getFacilityTypeDto().getFacilityTypeId()))
						.thenReturn(this.facilityTypeEntity);
		when(this.facilityTypeRepository.update(any())).thenReturn(1);

		FacilityTypeManagerDto result = service.update(this.optFacilityTypeManagerDto);

		assertEquals(ServiceConst.OPTIMISTIC_ROCK_ERROR, result.getResult());

		verify(this.facilityTypeRepository, times(1))
				.findOneById(this.facilityTypeManagerDto.getFacilityTypeDto().getFacilityTypeId());

	}

	//result異常 なんかおかしい
	@Test
	public void testUpdate_abnormal_003() {
		System.out.println("testUpdate_abnormal_003");

		when(this.facilityTypeRepository
				.findOneById(this.updateFacilityTypeManagerDto.getFacilityTypeDto().getFacilityTypeId()))
						.thenReturn(this.facilityTypeEntity);
		//	when(this.facilityTypeRepository.update(any())).thenReturn(0);

		FacilityTypeManagerDto result = service.update(this.updateFacilityTypeManagerDto);

		assertEquals(ServiceConst.ERROR, result.getResult());

		verify(this.facilityTypeRepository, times(1))
				.findOneById(this.updateFacilityTypeManagerDto.getFacilityTypeDto().getFacilityTypeId());

	}

	//これもおかしい

	@Test
	public void testUpdate_abnormal_004() {
		System.out.println("testUpdate_abnormal_004");

		when(this.facilityTypeRepository
				.findOneById(this.updateFacilityTypeManagerDto.getFacilityTypeDto().getFacilityTypeId()))
						.thenReturn(this.facilityTypeEntity);
		when(this.facilityTypeRepository.update(any())).thenReturn(2);

		FacilityTypeManagerDto result = service.update(this.updateFacilityTypeManagerDto);

		assertEquals(ServiceConst.ERROR, result.getResult());

		verify(this.facilityTypeRepository, times(1))
				.findOneById(this.updateFacilityTypeManagerDto.getFacilityTypeDto().getFacilityTypeId());

	}

	//delete OK

	@Test

	public void testDelete_normal_001() {
		System.out.println("testDelete_normal_001");

		when(this.facilityTypeRepository.delete(this.facilityTypeManagerDto.getFacilityTypeDto().getFacilityTypeId()))
				.thenReturn(1);

		FacilityTypeManagerDto result = service.delete(this.facilityTypeManagerDto);

		assertEquals(ServiceConst.OK, result.getResult());

		verify(this.facilityTypeRepository, times(1))
				.delete(this.facilityTypeManagerDto.getFacilityTypeDto().getFacilityTypeId());
	}

	//delete データなし
	@Test
	public void testDelete_abnormal_001() {
		System.out.println("testDelete_abnormal_001");

		when(this.facilityTypeRepository.delete(this.facilityTypeManagerDto.getFacilityTypeDto().getFacilityTypeId()))
				.thenReturn(0);

		FacilityTypeManagerDto result = service.delete(this.facilityTypeManagerDto);

		assertEquals(ServiceConst.ERROR, result.getResult());

		verify(this.facilityTypeRepository, times(1))
				.delete(this.facilityTypeManagerDto.getFacilityTypeDto().getFacilityTypeId());
	}
}
