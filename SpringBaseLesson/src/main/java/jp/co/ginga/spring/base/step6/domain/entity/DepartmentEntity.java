package jp.co.ginga.spring.base.step6.domain.entity;

import java.util.List;

public class DepartmentEntity {

	// 部署No？
	private Long deptno;

	// 部署名
	private String deptname;

	// 部署リスト？
	private List<EmployeeEntity> employees;

	// サムネイル
	private String deptThumbnail;

	/**
	*デフォルトコンストラクタ
	*/
	public DepartmentEntity() {
		super();
	}

	/**
	*コンストラクタ
	*/
	public DepartmentEntity(Long deptno, String deptname, String deptThumbnail) {
		super();
		this.deptno = deptno;
		this.deptname = deptname;
		this.deptThumbnail = deptThumbnail;
	}

	/**
	* @return deptno
	*/
	public Long getDeptno() {
		return deptno;
	}

	/**
	* @param deptno セットする deptno
	*/
	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}

	/**
	* @return deptname
	*/
	public String getDeptname() {
		return deptname;
	}

	/**
	* @param deptname セットする deptname
	*/
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	/**
	* @return employees
	*/
	public List<EmployeeEntity> getEmployees() {
	   return employees;
	}

	/**
	* @param employees セットする employees
	*/
	public void setEmployees(List<EmployeeEntity> employees) {
	   this.employees = employees;
	}

	/**
	* @return deptThumbnail
	*/
	public String getDeptThumbnail() {
	    return deptThumbnail;
	}

	/**
	* @param deptThumbnail セットする deptThumbnail
	*/
	public void setDeptThumbnail(String deptThumbnail) {
	    this.deptThumbnail = deptThumbnail;
	}
}
