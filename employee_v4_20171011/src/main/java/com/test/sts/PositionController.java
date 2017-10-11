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
/* 공통적인 부모 주소(/member)를 지정한다. */
@Controller
@RequestMapping("/position")
public class PositionController {
	
	private static final Logger logger = LoggerFactory.getLogger(PositionController.class);
	
	/* MemberService 객체(MemberServiceImpl)에 대한 의존 주입 설정 추가 */
	/* @Inject 어노테이션을 사용하면 byType에 의한 의존 주입이 실행된다. */
	@Inject
	private MemberService service;

	/* @RequestMapping 어노테이션 지정시 요청 방식(GET or POST) 지정 가능 */
	/* 요청 주소와 매핑되는 메소드 이름은 사용자가 지정하고, 매개변수 목록도 사용자가 지정한다. */
	/* 주의) 매개변수 목록에 지정된 객체는 Spring MVC에서 자동 제공한다. */
	/* 세부적인 자식 주소(/list)를 지정한다. */
	/* 전체 요청 주소는 '/employee/list' 가 된다. */
	
	
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(ModelMap model) {
		/* 메소드의 마지막 반환값은 뷰 정보(파일이름만 지정) */
		/* 경로명과 .jsp 지정은 ViewResolver 객체에 이미 지정된 상태 */
		//포워딩 액션
		return "positionlist";
	}
	
	
	@RequestMapping(value="/insertform", method = RequestMethod.GET)
	public String insertform(ModelMap model) {
		/* 메소드의 마지막 반환값은 뷰 정보(파일이름만 지정) */
		/* 경로명과 .jsp 지정은 ViewResolver 객체에 이미 지정된 상태 */
		//포워딩 액션
		return "employeeinsertform";
	}
	
	
	
	
	
	
	
	
	
	/* 전체 요청 주소는 '/member/add' 가 된다. */
	/* method 속성 생략시 GET or POST 방식 모두 처리 가능 */
	/* 클라이언트가 폼을 이용해서 전송하는 데이터 수신은 매개변수(Member 객체)를 사용한다. */
	/* RedirectAttributes : 리다이렉트 액션시 클라이언트에게 (1회용)전송할 데이터 지정시 사용 */
	@RequestMapping("/add")
	public String add(Member m, HttpServletRequest request, RedirectAttributes rttr) {
		
		/* request 객체를 이용해서 클라이언트IP 확인 필요 */
		m.setClientIP(request.getRemoteAddr());
		
		String code = service.memberAdd(m);
		
		rttr.addFlashAttribute("code", code);
		
		//리다이렉트 액션 -> redirect: 키워드 사용
		return "redirect:/member/list";
	}
	
	
	//문제) 검색 기능 구현
	
	

}
