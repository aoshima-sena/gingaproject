package jp.co.ginga.infra.repository.facility;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FacilityRepository {

	public List<FacilityEntity> findAll();

	public FacilityEntity findByFacilityId(int facilityId);

	public List<FacilityEntity> findByFacilityTypeId(int facilityTypeId);

	public List<FacilityEntity> findByName(String name);

	public int insert(FacilityEntity facilityEntity);

	public int update(FacilityEntity facilityEntity);

	public int delete(int facilityId);

}
