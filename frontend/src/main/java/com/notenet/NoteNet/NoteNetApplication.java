package com.notenet.NoteNet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.text.html.HTMLDocument;
import java.io.IOException;

@SpringBootApplication
@Controller
public class NoteNetApplication {
	static String index;
	static String registration;

	public static void main(String[] args) throws IOException {
		index = com.notenet.NoteNet.FileReader.readFile("pages/index.html");
		SpringApplication.run(NoteNetApplication.class, args);
	}

	@GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String index() {
		return index;
	}
	@GetMapping(value = "/registration", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String registration() {
		return registration;
	}
}
