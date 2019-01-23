package com.example.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;


@SpringBootApplication
@RestController
public class OrdersApplication {

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(OrdersApplication.class, args);
		System.out.println("Hello World");
	}

	@RequestMapping("/hello")
	public String hello() {
		return "Namaste";
	}

	@RequestMapping("/dbtest")
	public String dbTest() {
		String sql = "SELECT * FROM customer";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(environment.getProperty("spring.datasource.url"),
					environment.getProperty("spring.datasource.username"),
					environment.getProperty("spring.datasource.password"));
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return "<h1>" + rs.getInt("CUST_ID") + rs.getString("NAME") + rs.getInt("Age") + "</h1>";
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {

				}
			}
		}

	}
}
