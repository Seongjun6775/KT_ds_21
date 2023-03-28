package com.hello.attachfile.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hello.attachfile.service.AttachFileService;

@Controller
public class AttachFileController {

	@Autowired
	private AttachFileService attachFileService;
	
	@GetMapping("/file/download/{boadId}/{fileId}")
	public void downloadFile(@PathVariable int boardId,
							 @PathVariable int fileId) {
		
	}
}
