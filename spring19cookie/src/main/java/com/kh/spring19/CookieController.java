package com.kh.spring19;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CookieController {
	
	private static final Logger logger = LoggerFactory.getLogger(CookieController.class);
	
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		return "home";
	}
	@RequestMapping(value = "/create")
	public String create(HttpServletResponse response) {
		Cookie cookie = new Cookie("test", "hello");
		cookie.setMaxAge(10);
		response.addCookie(cookie);
		return "redirect:/";
	}
	@RequestMapping(value = "/drop")
	public String drop(HttpServletResponse response) {
		Cookie cookie = new Cookie("test", "hello");
		cookie.setMaxAge(0);
		
		response.addCookie(cookie);
		
		return "redirect:/";
	}
}
