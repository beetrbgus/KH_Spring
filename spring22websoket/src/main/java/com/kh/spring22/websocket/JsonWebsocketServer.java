package com.kh.spring22.websocket;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring22.vo.MessageVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonWebsocketServer extends TextWebSocketHandler {
	private Set<WebSocketSession> users = new CopyOnWriteArraySet<>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.add(session);
		log.debug("접속! 현재 사용자 {}명 ", users.size());
		log.debug("session = {}", session);

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session);
		log.debug("퇴장! 현재 사용자 {}명 ", users.size());
	}

	@Autowired
	private ObjectMapper mapper;

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 메세지를 분석하여 내용을 읽고 JSON 형태를 객체로 파싱(parsing)하는 작업이 필요하다
		// = Jackson 라이브러리에 있는 ObjectMapper 클래스를 사용하여 파싱
		// Map map = mapper.readValue(message.getPayload(), Map.class);
		MessageVO vo = mapper.readValue(message.getPayload(), MessageVO.class);
		log.debug("vo = {}", vo);
	}
}
