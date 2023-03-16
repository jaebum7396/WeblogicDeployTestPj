package config;

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ControllerAdvice
public class ErrorHandler {
private Logger logger = LoggerFactory.getLogger(ErrorHandler.class);
	@ExceptionHandler
	public String handleException(Exception ex, Model model) {
		logger.error("Exception 발생 : {}", ex.getMessage());
		model.addAttribute("msg", "잠시 후 다시 시도해주세요");
		return "error/error";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex, Model model) {
		logger.error("404 발생 : {}", ex.getRequestURL());
		model.addAttribute("msg", "페이지가 없습니다.");
		return "error/error";
	}
}
