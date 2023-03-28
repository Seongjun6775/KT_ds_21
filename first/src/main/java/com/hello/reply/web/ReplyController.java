package com.hello.reply.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hello.member.vo.MemberVO;
import com.hello.reply.service.ReplyService;
import com.hello.reply.vo.ReplyVO;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;

	@GetMapping("board/reply/delete/{boardId}/{replyId}")
	public String doDeleteReply(@PathVariable int boardId, @PathVariable int replyId, ReplyVO replyVO) {
		boolean deleteResult = replyService.deleteOneReplyByReplyId(replyId);
		if (deleteResult) {
			return "redirect:/board/"+boardId;
		}
		return "rediect:/board/"+boardId+"?errorCode=deleteFail";
	}
	
	@PostMapping("/board/reply/create")
	public String doCreateReply(ReplyVO replyVO, @SessionAttribute("__USER_SESSION_DATA__") MemberVO memberVO) {
		replyVO.setEmail(memberVO.getEmail());
		boolean createResult = replyService.createNewReply(replyVO);
		if(createResult) {
			return "redirect:/board/"+replyVO.getBoardId();
		}
		return "redirect:/board/"+replyVO.getBoardId()+"?errorCode=fail";
	}
	@PostMapping("board/reply/update/{replyId}")
	public String doUpdateReply(ReplyVO replyVO, @PathVariable int replyId) {
		replyVO.setReplyId(replyId);
		boolean updateResult = replyService.updateNewReply(replyVO);
		if(updateResult) {
			return "/board/"+replyVO.getBoardId();
		}
		return "/board/"+replyVO.getBoardId()+"?errorCode=fail";
	}

}
