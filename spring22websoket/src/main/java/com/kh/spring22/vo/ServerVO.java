package com.kh.spring22.vo;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import lombok.Data;

//여러 개의 채널을 관리하는 서버 클래스
@Data
public class ServerVO {
	
	//여러 개의 채널을 관리할 수 있는 저장소
	private Set<ChannelVO> channels = new CopyOnWriteArraySet<>();
	//채널과 관련된 기능들을 구현
	
	
	public void enterWaitingRoom(UserVO user) {
		
	}
	//채널 추가
	public boolean add(String name) {
		ChannelVO channel = new ChannelVO(name);
		return channels.add(channel);
	}
	
	//채널 삭제
	public boolean remove(String name) {
		ChannelVO channel = new ChannelVO(name);
		return channels.remove(channel);
	}
	
	//채널 객체 반환
	public ChannelVO get(String name) {
		ChannelVO temp = new ChannelVO(name);
		for(ChannelVO channel : channels) {
			if(channel.equals(temp)) {
				return channel;
			}
		}
		return null;
	}
	
	//채널 개수
	public int count() {
		return channels.size();
	}
	
	//사용자 채널 입장
	public void enter(UserVO user, String channelName) {
		add(channelName);
		get(channelName).enter(user);
	}
	
	//사용자 채널 퇴장 : 모든채널 다 찾아서 퇴장조치
	public void leave(UserVO user) {
		for(ChannelVO channel : channels) {
			channel.leave(user);
		}
	}
}







