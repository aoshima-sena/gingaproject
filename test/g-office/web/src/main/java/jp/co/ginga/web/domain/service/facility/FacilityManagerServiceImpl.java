package jp.co.ginga.web.domain.service.facility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import jp.co.ginga.infra.repository.facility.FacilityEntity;
import jp.co.ginga.infra.repository.facility.FacilityRepository;
import jp.co.ginga.infra.repository.facility.FacilityRepositoryJDBC;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeRepository;
import jp.co.ginga.web.domain.service.util.constant.ServiceConst;
import jp.co.ginga.web.domain.service.util.dto.facility.FacilityDto;
import jp.co.ginga.web.domain.service.util.helper.facility.FacilityDtoHelper;

@Import(FacilityRepositoryJDBC.class)
@Service
@Transactional
public class FacilityManagerServiceImpl implements FacilityManagerService {
	//repositoryクラスをDI
	@Autowired
	FacilityRepository facilityRepository;
	@Autowired
	FacilityTypeRepository facilityTypeRepository;
	@Autowired
	FacilityManagerHelper facilityManagerHelper;
	@Autowired
	FacilityRepositoryJDBC jdbc;

	FacilityDtoHelper facilityDtoHelper;

	//findAllを渡す
	//（readOnly = true）処理が走ると例外がおこる
	@Override
	@Transactional(readOnly = true)
	public FacilityManagerDto getFacilityList() {

		List<FacilityEntity> facilityEntityList = jdbc.findAll();
		FacilityManagerDto facilityManagerDto = facilityManagerHelper.createFacilityServiceDto(facilityEntityList);

		return facilityManagerDto;
	}

	//施設ID取得
	@Override
	public FacilityManagerDto getFacilityDetailByFacilityId(int facilityId) {
		FacilityEntity facilityEntity = facilityRepository.findByFacilityId(facilityId);
		List<FacilityTypeEntity> facilityTypeList = facilityTypeRepository.findAll();
		FacilityManagerDto facilityManagerDto = facilityManagerHelper.createFacilityServiceDto(facilityEntity,
				facilityTypeList);
		facilityManagerDto.setOptimisticRockValue(facilityEntity.toString());

		return facilityManagerDto;

	}

	//施設名取得
	@Override
	public FacilityManagerDto getFacilityByName(String name) {
		List<FacilityEntity> facilityEntityList = facilityRepository.findByName(name);
		FacilityManagerDto facilityManagerDto = FacilityManagerDto.getInstance();
		if (facilityEntityList != null) {
			List<FacilityDto> facilityDtoList = facilityManagerHelper.getFacilityList(facilityEntityList);
			//3-1-1までおｋ
			facilityManagerDto.setFacilityDtoList(facilityDtoList);

			if (facilityEntityList.size() == 0) {
				facilityManagerDto.setResult(ServiceConst.NO_DATA);
			} else if (facilityEntityList.size() > 0) {
				facilityManagerDto.setResult(ServiceConst.THERE_IS_DATA);
			}
		} else {
			facilityManagerDto.setResult(ServiceConst.ERROR);
		}

		return facilityManagerDto;

	}

	//施設情報登録処理
	@Override
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ)
	public FacilityManagerDto add(FacilityManagerDto facilityManagerDto) {
		FacilityEntity facilityEntity = facilityManagerHelper.getFacilityEntity(facilityManagerDto);
		int result = facilityRepository.insert(facilityEntity);
		FacilityManagerDto Dto = facilityManagerHelper.createFacilityServiceDtoAdd(result);

		return Dto;
	}

	//施設情報更新処理
	@Override
	public FacilityManagerDto update(FacilityManagerDto facilityManagerDto) {
		FacilityManagerDto facilityDto = FacilityManagerDto.getInstance();
		FacilityEntity updateFacilityEntity = facilityManagerHelper.getFacilityEntity(facilityManagerDto);
		FacilityEntity dbFacilityEntity = facilityRepository
				.findByFacilityId(facilityManagerDto.getFacilityDto().getFacilityId());

		if (dbFacilityEntity.toString().equals(facilityManagerDto.getOptimisticRockValue())) {

			int result = facilityRepository.update(updateFacilityEntity);

			if (result != 1) {
				facilityDto.setResult(ServiceConst.ERROR);
			} else {
				facilityDto.setResult(ServiceConst.OK);
			}
		} else {
			facilityDto.setResult(ServiceConst.OPTIMISTIC_ROCK_ERROR);
		}
		return facilityDto;

	}

	//施設情報削除処理
	@Override
	public FacilityManagerDto delete(FacilityManagerDto facilityManagerDto) {

		FacilityManagerDto facilityDto = FacilityManagerDto.getInstance();

		int result = facilityRepository.delete(facilityManagerDto.getFacilityDto().getFacilityId());

		if (result != 1) {
			facilityDto.setResult(ServiceConst.ERROR);
			return facilityDto;
		}
		facilityDto.setResult(ServiceConst.OK);
		return facilityDto;
	}

	@Override
	public void setFacilityRepository(FacilityRepository facilityRepository) {
		this.facilityRepository = facilityRepository;
	}

	@Override
	public void setFacilityTypeRepository(FacilityTypeRepository facilityTypeRepository) {
		this.facilityTypeRepository = facilityTypeRepository;
	}


}
