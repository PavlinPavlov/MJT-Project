package tu.p_pavlov.mjt.project.domain.repository;

import org.springframework.data.domain.Page;
import reactor.core.publisher.Mono;
import tu.p_pavlov.mjt.project.domain.PurchaseFilter;
import tu.p_pavlov.mjt.project.domain.model.Purchase;

public interface PurchaseRepositoryCustom {

    Mono<Page<Purchase>> findAll(int page, int size, PurchaseFilter filter);

    Mono<Page<Purchase>> findAll(int page, int size);
}
