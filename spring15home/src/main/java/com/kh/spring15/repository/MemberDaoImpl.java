package com.kh.spring15.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring15.entity.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberDto get(String memberId) {
		return sqlSession.selectOne("member.get", memberId);
	}

	@Override
	public MemberDto login(MemberDto memberDto) {
		MemberDto findDto = sqlSession.selectOne("member.get", memberDto.getMemberId());
		
		//해당 아이디의 회원정보가 존재 && 입력 비밀번호와 조회된 비밀번호가 같다면 => 로그인 성공(객체를 반환)
		if(findDto != null && memberDto.getMemberPw().equals(findDto.getMemberPw())) {
			return findDto;
		}
		else {//아니면 null을 반환
			return null;
		}
	}

	@Override
	public void join(MemberDto memberDto) {
		sqlSession.insert("member.insert", memberDto);
	}
	
	@Override
	public boolean changePassword(String memberId, String memberPw, String changePw) {
		Map<String, Object> param = new HashMap<>();
		param.put("memberId", memberId);
		param.put("memberPw", memberPw);
		param.put("changePw", changePw);
		int count = sqlSession.update("member.changePassword", param);
		return count > 0;
	}
	
}




