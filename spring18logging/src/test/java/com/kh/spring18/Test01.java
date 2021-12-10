package com.kh.spring18;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test01 {
	private Logger logger = LoggerFactory.getLogger(Test01.class);
	
	@Test
	public void test() {
		logger.debug("hello debug");
		logger.info("hello info");
		logger.warn("hello warn");
		logger.error("hello error");
	}
}
