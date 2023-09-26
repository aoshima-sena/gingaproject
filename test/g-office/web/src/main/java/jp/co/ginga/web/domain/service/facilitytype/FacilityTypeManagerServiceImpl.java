package jp.co.ginga.web.domain.service.facilitytype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeRepository;
import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import jp.co.ginga.web.domain.service.util.constant.ServiceConst;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;
import jp.co.ginga.web.domain.service.util.helper.facilitytype.FacilityTypeDtoHelper;

@Service
@Transactional
public class FacilityTypeManagerServiceImpl implements FacilityTypeManagerService {

	@Autowired
	private FacilityTypeRepository facilityTypeRepository;
	@Autowired
	private FacilityTypeDtoHelper facilityTypeDtoHelper;
	@Autowired
	private FacilityTypeManagerHelper facilityTypeManagerHelper;

	//１listから値を取得して全件取得
	@Override
	@Transactional(readOnly = true)
	public FacilityTypeManagerDto getFacilityTypeList() {
		List<FacilityTypeEntity> facilityTypeEntity = facilityTypeRepository.findAll();

		FacilityTypeManagerDto facilityTypeManagerDto = facilityTypeManagerHelper
				.createFacilityTypeServiceDto(facilityTypeEntity);

		if (facilityTypeEntity.size() == 0) {
			facilityTypeManagerDto.setResult(ServiceConst.NO_DATA);
		}

		return facilityTypeManagerDto;
	}

	//２種別詳細情報 種別ID指定 取得
	@Override
	public FacilityTypeManagerDto getFacilityTypeDetailByFacilityTypeId(int facilityTypeId) {
		FacilityTypeEntity facilityTypeEntity = facilityTypeRepository.findOneById(facilityTypeId);
		List<FacilityTypeEntity> facilityTypeEntityList = facilityTypeRepository.findAll();
		FacilityTypeManagerDto facilityTypeManagerDto = facilityTypeManagerHelper
				.createFacilityTypeServiceDto(facilityTypeEntity, facilityTypeEntityList);
		facilityTypeManagerDto.setOptimisticRockValue(facilityTypeEntity.toString());
		return facilityTypeManagerDto;

	}

	//３種別情報の種別名(name)指定して取得
	@Override
	public FacilityTypeManagerDto getFacilityTypeByName(String name) {
		List<FacilityTypeEntity> facilityTypeEntityList = facilityTypeRepository.findByTypeName(name);
		FacilityTypeManagerDto facilityTypeManagerDto = FacilityTypeManagerDto.getInstance();
		List<FacilityTypeDto> facilityTypeDtoList = facilityTypeManagerHelper
				.getFacilityTypeList(facilityTypeEntityList);
		facilityTypeManagerDto.setFacilityTypeDtoList(facilityTypeDtoList);
		if (facilityTypeEntityList.size() == 0) {
			facilityTypeManagerDto.setResult(ServiceConst.NO_DATA);
		} else if (facilityTypeEntityList.size() > 0) {
			facilityTypeManagerDto.setResult(ServiceConst.THERE_IS_DATA);
		} else {
			facilityTypeManagerDto.setResult(ServiceConst.ERROR);
		}
		return facilityTypeManagerDto;
	}

	//４施設addの指示
	//Phantom Read が発生する可能性がある
	@Override
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ)
	public FacilityTypeManagerDto add(FacilityTypeManagerDto dto) {
		FacilityTypeEntity facilityTypeEntity = facilityTypeManagerHelper.getFacilityTypeEntity(dto);
		int result = facilityTypeRepository.insert(facilityTypeEntity);
		FacilityTypeManagerDto facilityTypeManagerDto = facilityTypeManagerHelper
				.createFacilityTypeServiceDtoAdd(result);

		return facilityTypeManagerDto;
	}

	//５update情報指示
	@Override
	public FacilityTypeManagerDto update(FacilityTypeManagerDto dto) {
		FacilityTypeManagerDto facilityTypeManagerDto = FacilityTypeManagerDto.getInstance();
		FacilityTypeEntity updateFacilityTypeEntity = facilityTypeManagerHelper.getFacilityTypeEntity(dto);
		FacilityTypeEntity dbFacilityTypeEntity = facilityTypeRepository
				.findOneById(dto.getFacilityTypeDto().getFacilityTypeId());

		if (dbFacilityTypeEntity.toString().equals(dto.getOptimisticRockValue())) {
			int result = facilityTypeRepository.update(updateFacilityTypeEntity);
			if (result != 1) {
				facilityTypeManagerDto.setResult(ServiceConst.ERROR);
			} else {
				facilityTypeManagerDto.setResult(ServiceConst.OK);
			}
		} else {
			facilityTypeManagerDto.setResult(ServiceConst.OPTIMISTIC_ROCK_ERROR);
		}

		return facilityTypeManagerDto;
	}

	//６削除指示
	@Override
	public FacilityTypeManagerDto delete(FacilityTypeManagerDto dto) {
		FacilityTypeManagerDto facilityTypeManagerDto = FacilityTypeManagerDto.getInstance();
		int delete = facilityTypeRepository.delete(dto.getFacilityTypeDto().getFacilityTypeId());

		if (delete != 1) {
			facilityTypeManagerDto.setResult(ServiceConst.ERROR);
			return facilityTypeManagerDto;
		}
		facilityTypeManagerDto.setResult(ServiceConst.OK);
		return facilityTypeManagerDto;
	}

	//７削除の際種別IDを指定する
	@Override
	public FacilityTypeDto getFacilityTypeDto(int facilityTypeId) {
		FacilityTypeEntity facilityTypeEntity = facilityTypeRepository.findOneById(facilityTypeId);
		FacilityTypeDto facilityTypeDto = facilityTypeDtoHelper.mapToFacilityTypeDto(facilityTypeEntity);

		return facilityTypeDto;
	}

	@Override
	public FacilityTypeManagerDto getFacilityTypeByName(FacilityTypeForm facilityTypeForm) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public FacilityTypeManagerDto getFacilityTypeListDto() {
		return null;

	}

	@Override
	public void setFacilityTypeRepository(FacilityTypeRepository facilityTypeRepository) {
		// TODO 自動生成されたメソッド・スタブ
		this.facilityTypeRepository = facilityTypeRepository;
	}

}
