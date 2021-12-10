package com.kh.spring18;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j // 클래스 위에 @Slf4j 표시 남기면 해당 클래스 정보로 Logger가 생성된다.
public class Test02 {

	@Test
	public void test() {
		log.debug("hello debug");
		log.info("hello info");
		log.warn("hello warn");
		log.error("hello error");
	}
}
