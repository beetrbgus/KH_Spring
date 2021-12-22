package com.kh.spring28.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//@Configuration이 붙은 파일은 설정파일로 간주된다
//= 애플리케이션이 시작할 때 설정파일에서 요구하는 내용들을 spring container에 등록한다
//= 운영할 때 쓰는 도구가 아니고 "초기설정"할 때 사용하는 도구이므로 @Autowired에 제약이 생긴다
//= 스프링에 등록할 도구(bean)를 생성하는 것이 목적
@Configuration
public class DatabaseConfiguration {
	
	//application.properties에 정의된 커스텀 변수 데이터를 읽어서 사용
	@Value("${custom.database.driver}")			private String driver;
	@Value("${custom.database.url}")				private String url;
	@Value("${custom.database.username}")		private String username;
	@Value("${custom.database.password}")		private String password;
	@Value("${custom.dbcp.max-total}")			private int maxTotal;
	@Value("${custom.dbcp.max-idle}")				private int maxIdle;
	@Value("${custom.dbcp.min-idle}")				private int minIdle;
	@Value("${custom.dbcp.max-wait-millis}")	private long maxWaitMillis;

//	아래와 동일한 설정을 Java Configuration으로 등록
//	<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
//		<property name="driverClassName" value="oracle.jdbc.OracleDriver"></property>
//		<property name="url" value="jdbc:oracle:thin:@localhost:1521:xe"></property>
//		<property name="username" value="kh"></property>
//		<property name="password" value="kh"></property>
//	</bean>
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);//"oracle.jdbc.OracleDriver"
		dataSource.setUrl(url);//"jdbc:oracle:thin:@localhost:1521:xe"
		dataSource.setUsername(username);//"kh"
		dataSource.setPassword(password);//"kh"
		return dataSource;
	}
	
//	<bean id="dbcpSource" class="org.apache.commons.dbcp2.BasicDataSource">
//		<property name="driverClassName" value="oracle.jdbc.OracleDriver"></property>
//		<property name="url" value="jdbc:oracle:thin:@localhost:1521:xe"></property>
//		<property name="username" value="kh"></property>
//		<property name="password" value="kh"></property>
//		<property name="maxTotal" value="20"></property>
//		<property name="maxIdle" value="5"></property>
//		<property name="minIdle" value="0"></property>
//		<property name="maxWaitMillis" value="3000"></property>
//	</bean>
	@Bean
	public DataSource dbcpSource() {
		BasicDataSource dbcpSource = new BasicDataSource();
		
		dbcpSource.setDriverClassName(driver);//"oracle.jdbc.OracleDriver"
		dbcpSource.setUrl(url);//"jdbc:oracle:thin:@localhost:1521:xe"
		dbcpSource.setUsername(username);//"kh"
		dbcpSource.setPassword(password);//"kh"
		dbcpSource.setMaxTotal(maxTotal);//20
		dbcpSource.setMaxIdle(maxIdle);//5
		dbcpSource.setMinIdle(minIdle);//0
		dbcpSource.setMaxWaitMillis(maxWaitMillis);//3000L
		
		return dbcpSource;
	}
	
}