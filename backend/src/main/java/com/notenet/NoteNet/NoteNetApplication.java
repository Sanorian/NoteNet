package com.notenet.NoteNet;
// Spring Boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//JDBC
import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;

// Parser
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;
@SpringBootApplication
@RestController
public class NoteNetApplication {
	public static void main(String[] args) {
		SpringApplication.run(NoteNetApplication.class, args);
	}
	@PostMapping("/")
	public String getNotes(@ResponseBody com.notenet.NoteNet.LoginningUser user) {
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

	@PostMapping("/parse_note")
	public String parseNote(@ResponseBody com.notenet.NoteNet.Note note) {
		MutableDataSet options = new MutableDataSet();
		options.set(HtmlRenderer.SOFT_BREAK, "<br />\n");

		Parser parser = Parser.builder(options).build();
		HtmlRenderer renderer = HtmlRenderer.builder(options).build();

		Node document = parser.parse(noter.getText());
		String html = renderer.render(document);
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