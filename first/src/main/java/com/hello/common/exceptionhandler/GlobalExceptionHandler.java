package com.hello.common.exceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice({"com.hello","org.springframework"})
public class GlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler
	public String HandleRuntimeException(RuntimeException re, Model model) {
		logger.info("예외가 발생하였습니다.{}", re.getMessage());
		model.addAttribute("message", re.getMessage());
		return "errors/500";
	}
}
