package fr.maboite.demo.spring.boot;

import fr.maboite.demo.spring.boot.service.BateauService;
import fr.maboite.demo.spring.boot.service.CroisiereService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootApplication.class,args);
	}

}
