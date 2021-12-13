package com.kh.spring20;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring20.component.RandomUtil;
import com.kh.spring20.service.EmailService;

import lombok.extern.slf4j.Slf4j;

/*
 * 
 * */
@ContextConfiguration(locations = { 
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Slf4j
public class Test04 {
	@Autowired
	private RandomUtil randomUtil;

	@Test
	public void test() {
		
		for(int i=1; i < 5 ; i ++) {
			log.debug(randomUtil.generateRandomNumber(i));
		}

	}
}
