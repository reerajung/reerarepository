package com.test.sts;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

//EmployeeDAO 인터페이스에 대한 구현 클래스
//-> 추상 메소드에 대한 구현 필수
/* @Repository 어노테이션을 지정해서 스프링 객체로 등록 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	// 필수 항목
	// -> 의존 주입 대상
	// -> SqlSessionTemplate 클래스의 객체(데이터베이스 연결 및 종료 담당)
	/* @Inject 어노테이션을 사용하면 byType에 의한 의존 주입이 실행된다. */
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<Employee> employeeList() {
		/* selectList() 메소드는 반환값이 컬렉션인 경우 사용 */
		/* 매개변수는 MyBatis Mapper 파일의 식별자(namespace식별자+id식별자) 지정 */
		return sqlSession.selectList("com.test.sts.EmployeeMapper.employeeList");
	}

	@Override
	public List<Employee> regionList() {
		return sqlSession.selectList("com.test.sts.EmployeeMapper.regionList");
	}

	@Override
	public List<Employee> departmentList() {
		return sqlSession.selectList("com.test.sts.EmployeeMapper.departmentList");
	}
	
	@Override
	public List<Employee> positionList() {
		return sqlSession.selectList("com.test.sts.EmployeeMapper.positionList");
	}


}
