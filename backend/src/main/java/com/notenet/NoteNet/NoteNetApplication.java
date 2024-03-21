package com.notenet.NoteNet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;
@SpringBootApplication
@RestController
public class NoteNetApplication {
	public static void main(String[] args) {
		SpringApplication.run(NoteNetApplication.class, args);
	}
	@PostMapping("/")
	public String com.LoginningUser(@ResponseBody com.notenet.NoteNet.LoginningUser user) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			try (Connection conn = getConnection()){

				System.out.println("Connection to Store DB succesfull!");
			}
		}
         catch(Exception ex){
			System.out.println("Connection failed...");

			System.out.println(ex);
		}
	}
	public static Connection getConnection() throws SQLException, IOException{

		Properties props = new Properties();
		try(InputStream in = Files.newInputStream(Paths.get("database.properties"))){
			props.load(in);
		}
		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");

		return DriverManager.getConnection(url, username, password);
	}
}