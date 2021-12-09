package com.kh.spring15.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring15.repository.MemberDao;
import com.kh.spring15.vo.MemberJoinVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;

//	@Autowired
//	private MemberProfileDao memberProfileDao;

	@Override
	public void join(MemberJoinVO memberJoinVO) {
		//(필수) 회원정보를 뽑아서 회원테이블에 저장
		//(선택) 회원이미지 정보를 뽑아서 이미지 테이블과 실제 하드디스크에 저장
	}
	
}