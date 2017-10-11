package com.test.sts;

import java.util.List;

//MyBatis에서는 추상화를 위해서 interface를 사용한다.
public interface EmployeeDAO {

	//직원 전체 자료 반환 메소드
	public List<Employee> employeeList();

	//지역 전체 자료 반환 메소드
	public List<Employee> regionList();

	//부서 전체 자료 반환 메소드
	public List<Employee> departmentList();

	//직위 전체 자료 반환 메소드
	public List<Employee> positionList();

}
