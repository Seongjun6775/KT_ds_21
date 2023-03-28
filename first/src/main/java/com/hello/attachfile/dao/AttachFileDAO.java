package com.hello.attachfile.dao;

import com.hello.attachfile.vo.AttachFileVO;

public interface AttachFileDAO {
	
	public int createAttachFile(AttachFileVO attachFileVO);
	
	public AttachFileVO readOneAttachFileByTopicIdAndFileId(AttachFileVO attachFileVO);
	
	public String readOneAttachFileUUIDByfileId(long fileId);
	
	public int deleteOneAttachFileByFileId(long fileId);
}
