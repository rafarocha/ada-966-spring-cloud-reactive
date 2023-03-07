package com.pix.repository;

import com.pix.domain.Usuario;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsuarioRepository extends ReactiveMongoRepository<Usuario, String> {

    Mono<Usuario> findByUsername(String username);
    Flux<Usuario> findByPixAndEmail(String pix, String email);

}