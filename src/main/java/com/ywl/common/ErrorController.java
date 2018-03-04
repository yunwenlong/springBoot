package com.ywl.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	@RequestMapping("500")
	public String internaServerError(){
		return "pages/error/500";
	}
	
	@RequestMapping("404")
	public String notFound(){
		return "pages/error/404";
	}
	
	@RequestMapping("400")
	public String badRequest(){
		return "pages/error/400";
	}
	
	@RequestMapping("200")
	public String okRequest(){
		return "pages/error/200";
	}
	
}
