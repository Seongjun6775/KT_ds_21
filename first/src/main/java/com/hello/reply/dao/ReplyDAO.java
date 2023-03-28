package com.hello.reply.dao;

import com.hello.reply.vo.ReplyVO;

public interface ReplyDAO {
	
	public int createNewReply(ReplyVO replyVO);
	
	public int updateNewReply(ReplyVO replyVO);
	
	public int deleteOneReplyByReplyId(int replyId);
}
