package jp.co.ginga.spring.base.step6.domain.service;

import java.util.List;

import jp.co.ginga.spring.base.step6.domain.entity.DepartmentEntity;

public interface DepartmentService {

	public List<DepartmentEntity> getDepartmentList();

	public int add(DepartmentEntity entity);

	public DepartmentEntity getDepartment(Long deptno);

	public int update(DepartmentEntity entity);

	public boolean delete(Long deptno);

	public DepartmentEntity selectDeptEmp(Long deptno);
}
