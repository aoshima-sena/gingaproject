package jp.co.ginga.infra.repository.facilitytype;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FacilityTypeRepository {
	//m1
	public List<FacilityTypeEntity> findAll();

	//m2
	public List<FacilityTypeEntity> findByFgDelete(int fgDelete);

	//m3
	public FacilityTypeEntity findOneById(int facilityTypeId);

	//m4
	public List<FacilityTypeEntity> findByTypeName(String name);

	//m5
	public int insert(FacilityTypeEntity facilityTypeEntity);

	//m6
	public int update(FacilityTypeEntity facilityTypeEntity);

	//m7
	public int delete(int facilityTypeId);

}
