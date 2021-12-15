package com.kh.spring21.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring21.repository.ExamDao;

@Controller
@RequestMapping("/view")
public class ViewController {
	
	@Autowired
	private ExamDao examDao;
	
	@GetMapping("/view1")
	public String view1() {
		return "view1";
	}
	
	@GetMapping("/view2")
	public String view2() {
		return "view2";
	}
	
	@GetMapping("/view3")
	public String view3(Model model) {
		model.addAttribute("list", examDao.list());
		return "view3";
	}
	
	@GetMapping("/view4")
	public String view4() {
		return "view4";
	}
	
	@GetMapping("/view5")
	public String view5() {
		return "view5";
	}
	
	@GetMapping("/view6")
	public String view6() {
		return "view6";
	}
	
}