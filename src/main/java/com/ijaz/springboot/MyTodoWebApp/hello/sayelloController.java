package com.ijaz.springboot.MyTodoWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class sayelloController {

	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "hi ";
	}

	/*
	 * @RequestMapping("say-hello-html")
	 * 
	 * @ResponseBody public String sayHelloHTML() { return "hi "; }
	 */
	@RequestMapping("say-hello-jsp")
	public String sayHelloJSP() {
		return "sayHello";
	}
}
