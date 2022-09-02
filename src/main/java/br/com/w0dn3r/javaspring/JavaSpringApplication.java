package br.com.w0dn3r.javaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootApplication
public class JavaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringApplication.class, args);
	}
}
