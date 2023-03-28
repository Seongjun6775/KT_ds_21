package com.hello.member.dao;

import com.hello.member.vo.MemberVO;

public interface MemberDAO {
	
	public int createNewMember(MemberVO memberVO);
	
	public int readOneMemberByEmailId(String email);
	
	public MemberVO readOneMemberByEmailAndPassword(MemberVO memberVO);
}
