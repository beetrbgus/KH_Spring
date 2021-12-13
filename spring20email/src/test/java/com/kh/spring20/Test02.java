package com.kh.spring20;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
public class Test02 {
	@Autowired
	JavaMailSenderImpl sender;

	@Test
	public void test() {
		
		// 4. 메일 정보 작성
		// -수신 (To) , 참조 (cc) , 숨은 참조(bcc), 제목(subject),내용(text)
		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo("hwangtest1234@gmail.com");
		message.setCc("devtestbeetrb@gmail.com");
		message.setSubject("으아아아아아아아아아아아 테스트앋다다ㅏ닫다다2222");
		message.setText("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

		sender.send(message);

	}
}
