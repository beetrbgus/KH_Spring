package com.kh.spring20.service;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.kh.spring20.component.RandomUtil;
import com.kh.spring20.component.RandomUtilImpl;

@Service
public class GmailService implements EmailService{
	
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private RandomUtil randomNumber; 
	
	@Override
	public void sendCertificationNumber(String to) {
		
		String number = randomNumber.generateRandomNumber(6);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject("[쿠쿠루삥뽕] 인증번호 메일입니다.");
		message.setText(" 인증번호 : "+number);
		sender.send(message);
		
	}
	
	
}
