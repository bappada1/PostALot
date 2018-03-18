package com.pal.actions;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
	public ModelAndView helloWorld(HttpServletRequest request,
			HttpServletResponse response){
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String msg = request.getParameter("message");
			
		ModelAndView mvObject = new ModelAndView("hellopage");
		mvObject.addObject("name", name);
		mvObject.addObject("email", email);
		mvObject.addObject("msg", msg);
		return mvObject;
	}
}


