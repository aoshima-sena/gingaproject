package jp.co.ginga.web.domain.service.facility;

import jp.co.ginga.infra.repository.facility.FacilityRepository;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeRepository;

public interface FacilityManagerService {

	public FacilityManagerDto getFacilityList();

	public FacilityManagerDto getFacilityDetailByFacilityId(int facilityId);

	public FacilityManagerDto getFacilityByName(String facilityName);

	public FacilityManagerDto add(FacilityManagerDto dto);

	public FacilityManagerDto update(FacilityManagerDto dto);

	public FacilityManagerDto delete(FacilityManagerDto dto);

	public void setFacilityRepository(FacilityRepository facilityRepository);

	public void setFacilityTypeRepository(FacilityTypeRepository facilityTypeRepository);


}
