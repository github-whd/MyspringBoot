package com.whd.springBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyHtmlController {
	 @GetMapping("/home")
	    public String index(){
	        return "home"; //当浏览器输入/home时，会返回 /templates/home.html页面
	    }
}
