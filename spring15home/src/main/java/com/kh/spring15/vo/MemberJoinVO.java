package com.kh.spring15.vo;

import org.springframework.web.multipart.MultipartFile;

import com.kh.spring15.entity.MemberDto;

import lombok.Data;

/**
 * 	회원 가입 정보를 받기 위한 VO
 *	회원정보(MemberDto)와 프로필 이미지(attach)를 저장한다
 */
@Data
public class MemberJoinVO {
	private String memberId;
	private String memberPw;
	private String memberNick;
	private String memberBirth;
	private String memberEmail;
	private String memberPhone;
	private MultipartFile attach;
	
	public MemberDto convert() {
		MemberDto memberDto = new MemberDto();
		memberDto.setMemberId(this.getMemberId());
		memberDto.setMemberPw(this.getMemberPw());
		memberDto.setMemberNick(this.getMemberNick());
		memberDto.setMemberBirth(this.getMemberBirth());
		memberDto.setMemberEmail(this.getMemberEmail());
		memberDto.setMemberPhone(this.getMemberPhone());
		return memberDto;
	}
}