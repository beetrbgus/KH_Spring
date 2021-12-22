package com.kh.spring28.configuration;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfiguration {
	
//	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
//		<property name="dataSource" ref="dbcpSource"></property>
//		<property name="configLocation" value="classpath:/mybatis/mybatis-config.xml"></property>
//		<property name="mapperLocations" value="classpath:/mybatis/mapper/**/*-mapper.xml"></property>
//	</bean>
	
//	ref에 설정해야 하는 값들은 매개변수에 선언하면 자동으로 주입이 이루어진다(대상도 등록이 되어 있어야 함)
//	ApplicationContext는 애플리케이션 내의 파일들을 자유롭게 경로 지정하기 위해 지원하는 탐색 도구(내장 객체)
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dbcpSource, ApplicationContext ctx) throws IOException {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dbcpSource);
		bean.setConfigLocation(ctx.getResource("classpath:/mybatis/mybatis-config.xml"));
		bean.setMapperLocations(ctx.getResources("classpath:/mybatis/mapper/**/*-mapper.xml"));
		return bean;
	}
	
//	<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
//		<constructor-arg index="0" ref="sqlSessionFactory"></constructor-arg>
//	</bean>
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
		return template;
	}
	
}