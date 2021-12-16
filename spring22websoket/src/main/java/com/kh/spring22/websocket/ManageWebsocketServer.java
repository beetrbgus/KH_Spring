package com.kh.spring22.websocket;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

/*
 *	기본 웹소켓 서버
 *	= 상속은 인터페이스  or 클래스를 선택해 받는다.
 *  = 서버로서 반드시 가져야 할 기능들을 재정의하여 웹 소켓 사용자들을 관리한다.
 *    - 입장알림  : 사용자가 접속한 이후에 사용자의 정보를 알려주는 메소드
 *    - 퇴장알림  : 사용자의 접속 종료 이후에 사용자의 정보를 알려주는 메소드 
 *    - 메세지
 */

@Slf4j
public class ManageWebsocketServer extends TextWebSocketHandler {
//	Set<WebSocketSession> users = new HashSet<>();
	Set<WebSocketSession> users = new CopyOnWriteArraySet<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.add(session);
		log.debug("접속! 현재 사용자 {}명 ",users.size());
		log.debug("session = {}", session);
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session);
		log.debug("퇴장! 현재 사용자 {}명 ",users.size());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
	
	}
	
}
