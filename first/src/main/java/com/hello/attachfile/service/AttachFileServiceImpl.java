package com.hello.attachfile.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hello.attachfile.dao.AttachFileDAO;
import com.hello.attachfile.vo.AttachFileVO;

@Service
public class AttachFileServiceImpl implements AttachFileService {

	@Autowired
	private AttachFileDAO attachFileDAO;
	
	@Value("${upload.path:/spring-app2/upload-files}")
	private String uploadPath;
	
	@Override
	public boolean createAttachFile(AttachFileVO attachFileVO) {
		return attachFileDAO.createAttachFile(attachFileVO) > 0;
	}

	@Override
	public AttachFileVO readOneAttachFileByTopicIdAndFileId(AttachFileVO attachFileVO) {
		return attachFileDAO.readOneAttachFileByTopicIdAndFileId(attachFileVO);
	}

	@Override
	public boolean deleteOneAttachFileByFileId(long fileId) {
		
		String uuidFileNmae = attachFileDAO.readOneAttachFileUUIDByfileId(fileId);
		
		//파일 삭제
		// 물리 파일 객체 가져오기
		File file = new File(uploadPath, uuidFileNmae);
		if(file.exists()) {
			file.delete();
		}
		return attachFileDAO.deleteOneAttachFileByFileId(fileId) > 0;
	}
	
	
	

}
