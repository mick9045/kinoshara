package ua.step.kino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"ua.step.kino.controllers"})
public class KinoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinoApplication.class, args);
	}

}
