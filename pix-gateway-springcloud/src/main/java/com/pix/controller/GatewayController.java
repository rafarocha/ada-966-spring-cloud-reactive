package com.pix.controller;

import com.pix.api.Historico;
import com.pix.api.Pagamento;
import com.pix.api.PagamentoPedido;
import com.pix.api.Usuario;
import com.pix.service.GatewayService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/gateway")
public class GatewayController {

    private GatewayService service;

    public GatewayController(GatewayService service) {
        this.service = service;
    }

    @GetMapping("/ping")
    public Mono<String> ping() {
        return Mono.just("pong");
    }

    // clientes > webclient (reativo) ou openFeign (spring cloud)
    @GetMapping("/extrato")
    public Mono<String> extrato(String username) {
        Mono<String> extrato = service.extrato(username);
        return extrato;
    }

    @GetMapping("/pagamento")
    public Mono<String> pagar() { // TODO enviar no body
        service.pagar(null);
        return Mono.just("hello");
    }

}