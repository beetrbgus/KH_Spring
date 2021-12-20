package com.kh.spring23.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.kh.spring23.service.KakaoPayService;
import com.kh.spring23.vo.KakaoPayReadyRequestVO;
import com.kh.spring23.vo.KakaoPayReadyResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/pay")
public class PayController {
	
	@Autowired
	private KakaoPayService kakaoPayService;

	@GetMapping("/confirm")
	public String confirm() {
		return "pay/confirm";
	}
	
	//결제 준비 요청
	@PostMapping("/confirm")
	public String confirm(HttpSession session, @ModelAttribute KakaoPayReadyRequestVO requestVO) throws URISyntaxException {
		
		requestVO.setPartner_order_id(UUID.randomUUID().toString());
		requestVO.setPartner_user_id(UUID.randomUUID().toString());
		
		KakaoPayReadyResponseVO responseVO = kakaoPayService.ready(requestVO);
		
		//success에서 사용할 수 있도록 세션에 다음 데이터를 첨부
		//- partner_order_id
		//- partner_user_id
		//- tid
		session.setAttribute("partner_order_id", requestVO.getPartner_order_id());
		session.setAttribute("partner_user_id", requestVO.getPartner_user_id());
		session.setAttribute("tid", responseVO.getTid());
		
		return "redirect:"+responseVO.getNext_redirect_pc_url();
		
	}
	
	//카카오페이의 결제가 성공할 경우 다음과 같은 형태로 요청이 발생한다(카카오페이가 발생시키는 요청)
	//= 반드시 파라미터에 pg_token이 들어오며 이를 이용해서 승인 요청을 해야 한다
	//http://localhost:8080/spring23/pay/success?pg_token=459432df7ef421f46643
	@GetMapping("/success")
	public String success(HttpSession session, @RequestParam String pg_token) throws URISyntaxException {
		//결제 승인 요청
		
		//세션에 전달되는 다음 데이터들을 수신한 뒤 삭제
		//- partner_order_id
		//- partner_user_id
		//- tid
		String partner_order_id = (String) session.getAttribute("partner_order_id");
		String partner_user_id = (String) session.getAttribute("partner_user_id");
		String tid = (String) session.getAttribute("tid");
		session.removeAttribute("partner_order_id");
		session.removeAttribute("partner_user_id");
		session.removeAttribute("tid");
		
		//1. 요청 도구 생성
		RestTemplate template = new RestTemplate();
		
		//2. 필요한 정보 추가(HTTP header, HTTP body)
		//2-1. HTTP Header 정보 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK dd692dc3b4f35d869754f9ed2ce93287");
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//2-2. HTTP Body 정보 생성
		//= cid를 제외한 나머지 정보들은 Test02를 진행한 뒤 확인이 가능
		//= cid는 테스트 개발용으로 "TC0ONETIME"을 사용
		//= tid, partner_order_id, partner_user_id는 Test02의 실행 결과에서 확인 가능
		//= pg_token은 Test02 실행 뒤 결제가 성공적으로 이루어지면 주소창의 파라미터에서 확인 가능
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", "TC0ONETIME");
		body.add("tid", tid);
		body.add("partner_order_id", partner_order_id);
		body.add("partner_user_id", partner_user_id);
		body.add("pg_token", pg_token);
		
		//2-3. Header와 Body를 합성
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		//3. 목적지 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/approve");
		
		//4. 요청방식에 따라 다른 명령으로 전송
		Map map = template.postForObject(uri, entity, Map.class);//응답을 기대하는 요청(JSON)
		log.debug("map = {}", map);
		
		return "redirect:success_result";
	}
	
	@GetMapping("/success_result")
	public String successResult() {
		return "pay/success_result";
	}
}





