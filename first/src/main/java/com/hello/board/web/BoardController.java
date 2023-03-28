package com.hello.board.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.hello.board.service.BoardService;
import com.hello.board.vo.BoardVO;
import com.hello.member.vo.MemberVO;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	

	
	@Value("${upload.path:/spring-app-test/upload-files}")
	private String uploadPath;
//============GETMapping===================	
	@GetMapping("/boards")
	public String viewBoardListPage(Model model) {
		List<BoardVO> boardList = boardService.readAllBoard();
		model.addAttribute("boardList", boardList);
		return "board/boards";
	}
	@GetMapping("/board/{boardId}")
	public String viewBoardDetailPate(@PathVariable int boardId, Model model) {
//		System.out.println("URL 변수 boardId의 값: "+ boardId);
		logger.debug("URL 변수 boardId의 값: {}", boardId);
		
		BoardVO board = boardService.readOneBoardByBoardId(boardId);
		model.addAttribute("board", board);
		return "board/detail";
	}
	@GetMapping("/board/write")
	public String viewBoardWritePage() {
		return "board/write";
	}
	@GetMapping("/board/update/{boardId}")
	public String viewBoardUpdatePage(@PathVariable int boardId, Model model) {
		BoardVO board = boardService.readOneBoardByBoardId(boardId);
		model.addAttribute("board", board);
		return "board/update";
	}
	@GetMapping("/board/delete/{boardId}")
	public String doBoardDelete(@PathVariable int boardId) {
		boolean deleteResult = boardService.deleteBoard(boardId);
		if(deleteResult) {
			return "redirect:/boards";
		}
		return "redirect:/board/"+boardId;
	}
	@GetMapping("/topic/download/{boardId}")
	public void downloadFile(@PathVariable int boardId,
							 HttpServletRequest request,
							 HttpServletResponse response) {
		BoardVO board = boardService.readOneBoardByBoardId(boardId);
		
//		new DownloadUtil(response, request, this.uploadPath + "/" +board.getAttachFileList().get);
	}
	
//============POSTMapping===================	
	@PostMapping("/board/write")
	public String doBoardWrite(BoardVO boardVO, List<MultipartFile> uploadFile, @SessionAttribute("__USER_SESSION_DATA__") MemberVO memberVO) {
		boardVO.setEmail(memberVO.getEmail());
		
		boolean isSuccess = boardService.createNewBoard(boardVO, uploadFile);
		
//		uploadHandler.upload(uploadFile, boardVO.getId());
		
		if(!isSuccess) {
			return "redirect:/board/write";
		}
		return "redirect:/board/"+boardVO.getId();
	}
	@PostMapping("/board/update/{boardId}")
	public String doBoardUpdate(@PathVariable int boardId, BoardVO boardVO, @SessionAttribute("__USER_SESSION_DATA__") MemberVO memberVO) {
		boardVO.setId(boardId);
		boardVO.setEmail(memberVO.getEmail());
		boolean updateResult = boardService.updateBoard(boardVO);
		if(updateResult) {
			return "redirect:/board/"+boardId;
		}
		return "redirect:/boards";
	}
}