package com.devkuma.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

@SpringBootApplication
public class HelloWebFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWebFluxApplication.class, args);
	}

	/**
	 * static import 적용 X
	 * @return
	 */
	/*
	@Bean
	RouterFunction<ServerResponse> route() {
		return RouterFunctions.route(
				RequestPredicates.GET("/"),
				req -> ServerResponse
						.ok().body(Flux.just("Hello", "World!"), String.class)
		);
	}
	 */

	/**
	 * static import 적용
	 * curl -i localhost:8080
	 * @return
	 */
	@Bean
	RouterFunction<ServerResponse> route() {
		return RouterFunctions.route(
				GET("/"),
				req -> ok().body(Flux.just("Hello", "World!"), String.class)
		);
	}

	@Bean
	RouterFunction<ServerResponse> handler() {
		return new HelloHandler().routes();
	}
}
