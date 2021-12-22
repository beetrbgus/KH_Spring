package com.kh.spring28;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class CustomValueTest {

	//@Value를 이용하여 application.properties에 작성된 값을 불러와서 사용할 수 있다
	@Value("${custom.database.driver}")
	String driver;
	
	@Test
	public void test() {
		log.debug("driver = {}", driver);
		assertNotNull(driver);
	}
	
}