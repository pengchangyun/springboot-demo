package com.example.common.config;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 统一异常处理类
 * @author 彭长云
 * @Description: Class说明
 * @date 2018年3月23日
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(getClass().getName());
	
	@ExceptionHandler(value = Exception.class)
	@RequestMapping("/error")
	public Object defaultErrorHandler(HttpServletRequest req,Exception e) {
		logger.error("",e);
		
		String result = "";
		if (e instanceof BindException) {
			BindException bindException = (BindException) e;
			for (FieldError fieldErro : bindException.getBindingResult().getFieldErrors()) {
				//result += "【" + fieldErro.getField() + ":" + fieldErro.getDefaultMessage() + "】";
				result += "【"+fieldErro.getDefaultMessage() + "】";
			}
		} else if (e instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
			for (FieldError fieldErro : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
				//result += "【" + fieldErro.getField() + ":" + fieldErro.getDefaultMessage() + "】";
				result += "【" + fieldErro.getDefaultMessage() + "】";
			}
		} else if (e instanceof HttpRequestMethodNotSupportedException) {
			HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException = (HttpRequestMethodNotSupportedException) e;
			result = httpRequestMethodNotSupportedException.getMessage();
		} else if (e instanceof NoHandlerFoundException) {
			result = "无效的请求地址";
		} else if (e instanceof MissingServletRequestParameterException) {
			MissingServletRequestParameterException missingServletRequestParameterException = (MissingServletRequestParameterException) e;
			result = "缺少必要的参数[" + missingServletRequestParameterException.getMessage() + "]";
		} else {
			result = "Error handling OR Service unavaliable";
		}
		return result;
	}
}
