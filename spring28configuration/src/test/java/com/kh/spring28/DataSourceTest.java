package com.kh.spring28;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class DataSourceTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private DataSource dbcpSource;
	
	@Test
	public void test() {
		log.debug("dataSource = {}", dataSource);
		assertNotNull(dataSource);
	}
	
	@Test
	public void test2() {
		log.debug("dbcpSource = {}", dbcpSource);
		assertNotNull(dbcpSource);
	}
	
}