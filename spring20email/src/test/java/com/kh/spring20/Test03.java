package com.kh.spring20;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
public class Test03 {
	@Autowired
	private EmailService emailService;

	@Test
	public void test() {
		
		emailService.sendCertificationNumber("hwangtest1234@gmail.com");

	}
}
