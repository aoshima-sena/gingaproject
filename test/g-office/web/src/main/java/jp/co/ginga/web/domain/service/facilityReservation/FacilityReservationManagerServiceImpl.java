package jp.co.ginga.web.domain.service.facilityReservation;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import jp.co.ginga.infra.repository.facility.FacilityEntity;
import jp.co.ginga.infra.repository.facility.FacilityRepository;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeRepository;
import jp.co.ginga.infra.repository.reservation.ReservationEntity;
import jp.co.ginga.infra.repository.reservation.ReservationRepository;
import jp.co.ginga.web.domain.service.facility.FacilityManagerHelper;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerDto;
import jp.co.ginga.web.domain.service.facilitytype.FacilityTypeManagerHelper;
import jp.co.ginga.web.domain.service.util.constant.ServiceConst;
import jp.co.ginga.web.domain.service.util.helper.reservation.FacilityReservationDtoHelper;

@Service
@Transactional
public class FacilityReservationManagerServiceImpl implements FacilityReservationManagerService {

	@Autowired
	FacilityRepository facilityRepository;
	@Autowired
	FacilityTypeRepository facilityTypeRepository;
	@Autowired
	FacilityManagerHelper facilityManagerHelper;
	@Autowired
	FacilityTypeManagerHelper facilityTypeManagerHelper;
	@Autowired
	FacilityReservationManagerHelper facilityReservationHelper;
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	FacilityReservationDtoHelper reservationDtoHelper;

	//	FacilityDtoHelper facilityDtoHelper;

	//readOnly = trueにすると登録更新ができなくなる
	//↑レコード操作処理が走った際に例外を投げてくれます。
	//更新を想定していない取得系のサービスとかに設定する
	@Override
	@Transactional(readOnly = true)
	public FacilityReservationManagerDto getFacilityList() {

		List<FacilityEntity> facilityEntityList = facilityRepository.findAll();
		List<FacilityTypeEntity> facilityTypeEntityList = facilityTypeRepository.findAll();
		FacilityReservationManagerDto facilityreservationDto = new FacilityReservationManagerDto();
		facilityreservationDto.setFacilityDtoList(
				facilityManagerHelper.createFacilityServiceDto(facilityEntityList).getFacilityDtoList());
		facilityreservationDto.setFacilityTypeDtoList(facilityTypeManagerHelper
				.createFacilityTypeServiceDto(facilityTypeEntityList).getFacilityTypeDtoList());
//facilityManagerHelperを使う理由と文末の最後にgetFacilityDtoListしている理由
//facilityManagerDto型のものが返ってくるのでfacilityManagerDto.getFacilityDtoListを取得している。（型が違うからね）
		return facilityreservationDto;
	}

	//m2
	@Override
	public FacilityReservationManagerDto getFacilityByFacilityTypeId(int facilityTypeId) {
		List<FacilityEntity> facilityEntity = facilityRepository.findByFacilityTypeId(facilityTypeId);

		FacilityReservationManagerDto facilityReservationDto = new FacilityReservationManagerDto();
		facilityReservationDto.setFacilityDtoList(
				facilityManagerHelper.createFacilityServiceDto(facilityEntity).getFacilityDtoList());

		return facilityReservationDto;

	}

	@Override
	public FacilityReservationManagerDto getFacilityDetailByFacilityId(int facilityId) {
		FacilityEntity facilityEntity = facilityRepository.findByFacilityId(facilityId);
		FacilityReservationManagerDto facilityReservationManagerDto = facilityReservationHelper
				.getFacilityEntity(facilityEntity);

		return facilityReservationManagerDto;

	}

	/**
	 * 予約情報　主キー検索処理
	 */
	@Override
	public FacilityReservationManagerDto getfindOneById(ReservationEntity entity) {
		ReservationEntity reservationEntity = reservationRepository.findOneById(entity);
		FacilityReservationManagerDto dto = facilityReservationHelper.createFacilityReservationDto(reservationEntity);
		return dto;
	}

	/**
	 * 予約情報　施設IDかつ期間検索処理
	 */
	@Override
	public FacilityReservationManagerDto getFacilityIdAndStartDateBetween(int facilityId, Timestamp startTime,
			Timestamp endTime) {
		List<ReservationEntity> entity = reservationRepository.findByFacilityIdAndStartDateBetween(facilityId,
				startTime, endTime);
		FacilityReservationManagerDto dto = facilityReservationHelper.createReservationDto(entity);
		return dto;

	}

	@Override
	public int getCanMakeReservation(int facilityId, Timestamp startTime, Timestamp endTime) {
		int count = reservationRepository.canMakeReservation(facilityId,
				startTime, endTime);

		return count;

	}

	@Override
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ)
	public FacilityReservationManagerDto add(FacilityReservationManagerDto dto) {
		ReservationEntity entity = facilityReservationHelper.getReservationEntity(dto);
		int result = reservationRepository.insert(entity);
		FacilityReservationManagerDto reservationDto = facilityReservationHelper.createReservationDtoAdd(result);

		return reservationDto;
	}

	@Override
	public FacilityReservationManagerDto update(FacilityReservationManagerDto dto) {
		FacilityReservationManagerDto reservationDto = FacilityReservationManagerDto.getInstance();
		ReservationEntity updateEntity = facilityReservationHelper.getReservationEntity(dto);
		//	実際にupdateEntityの中のreservationIdだけを持ってくるため、ここで分ける必要がある
		//	ReservationEntity dbEntity = reservationRepository.findOneById(updateEntity);
		//データを入れる前、入れた後で中のデータが同じだったら。。。
		//optimisticValueなんて知るか

		int result = reservationRepository.update(updateEntity);

		if (result != 1) {
			reservationDto.setResult(ServiceConst.ERROR);
		} else {
			reservationDto.setResult(ServiceConst.OK);
		}

		return reservationDto;
	}

	@Override
	public FacilityReservationManagerDto delete(FacilityReservationManagerDto dto) {
		FacilityReservationManagerDto reservationDto = FacilityReservationManagerDto.getInstance();

		int result = reservationRepository.delete(dto.getReservationDto().getReservationId());

		if (result != 1) {
			reservationDto.setResult(ServiceConst.ERROR);
			return reservationDto;
		}
		reservationDto.setResult(ServiceConst.OK);
		return reservationDto;

	}

	@Override
	public FacilityReservationManagerDto getReservationId(int reservationId) {
		ReservationEntity entity = reservationRepository.getReservationId(reservationId);
		FacilityReservationManagerDto dto = facilityReservationHelper.createFacilityReservationDto(entity);
		return dto;
	}

	@Override
	public FacilityReservationManagerDto reservationId(int facilityId, Timestamp startTime, Timestamp endTime) {
		ReservationEntity entity = reservationRepository.findReservationId(facilityId, startTime, endTime);
		FacilityReservationManagerDto dto = facilityReservationHelper.createFacilityReservationDto(entity);
		return dto;
	}

	private FacilityReservationManagerDto getEndTime(Timestamp endTime) {
		// dtoのendTimeを入れたい

		return new FacilityReservationManagerDto();
	}

	public FacilityReservationManagerDto getStartTime(Timestamp startTime) {
		// TODO 自動生成されたメソッド・スタブ
		return new FacilityReservationManagerDto();
	}

	@Override
	public void setFacilityRepository(FacilityRepository facilityRepository) {
		this.facilityRepository = facilityRepository;

	}

	@Override
	public void setFacilityTypeRepository(FacilityTypeRepository facilityTypeRepository) {
		this.facilityTypeRepository = facilityTypeRepository;
	}

	@Override
	public FacilityReservationManagerDto getFacilityByFacilityTypeId(FacilityTypeEntity f_facility_type_id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public FacilityTypeManagerDto getFacilityTypeDetailByFacilityTypeId(int ft_facility_type_id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void setReservationRepository(ReservationRepository repository) {
		this.reservationRepository = repository;

	}

	@Override
	public FacilityReservationManagerDto findStartEnd(int facilityId) {
		List<ReservationEntity> entity = reservationRepository.findStartEnd(facilityId);
		FacilityReservationManagerDto dto = facilityReservationHelper.createReservationDto(entity);

		return dto;
	}

	@Override
	public FacilityReservationManagerDto getReservationId(ReservationEntity reservationEntity) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}