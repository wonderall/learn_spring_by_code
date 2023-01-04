package org.zerock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {

		}
	}
	@Test
	public void test() {
		try {
			log.info("===============");
			Connection conn =
					DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-R70HQ54:1521/XEPDB1",
							"book_ex","1234");
			log.info(conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
