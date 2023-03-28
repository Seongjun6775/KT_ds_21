package com.hello.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.member.dao.MemberDAO;
import com.hello.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public boolean createNewMember(MemberVO memberVO) {
		int exists = memberDAO.readOneMemberByEmailId(memberVO.getEmail());
		
		int createMember = 0;
		if(exists == 0) {
			createMember = memberDAO.createNewMember(memberVO);
		}
		return createMember > 0;
	}

	@Override
	public MemberVO readOneMemberByEmailAndPassword(MemberVO memberVO) {
		return memberDAO.readOneMemberByEmailAndPassword(memberVO);
	}

}
