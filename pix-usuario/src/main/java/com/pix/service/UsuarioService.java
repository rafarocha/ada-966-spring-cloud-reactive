package com.pix.service;

import com.pix.domain.Usuario;
import com.pix.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Mono<Usuario> salvar(Usuario cliente) {
        return repository.save(cliente);
    }

    public Flux<Usuario> listar() {
        return repository.findAll();
    }

    public Mono<Usuario> atualizar(Usuario cliente, String id) {
        return repository.findById(id)
                .flatMap( atual -> this.atualizar(atual, cliente));
    }

    private Mono<Usuario> atualizar(Usuario atual, Usuario cliente) {
        atual.setNome( cliente.getNome() ); // TODO mudar dentro do dominio
        atual.setUsername( cliente.getUsername() );
        return repository.save(atual);
    }

    public Mono<Void> remover(String id) {
        return repository.deleteById(id);
    }

    public Mono<Usuario> obterPorUsername(String username) {
        return repository.findByUsername(username);
    }

}