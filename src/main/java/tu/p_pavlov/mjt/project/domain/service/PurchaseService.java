package tu.p_pavlov.mjt.project.domain.service;

import org.springframework.data.domain.Page;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tu.p_pavlov.mjt.project.domain.PurchaseFilter;
import tu.p_pavlov.mjt.project.domain.model.Purchase;

public interface PurchaseService {

    Mono<Purchase> save(Purchase purchaseToSave);

    Mono<Purchase> findById(String id);

    Flux<Purchase> findAll();

    Mono<Page<Purchase>> findAll(int page, int size, PurchaseFilter filter);

    Mono<Page<Purchase>> findAll(int page, int size);
}
