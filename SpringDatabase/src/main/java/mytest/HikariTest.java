package mytest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class HikariTest {
	
	public static void main(String[] args) {
		
		HikariConfig config = new HikariConfig();
		//config.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		config.setJdbcUrl("jdbc:oracle:thin:/@localhost:1521:XE");
		config.setUsername("hr");
		config.setPassword("1234");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		
		HikariDataSource ds = new HikariDataSource(config);
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
				ResultSet rs = pstmt.executeQuery();
		){
			while (rs.next()) {
				log.info(rs.getString("first_name") + " " + rs.getString("last_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
