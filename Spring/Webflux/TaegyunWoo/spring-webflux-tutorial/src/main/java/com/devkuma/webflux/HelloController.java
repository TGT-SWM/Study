package com.devkuma.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Annotated Controller 기반 구현
 */
@RestController
public class HelloController {

  /*
   * curl -i localhost:8080
   * curl -i localhost:8080 -H 'Accept: text/event-stream'
   */
  @GetMapping("/")
  Flux<String> hello() {
    return Flux.just("Hello", "World");
  }

  /*
   * curl -i localhost:8080/stream
   * curl -i localhost:8080/stream -H 'Accept: text/event-stream'
   * curl -i localhost:8080/stream -H 'Accept: application/stream+json'
   */
  @GetMapping("/stream")
  Flux<Map<String, Integer>> stream() {
    Stream<Integer> stream = Stream.iterate(0, i -> i+1); //Java8의 무한 Stream
    return Flux.fromStream(stream.limit(10)) //10개 요소로 제한
        .map(i -> Collections.singletonMap("value", i));
  }

  /*
   * curl -i localhost:8080/infinite-stream -H 'Accept: text/event-stream'
   */
  @GetMapping("/infinite-stream")
  Flux<Map<String, Integer>> infiniteStream() {
    Stream<Integer> stream = Stream.iterate(0, i -> i+1); //Java8의 무한 Stream
    return Flux.fromStream(stream) //요소 갯수 제한 X
        .map(i -> Collections.singletonMap("value", i));
  }

  /*
   * curl -i localhost:8080/echo -H 'Content-Type: application/json' -d devkuma
   */
  @PostMapping("/echo")
  Mono<String> echo(@RequestBody Mono<String> body) {
    return body.map(String::toUpperCase);
  }

}
