package com.hello.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hello.board.dao.BoardDAO;
import com.hello.board.vo.BoardVO;
import com.hello.common.handler.UploadHandler;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private UploadHandler uploadHandler;
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public boolean createNewBoard(BoardVO boardVO, List<MultipartFile> uploadFile) {
		boolean createResult = boardDAO.createNewBoard(boardVO) > 0;
		uploadHandler.upload(uploadFile, boardVO.getId());
		return createResult;
	}

	@Override
	public List<BoardVO> readAllBoard() {
		return boardDAO.readAllBoard();
	}

	@Override
	public BoardVO readOneBoardByBoardId(int id) {
		return boardDAO.readOneBoardByBoardId(id);
	}

	@Override
	public boolean updateBoard(BoardVO boardVO) {
		return boardDAO.updateBoard(boardVO) > 0;
	}

	@Override
	public boolean deleteBoard(int id) {
		return boardDAO.deleteBoard(id) > 0;
	}

}
