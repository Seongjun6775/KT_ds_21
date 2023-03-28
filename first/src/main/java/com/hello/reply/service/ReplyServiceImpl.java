package com.hello.reply.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.reply.dao.ReplyDAO;
import com.hello.reply.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO replyDAO;
	
	@Override
	public boolean createNewReply(ReplyVO replyVO) {
		return replyDAO.createNewReply(replyVO) > 0;
	}

	@Override
	public boolean updateNewReply(ReplyVO replyVO) {
		return replyDAO.updateNewReply(replyVO) > 0;
	}

	@Override
	public boolean deleteOneReplyByReplyId(int replyId) {
		return replyDAO.deleteOneReplyByReplyId(replyId) > 0;
	}

}
