package com.hello.reply.vo;

import com.hello.member.vo.MemberVO;

public class ReplyVO {

	private int depth;

	private int replyId;
	private int boardId;
	private String reply;
	private String email;
	private String crtDt;
	private String mdfyDt;
	private int prntReplyId;

	private MemberVO memberVO;

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCrtDt() {
		return crtDt;
	}

	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}

	public String getMdfyDt() {
		return mdfyDt;
	}

	public void setMdfyDt(String mdfyDt) {
		this.mdfyDt = mdfyDt;
	}

	public int getPrntReplyId() {
		return prntReplyId;
	}

	public void setPrntReplyId(int prntReplyId) {
		this.prntReplyId = prntReplyId;
	}

}
