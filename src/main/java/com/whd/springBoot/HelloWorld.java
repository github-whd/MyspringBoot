package com.whd.springBoot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@RequestMapping("/hello")
	public String home() {
		System.out.println("lalal");
		System.out.println("bbbbb");
		return "Hello World!";
	}

}
