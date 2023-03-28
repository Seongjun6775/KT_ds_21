package com.hello.member.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hello.common.util.StringUtil;
import com.hello.member.service.MemberService;
import com.hello.member.vo.MemberVO;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/regist")
	public String viewMemberRegistPage() {
		return "member/regist";
	}
	@GetMapping("/member/login")
	public String viewLoginPage(){
		return "member/login";
	}
	@GetMapping("/member/logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/member/login";
	}
	@PostMapping("/member/login")
	public String doLogin(MemberVO memberVO, HttpSession session, Model model) {
		// 1. 검증
		if(memberVO.getEmail() == null || memberVO.getEmail().length() == 0) {
			throw new RuntimeException("email은 필수 값입니다.");
		}
		if(memberVO.getPassword() == null || memberVO.getPassword().length() == 0) {
			throw new RuntimeException("비번은 필수 값입니다.");
		}
		// 2. 데이터 조회
		MemberVO memberData = memberService.readOneMemberByEmailAndPassword(memberVO);
		
		// 3. 성공 처리
		if(memberData != null) {
			//세션에 데이터 저장
			session.setAttribute("__USER_SESSION_DATA__", memberData);
		}
		// 4. 실패 처리
		else {
			model.addAttribute("errorCode", "NOT_FOUND_USER");
			return "member/login";
		}
		return "redirect:/boards";
	}
	@PostMapping("/member/regist")
	public String doMemberRegistPage(MemberVO memberVO) {
		
		String email = memberVO.getEmail();
		String name = memberVO.getName();
		String password = memberVO.getPassword();
		String passwordConfirm = memberVO.getPasswordConfirm();
		
		if(StringUtil.isEmpty(email)) {
			throw new RuntimeException("email은 필수 값 입니다.");
		}
		if(StringUtil.isEmpty(name)) {
			throw new RuntimeException("name은 필수 값 입니다.");
		}
		if(StringUtil.isEmpty(password)) {
			throw new RuntimeException("password은 필수 값 입니다.");
		}
		if(StringUtil.isEmpty(passwordConfirm)) {
			throw new RuntimeException("passwordConfirm은 필수 값 입니다.");
		}
		if(StringUtil.isExceedLength(email, 100)) {
			throw new RuntimeException("email은 100글자 까지 작성할 수 있습니다.");
		}
		if(StringUtil.isExceedLength(name, 10)) {
			throw new RuntimeException("name은 100글자 까지 작성할 수 있습니다.");
		}
		if(StringUtil.isExceedLength(password, 100)) {
			throw new RuntimeException("password은 100글자 까지 작성할 수 있습니다.");
		}
		if(StringUtil.isExceedLength(passwordConfirm, 100)) {
			throw new RuntimeException("passwordConfirm은 100글자 까지 작성할 수 있습니다.");
		}
		if(!StringUtil.isMatch(password, passwordConfirm)) {
			throw new RuntimeException("password가 일치하지 않습니다.");
		}
		
		boolean isSuccess = memberService.createNewMember(memberVO);
//		System.out.println("회원 성공 여부: "+ isSuccess);
		logger.debug("회원 성공 여부: {}", isSuccess);
		if(!isSuccess) {
			return "redirect:http://naver.com";
		}
		return "redirect:/member/regist";
	}
}
