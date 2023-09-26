package jp.co.ginga.spring.base.step6.application.form;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class DepartmentForm {

	private Long deptno;

	private MultipartFile deptThumbnail;

	@NotEmpty(message = "必須項目です")
	private String deptname;

	public DepartmentForm clear() {
		return new DepartmentForm();
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
	* @return deptThumbnail
	*/
	public MultipartFile getDeptThumbnail() {
	   return deptThumbnail;
	}

	/**
	* @param deptThumbnail セットする deptThumbnail
	*/
	public void setDeptThumbnail(MultipartFile deptThumbnail) {
	   this.deptThumbnail = deptThumbnail;
	}
}
