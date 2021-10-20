package tu.p_pavlov.mjt.project.domain.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tu.p_pavlov.mjt.project.domain.model.Purchase;

public interface PurchaseService {

    Mono<Purchase> save(Purchase purchaseToSave);

    Mono<Purchase> findById(String id);

    Flux<Purchase> findAll();
}
