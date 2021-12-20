package com.kh.spring23.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring23.vo.KakaoPayApproveRequestVO;
import com.kh.spring23.vo.KakaoPayApproveResponseVO;
import com.kh.spring23.vo.KakaoPayReadyRequestVO;
import com.kh.spring23.vo.KakaoPayReadyResponseVO;

public class KakaoPayServiceImpl implements KakaoPayService {
	public static final String AUTHORIZATION = "KakaoAK dd692dc3b4f35d869754f9ed2ce93287";
	public static final String CONTENTTYPE = "application/x-www-form-urlencoded;charset=utf-8";

	@Override
	public KakaoPayReadyResponseVO ready(KakaoPayReadyRequestVO requestVO) throws URISyntaxException {
		// 1. 요청 도구 생성
		RestTemplate template = new RestTemplate();

		// 2. 필요한 정보 추가(HTTP header, HTTP body)
		// 2-1. HTTP Header 정보 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", AUTHORIZATION);
		headers.add("Content-type", CONTENTTYPE);

		// 2-2. HTTP Body 정보 생성
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", "TC0ONETIME");
		body.add("partner_order_id", requestVO.getPartner_order_id());// 랜덤시리얼
		body.add("partner_user_id", requestVO.getPartner_user_id());// 랜덤시리얼
		body.add("item_name", requestVO.getItem_name());
		body.add("quantity", requestVO.getQuantity_string());
		body.add("total_amount", requestVO.getTotal_amount_string());
		body.add("tax_free_amount", "0");

		// 카카오서버에게 결제 결과에 따른 페이지를 미리 안내(단, 애플리케이션에 등록된 주소만 가능)
		// =(주의) 반드시 완성된 주소를 알려줘야 카카오에서 우리 서버로 다시 돌아올 수 있다
		body.add("approval_url", "http://localhost:8080/spring23/pay/success");
		body.add("cancel_url", "http://localhost:8080/spring23/pay/cancel");
		body.add("fail_url", "http://localhost:8080/spring23/pay/fail");

		// 2-3. Header와 Body를 합성
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

		// 3. 목적지 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");

		// 4. 요청방식에 따라 다른 명령으로 전송
		// Map map = template.postForObject(uri, entity, Map.class);//응답을 기대하는 요청(JSON)
		// log.debug("map = {}", map);

		KakaoPayReadyResponseVO responseVO = template.postForObject(uri, entity, KakaoPayReadyResponseVO.class);
		return responseVO;
	}

	@Override
	public KakaoPayApproveResponseVO approve(KakaoPayApproveRequestVO requestVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
