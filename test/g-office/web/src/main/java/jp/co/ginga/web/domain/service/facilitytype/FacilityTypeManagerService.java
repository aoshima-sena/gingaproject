package jp.co.ginga.web.domain.service.facilitytype;

import jp.co.ginga.infra.repository.facilitytype.FacilityTypeRepository;
import jp.co.ginga.web.application.util.form.facilitytype.FacilityTypeForm;
import jp.co.ginga.web.domain.service.util.dto.facilitytype.FacilityTypeDto;

public interface FacilityTypeManagerService {

	public FacilityTypeManagerDto getFacilityTypeList();

	public FacilityTypeManagerDto getFacilityTypeDetailByFacilityTypeId(int facilityTypeId);

	public FacilityTypeManagerDto getFacilityTypeByName(String name);

	public FacilityTypeManagerDto add(FacilityTypeManagerDto dto);

	public FacilityTypeManagerDto update(FacilityTypeManagerDto dto);

	public FacilityTypeManagerDto delete(FacilityTypeManagerDto dto);

	public FacilityTypeDto getFacilityTypeDto(int facilityTypeId);

	public FacilityTypeManagerDto getFacilityTypeByName(FacilityTypeForm facilityTypeForm);

	//	public void setFacilityTypeRepository(FacilityRepository facilityRepository);

	public FacilityTypeManagerDto getFacilityTypeListDto();

	//	public void setFacilityRepository(FacilityRepository facilityRepository);

	public void setFacilityTypeRepository(FacilityTypeRepository facilityTypeRepository);

}
