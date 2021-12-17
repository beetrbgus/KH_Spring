package com.kh.spring22.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.kh.spring22.vo.ServerVO;
import com.kh.spring22.vo.UserVO;

public class MultiChannelWebsocketServer extends TextWebSocketHandler{
	
	private ServerVO server = new ServerVO();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String userId = (String) session.getAttributes().get("userId");
		
		UserVO user = new UserVO();
		user.setUserId(userId);
		user.setSession(session);
		
		//server.enter(user, ?);//사용자는 입장 시 메세지를 보낼 수 없으므로 어느 채널에 들어갈지 알 수 없다.
		//대기실로 입장시키는 코드(미구현)
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		String userId = (String) session.getAttributes().get("userId");
		
		UserVO user = new UserVO();
		user.setUserId(userId);
		user.setSession(session);
		
		//어느 채널에 있든 전체 채널에게 명령을 내리므로 퇴장 조치가 가능
		server.leave(user);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//사용자가 어느 채널로 입장할 것인지를 메세지로 알려줘야 한다
	}
	
}