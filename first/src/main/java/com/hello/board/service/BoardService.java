package com.hello.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hello.board.vo.BoardVO;

public interface BoardService {

	public boolean createNewBoard(BoardVO boardVO, List<MultipartFile> uploadFile);
	
	public List<BoardVO> readAllBoard();
	
	public BoardVO readOneBoardByBoardId(int id);
	
	public boolean updateBoard(BoardVO boardVO);
	
	public boolean deleteBoard(int id);
	
}
