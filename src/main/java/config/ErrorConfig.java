package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorConfig {
private Logger logger = LoggerFactory.getLogger(ErrorConfig.class);
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex, Model model) {
		logger.error("Exception 발생 : {}", ex.getMessage());
		model.addAttribute("msg", "잠시 후 다시 시도해주세요");
		return "error/error";
	}

}
