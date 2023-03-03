package com.pix.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pagamentos")
@Slf4j
public class PagamentoController {

    @GetMapping("/ping")
    public Mono<String> ping() {
        return Mono.just("pong");
    }

}