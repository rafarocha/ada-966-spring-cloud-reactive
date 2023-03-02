package com.pix.controller;

import com.pix.domain.Usuario;
import com.pix.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@RestController
@RequestMapping("/usuarios")
@Slf4j
public class UsuarioController {

    private UsuarioService service;

    public UsuarioController(UsuarioService UsuarioService) {
        this.service = UsuarioService;
    }

    Sinks.Many<Usuario> sinks = Sinks.many().replay().latest();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Usuario> salvar(@RequestBody Usuario Usuario) {
        return service.salvar(Usuario)
                .doOnNext(salvo -> {
                    sinks.tryEmitNext(salvo);
                });
    }

    @GetMapping("/{username}")
    public Mono<Usuario> obter(@PathVariable(value = "username") String username) {
        return service.obterPorUsername(username);
    }

    @GetMapping
    public Flux<Usuario> listar() {
        return service.listar(); // TODO -> ResponseEntity
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Usuario>> atualizar(@RequestBody Usuario usuario, @PathVariable String id) {
        Mono<Usuario> atualizar = service.atualizar(usuario, id);
        return atualizar
                .map(atual -> ResponseEntity.ok().body(atual))
                .switchIfEmpty(Mono.just(ResponseEntity.noContent().build()));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> remover(@PathVariable String id) {
        return service.remover(id);
    }

    @GetMapping("/stream")
    public Flux<Usuario> stream() {
        return sinks.asFlux();
    }

}