package com.hello.reply.service;

import com.hello.reply.vo.ReplyVO;

public interface ReplyService {
	public boolean createNewReply(ReplyVO replyVO);
	
	public boolean updateNewReply(ReplyVO replyVO);
	
	public boolean deleteOneReplyByReplyId(int replyId);
}