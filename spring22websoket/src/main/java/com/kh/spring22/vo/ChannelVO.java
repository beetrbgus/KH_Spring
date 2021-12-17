package com.kh.spring22.vo;

import java.io.IOException;
import java.util.Set;

import org.springframework.web.socket.TextMessage;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

//1개의 채널 클래스
@Data
@Slf4j
public class ChannelVO {
	private String name;
	private Set<UserVO> users;
	
	public ChannelVO(String name) {
		this.setName(name);
	}
	
	//입장
	public void enter(UserVO user) {
		users.add(user);
		log.debug("[{}채널] {} 입장", this.name, user.getUserId());
	}
	
	//퇴장
	public void leave(UserVO user) {
		users.remove(user);
		log.debug("[{}채널] {} 퇴장", this.name, user.getUserId());
	}
	
	//전체 메세지발송
	public void broadcast(TextMessage message) throws IOException {
		for(UserVO user : users) {
			user.getSession().sendMessage(message);
		}
	}
	
	//회원만 메세지발송
	
	//비회원만 메세지발송
	
	//특정 사용자에게만 메세지발송
	
	//사용자 숫자 반환
	
}