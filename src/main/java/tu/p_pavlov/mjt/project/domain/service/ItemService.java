package tu.p_pavlov.mjt.project.domain.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tu.p_pavlov.mjt.project.domain.model.Item;

public interface ItemService {

    Mono<Item> save(Item itemToCreate);

    Mono<Item> findById(String id);

    Flux<Item> findAll();

    Mono<Void> deleteById(String id);
}
