package com.woody.fluxdemo.web;

import com.woody.fluxdemo.domain.Customer;
import com.woody.fluxdemo.domain.CustomerRepository;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.time.Duration;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final Sinks.Many<Customer> sink;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.sink = Sinks.many().multicast().onBackpressureBuffer() ;
    }

    @GetMapping(value = "/customer", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Customer> findAll() {
        return customerRepository.findAll()
                .delayElements(Duration.ofSeconds(1))
                .log();
    }

    @GetMapping("/customer/{id}")
    public Mono<Customer> findById(@PathVariable Long id) {
        return customerRepository.findById(id).log();
    }

    @GetMapping(value = "/customer/sse")
    public Flux<ServerSentEvent<Customer>> findAllSSE() {
        return sink.asFlux()
                .map(c -> ServerSentEvent.builder(c).build())
                .doOnCancel(() -> sink.asFlux().blockLast());
    }

    @PostMapping("/customer")
    public Mono<Customer> save() {
        return customerRepository
                .save(new Customer("Elon", "Musk"))
                .doOnNext(c -> sink.tryEmitNext(c));
    }

}
