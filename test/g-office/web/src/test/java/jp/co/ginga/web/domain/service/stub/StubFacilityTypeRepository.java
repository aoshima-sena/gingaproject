package jp.co.ginga.web.domain.service.stub;

import java.util.List;

import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeRepository;

public class StubFacilityTypeRepository implements FacilityTypeRepository {

	@Override
	public List<FacilityTypeEntity> findAll() {
		return null;
	}

	@Override
	public FacilityTypeEntity findOneById(int facilityTypeId) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<FacilityTypeEntity> findByFgDelete(int fgDelete) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public int insert(FacilityTypeEntity facilityTypeEntity) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int update(FacilityTypeEntity facilityTypeEntity) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int delete(int facilityTypeId) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public List<FacilityTypeEntity> findByTypeName(String name) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
