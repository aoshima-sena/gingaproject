package jp.co.ginga.spring.base.step6.domain.entity;

import java.util.Date;

public class EmployeeEntity {

	private Long empNo;
    private String empName;
    private Date birthday;
    private Long deptno;

    public Long getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Long empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getDeptno() {
        return deptno;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        return String.format("Employee[empNo=%d, empName=%s, birthday=%s, deptno=%d]", empNo, empName, birthday,
                deptno);
    }

}
