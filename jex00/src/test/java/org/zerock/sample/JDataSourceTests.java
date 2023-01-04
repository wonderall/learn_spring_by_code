package org.zerock.sample;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class JDataSourceTests {
	
	@Setter(onMethod_ = {@Autowired})
	private DataSource dataSource;
	@Setter(onMethod_ = {@Autowired})
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testSqlSessionFactory() {
		try {
			SqlSession session = sqlSessionFactory.openSession();
			Connection conn = session.getConnection();
			log.info(conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Test 
	public void testConnection() {
		try {
			Connection conn = dataSource.getConnection();
			log.info(conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
