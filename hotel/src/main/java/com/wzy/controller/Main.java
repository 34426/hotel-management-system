package com.wzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 跳板页
 * @Auther: wzy
 * @Date: 2021/01/23/13:00
 * @Description:
 */
@Controller
@RequestMapping("/Main")
public class Main {
	
	@RequestMapping("/todata")
	public String tologin(){
		return "redirect:/DateView/tolist.do?type="+1;
	}

}
