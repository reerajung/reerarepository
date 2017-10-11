package com.test.sts;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class EmployeeDAOTest {

	@Inject
	private EmployeeDAO dao;
	
	@Test
	public void testEmployeeList()throws Exception{
		
		List<Employee> list = dao.employeeList();
		System.out.println("size:"+list.size());
		for (Employee m : list) {
			System.out.printf("%s %s %s %s %s %s %n"
					, m.getEmp_id(), m.getName_(), m.getReg_name(), m.getDept_name(), m.getJob_title(), m.getPay() );
		}
	}	
	
	
	public void testRegionList()throws Exception{
		
		List<Employee> list = dao.regionList();
		System.out.println("size:"+list.size());
		for (Employee m : list) {
			System.out.printf("%s %s   %n"
					, m.getReg_id(), m.getReg_name());
		}
	}
	
	 

}


