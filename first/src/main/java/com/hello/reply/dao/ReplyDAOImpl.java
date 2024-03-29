package com.hello.reply.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hello.reply.vo.ReplyVO;

@Repository
public class ReplyDAOImpl extends SqlSessionDaoSupport implements ReplyDAO {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int createNewReply(ReplyVO replyVO) {
		return getSqlSession().insert("Reply.createNewReply", replyVO);
	}

	@Override
	public int updateNewReply(ReplyVO replyVO) {
		return getSqlSession().update("Reply.updateNewReply", replyVO);
	}

	@Override
	public int deleteOneReplyByReplyId(int replyId) {
		return getSqlSession().delete("Reply.deleteOneReplyByReplyId", replyId);
	}

}
