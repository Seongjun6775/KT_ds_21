package com.hello.member.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
