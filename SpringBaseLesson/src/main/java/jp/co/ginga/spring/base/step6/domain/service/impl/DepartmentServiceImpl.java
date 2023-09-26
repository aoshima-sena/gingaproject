package jp.co.ginga.spring.base.step6.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.ginga.spring.base.step6.domain.entity.DepartmentEntity;
import jp.co.ginga.spring.base.step6.domain.repository.DepartmentRepository;
import jp.co.ginga.spring.base.step6.domain.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	// Repositoryクラスを連携（Repositoryクラスメソッドを呼ぶため）
	@Autowired
	DepartmentRepository repoDepartment;

	// 全取得
	@Override
	public List<DepartmentEntity> getDepartmentList() {
		return repoDepartment.findAll();
	}

	// IDをキーに検索
	@Override
	public DepartmentEntity getDepartment(Long deptno) {
	    return repoDepartment.findOneById(deptno);
	}

	// 登録
	@Override
	public int add(DepartmentEntity entity) {
		if (repoDepartment.add(entity)) {
			return 1;
		} else {
			return 0;
		}
	}

	// 更新
	@Override
	public int update(DepartmentEntity entity) {
	    if (repoDepartment.update(entity)) {
	        return 1;
	    } else {
	        return 0;
	    }
	}

	// 削除
	@Override
	public boolean delete(Long deptno) {
	    return repoDepartment.delete(deptno);
	}

	//
	@Override
	public DepartmentEntity selectDeptEmp(Long deptno) {
	    return repoDepartment.selectDeptEmp(deptno);
	}
}
