package com.kh.spring20;

import java.util.Properties;

import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/*
 * 이메일 발송 구현
 * -이메일은 SMTP 프로토콜(Simple Message Transfer Protocol)
 * 을 이용하여 원하는 대상의 주소를 이용하여 메세지를 보내는 통신방식
 * - HTTP가 아니기 때문에 별도의 시스템 구축이 필요하다 (ex : 이메일 서버. Apache James 등)
 * - 이메일 서버를 만들어서 도메인을 생성했다고 가정해보면(ex:teacher@kh.com) 이메일이 전송될지
 * - 상용화된 이메일 서비스(ex: Gmail, Hanmail 등)에서는 검증되지 않은 도메인은 스팸으로 분류하여 수신을 차단한다.
 * - 현실적인 어려움 때문에 이메일을 서드파티(3rd party) 시스템을 이용하여 전송하는 형태로 진행
 * 
 * 
 * */
public class Test01 {
		@Test
		public void test() {

			try {
				JavaMailSenderImpl sender = new JavaMailSenderImpl();
				
				//2. 전송을 위한 정보 설정
				sender.setHost("smtp.gmail.com"); // 이용할 Vendor의 Host 정보
				sender.setPort(587); //이용할 Vendor의 Port 정보
				sender.setUsername("devtestbeetrb");//이용자 계정명
				sender.setPassword("devtestbeetrb1234!@#$");//이용자 비밀번호
					
				//3. 추가 정보 설정
				Properties props = new Properties();//문자열만 저장하는 Map 형태의 저장소
				props.setProperty("mail.smtp.auth", "true");//인증 여부 설정
				props.setProperty("mail.smtp.starttls.enable", "true");//TLS 사용여부 설정
				props.setProperty("mail.smtp.debug", "true");//디버깅 사용 설정(옵션)
				props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");//tls 버전
				props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");//신뢰할 수 있는 대상 추가
				sender.setJavaMailProperties(props);
				
				//4. 메일 정보 작성
				//-수신 (To) , 참조 (cc) , 숨은 참조(bcc), 제목(subject),내용(text)
				SimpleMailMessage message = new SimpleMailMessage();
				
				message.setTo("hwangtest1234@gmail.com");
				message.setCc("devtestbeetrb@gmail.com");
				message.setSubject("행운의 편지 쳐내");
				message.setText("!!!");
				
				sender.send(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
