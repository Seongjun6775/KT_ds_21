package com.hello.board.dao;

import java.util.List;

import com.hello.board.vo.BoardVO;

public interface BoardDAO {
	
	public int createNewBoard(BoardVO boardVO);
	
	public List<BoardVO> readAllBoard();
	
	public BoardVO readOneBoardByBoardId(int id);
	
	public int updateBoard(BoardVO boardVO);
	
	public int deleteBoard(int id);
}
