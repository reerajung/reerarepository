package com.test.sts;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.ModelMap;

/* Spring MVC에서 Controller 클래스로 등록하려면 @Controller 어노테이션 사용 */
/* @RequestMapping 어노테이션은 요청 주소 지정시 사용. 클래스 단위 또는 메소드 단위로 지정 */
/* 공통적인 부모 주소(/department)를 지정한다. */
@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@Inject
	private EmployeeService service;
	/* @RequestMapping 어노테이션 지정시 요청 방식(GET or POST) 지정 가능 */
	/* 요청 주소와 매핑되는 메소드 이름은 사용자가 지정하고, 매개변수 목록도 사용자가 지정한다. */
	/* 주의) 매개변수 목록에 지정된 객체는 Spring MVC에서 자동 제공한다. */
	/* 세부적인 자식 주소(/list)를 지정한다. */
	/* 전체 요청 주소는 '/department/list' 가 된다. */
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(ModelMap model) {
		
		List<Employee> list = service.departmentList();
		model.addAttribute("list", list);
		/* 메소드의 마지막 반환값은 뷰 정보(파일이름만 지정) */
		/* 경로명과 .jsp 지정은 ViewResolver 객체에 이미 지정된 상태 */
		//포워딩 액션
		return "departmentlist";
	}
	
	
}
