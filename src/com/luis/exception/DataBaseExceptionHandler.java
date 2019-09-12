package com.luis.exception;

import org.hibernate.JDBCException;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DataBaseExceptionHandler {

	@ExceptionHandler()
	public String handleDataAccessException(DataAccessException dae,Model model) {
		model.addAttribute("errorDataBasePage", "handleDataAccessException "+dae.getMessage());
		return "errorDataBasePage";
	}
	
	@ExceptionHandler()
	public String handleJdbcException(JDBCException dae,Model model) {
		model.addAttribute("errorDataBasePage", "handleJdbcException "+dae.getMessage());
		return "errorDataBasePage";
	}
	
	@ExceptionHandler()
	public String handleGenericException(Exception dae,Model model) {
		model.addAttribute("errorDataBasePage", "handleGenericException "+dae.getMessage());
		return "errorDataBasePage";
	}
	
}
