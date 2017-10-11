package com.test.sts;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

//EmployeeService 인터페이스에 대한 구현 클래스
//-> 추상 메소드에 대한 구현 필수
/* @Service 어노테이션을 지정해서 스프링 객체로 등록 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	/* EmployeeDAO 객체(EmployeeDAOImpl)에 대한 의존 주입 설정 추가 */
	/* @Inject 어노테이션을 사용하면 byType에 의한 의존 주입이 실행된다. */
	@Inject
	private EmployeeDAO dao;

	@Override
	public List<Employee> employeeList() {
		//employeeList() 메소드 내에서 Spring JDBC를 사용하는지 MyBatis를 사용하는지 알 필요 없다.
		return dao.employeeList();
	}
	
	@Override
	public List<Employee> regionList() {
		return dao.regionList();
	}

	@Override
	public List<Employee> departmentList() {
		return dao.departmentList();
	}
	
	@Override
	public List<Employee> positionList() {
		return dao.positionList();
	}


}
