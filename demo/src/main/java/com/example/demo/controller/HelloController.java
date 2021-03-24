package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Getter;
import lombok.Setter;

@Controller
public class HelloController {
	
	@GetMapping(value = "/helloworld/string")
	@ResponseBody
	public String helloworldString(){
		return "helloworld";
	}
	
	@GetMapping(value="/helloworld/json")
	@ResponseBody
	public Hello helloworldJson(){
		Hello hello = new Hello();
		hello.message = "helloworld";
		return hello;
	}
	@GetMapping(value = "/helloworld/page")
	public String helloworld() {
		return "helloworld";
	}
	
	@Getter
	@Setter
	public static class Hello {
		private String message;
	}
}
