package tu.p_pavlov.mjt.project.domain.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tu.p_pavlov.mjt.project.domain.model.Client;

public interface ClientService {

    Mono<Client> save(Client clientToSave);

    Mono<Client> findById(String id);

    Flux<Client> findAll();

    Mono<Void> deleteById(String id);
}
