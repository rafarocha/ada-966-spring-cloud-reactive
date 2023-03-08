package com.pix.service;

import com.pix.api.Historico;
import com.pix.api.Pagamento;
import com.pix.api.PagamentoPedido;
import com.pix.api.Usuario;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GatewayService {

    private final static String SERVICE = "pagamento";

    public Mono<String> extrato(String username) {
        Mono<Usuario> monoUsuario = this.obterUsuario(username);
        Mono<Historico> mono = this.obterPagamentos(username);

        // montar objeto simplificado e enviar

        return Mono.just("ok");
    }

    @CircuitBreaker(name = SERVICE, fallbackMethod = "agendarPagamentoFallback")
    public Mono<Pagamento> pagar(PagamentoPedido pedido) {
        // logica e regras basicas
        if (true)
            throw new RuntimeException();
        return this.solicitarPagamento(pedido);
    }

    public Mono<Pagamento> agendarPagamentoFallback(PagamentoPedido pedido, Exception e) {
        // auditar log erro
        return Mono.just( new Pagamento() );
    }

    public Mono<Historico> obterPagamentos(String username) {
        WebClient webClient = WebClient.create("http://locahost:8080");
        Mono<Historico> mono = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/usuarios/" + username)
                        .build())
                .retrieve().bodyToMono(Historico.class);
        return mono;
    }

    public Mono<Pagamento> solicitarPagamento(PagamentoPedido pedido) {
        WebClient webClient = WebClient.create("http://locahost:8080");
        Mono<Pagamento> mono = webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/pagamentos")
                        .build())
                .body(pedido, Usuario.class)
                .retrieve().bodyToMono(Pagamento.class);
        return mono;
    }

    public Mono<Usuario> obterUsuario(String username) {
        WebClient webClient = WebClient.create("http://locahost:8080");
        Mono<Usuario> mono = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/usuarios/" + username)
                        .build())
                .retrieve().bodyToMono(Usuario.class);
        return mono;
    }

}