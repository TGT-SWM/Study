package com.devkuma.webflux;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Functional Endpoints 기반 구현
 * (HelloController를 제거해야 동작한다.)
 */

public class HelloHandler {

  public RouterFunction<ServerResponse> routes() {
    return RouterFunctions.route(GET("/"), this::hello).andRoute(GET("/stream"), this::stream).andRoute(POST("/echo"), this::echo);
  }

  public Mono<ServerResponse> hello(ServerRequest request) {
    return ok().body(Flux.just("Hello", "World!"), String.class);
  }

  public Mono<ServerResponse> stream(ServerRequest request) {
    Stream<Integer> stream = Stream.iterate(0, i -> i+1);
    Flux<Map<String, Integer>> flux = Flux.fromStream(stream)
        .map(i -> Collections.singletonMap("value", i));
    return ok().contentType(MediaType.APPLICATION_NDJSON)
        .body(fromPublisher(flux, new ParameterizedTypeReference<Map<String, Integer>>(){}));
  }

  public Mono<ServerResponse> echo(ServerRequest request) {
    Mono<String> body = request.bodyToMono(String.class).map(String::toUpperCase);
    return ok().body(body, String.class);
  }
}
