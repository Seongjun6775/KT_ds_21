package com.hello.board.vo;

import java.util.List;

import com.hello.attachfile.vo.AttachFileVO;
import com.hello.member.vo.MemberVO;
import com.hello.reply.vo.ReplyVO;

/**
 * BOARD
 */
public class BoardVO {

	private int id;
	private String subject;
	private String content;
	private String email;
	private String crtDt;
	private String mdfyDt;


	private MemberVO memberVO;

	private List<ReplyVO> replyList;
	
	private List<AttachFileVO> attachFileList;

	public List<AttachFileVO> getAttachFileList() {
		return attachFileList;
	}

	public void setAttachFileList(List<AttachFileVO> attachFileList) {
		this.attachFileList = attachFileList;
	}

	public List<ReplyVO> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<ReplyVO> replyList) {
		this.replyList = replyList;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}

	public String getCrtDt() {
		return this.crtDt;
	}

	public void setMdfyDt(String mdfyDt) {
		this.mdfyDt = mdfyDt;
	}

	public String getMdfyDt() {
		return this.mdfyDt;
	}

}