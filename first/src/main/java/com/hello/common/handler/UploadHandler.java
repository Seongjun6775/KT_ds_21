package com.hello.common.handler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.hello.attachfile.dao.AttachFileDAO;
import com.hello.attachfile.vo.AttachFileVO;

@Component
public class UploadHandler {
	
	@Value("${upload.path:/spring-app/upload-files}")
	private String uploadPath;
	
	@Autowired
	private AttachFileDAO attachFileDAO;
	
	public void upload(List<MultipartFile> multipartFileList, int boadId) {
		for (MultipartFile multipartFile : multipartFileList) {
			upload(multipartFile, boadId);
		}
	}
	
	public void upload(MultipartFile multipartFile, int boardId) {
		if(multipartFile != null && !multipartFile.isEmpty()) {
			String uuidFileName = UUID.randomUUID().toString();
			
			String originFileName = multipartFile.getOriginalFilename();
			
			File uploadPath = new File(this.uploadPath);
			
			if(!uploadPath.exists()) {
				uploadPath.mkdirs();
			}
			
			File randomNameFile = new File(uploadPath, uuidFileName);
			
			try {
				multipartFile.transferTo(randomNameFile);
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException("파일을 업로드할 수 없습니다.");
			}
			
			AttachFileVO attachFileVO = new AttachFileVO();
			attachFileVO.setBoardId(boardId);
			attachFileVO.setOriginFileName(originFileName);
			attachFileVO.setUuidFileName(uuidFileName);
			attachFileVO.setFileSize(multipartFile.getSize());
			
			String ext = originFileName.substring(originFileName.lastIndexOf(".")+1);
			attachFileVO.setFileExt(ext);
			
			attachFileDAO.createAttachFile(attachFileVO);
			
		}
	}
}
