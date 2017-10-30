package com.murkino.demoflux;

import java.util.Collections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ReactiveClientApplication {

	@Bean
	WebClient client() {
		return WebClient.create("http://localhost:8080");
	}
	
	@Bean
	CommandLineRunner demo(WebClient client) {
		return args -> {
			client.get()
			    .uri("/cats")
			    .accept(MediaType.TEXT_EVENT_STREAM)
			    .exchange()
			    .flatMapMany(response -> response.bodyToFlux(Cat.class))
			    .subscribe(xxx -> System.out.println("Client: " + xxx));
		};
	}
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ReactiveClientApplication.class)
		.properties(Collections.singletonMap("server.port", "8081"))
		.run(args);
	}
	
}
