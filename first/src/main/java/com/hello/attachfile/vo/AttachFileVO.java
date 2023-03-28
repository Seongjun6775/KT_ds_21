package com.hello.attachfile.vo;

public class AttachFileVO {

	private long fileId;
	private long boardId;
	private String originFileName;
	private String uuidFileName;
	private long fileSize;
	private String fileExt;

	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	public long getBoardId() {
		return boardId;
	}

	public void setBoardId(long boardId) {
		this.boardId = boardId;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getOriginFileName() {
		return originFileName;
	}

	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}

	public String getUuidFileName() {
		return uuidFileName;
	}

	public void setUuidFileName(String uuidFileName) {
		this.uuidFileName = uuidFileName;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

}
