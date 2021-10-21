package tu.p_pavlov.mjt.project.domain.repository.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tu.p_pavlov.mjt.project.domain.PurchaseFilter;
import tu.p_pavlov.mjt.project.domain.model.Purchase;
import tu.p_pavlov.mjt.project.domain.repository.PurchaseRepositoryCustom;

public class PurchaseRepositoryCustomImpl implements PurchaseRepositoryCustom {

    private final ReactiveMongoTemplate mongoTemplate;

    public PurchaseRepositoryCustomImpl(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Mono<Page<Purchase>> findAll(int page, int size, PurchaseFilter filter) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "_id"));
        Query query = new Query().with(pageable);

        Flux<Purchase> chatUserFlux = mongoTemplate.find(query, Purchase.class);
        Mono<Long> countMono = mongoTemplate.count(Query.of(query).limit(-1).skip(-1), Purchase.class);

        return Mono
                .zip(chatUserFlux.collectList(), countMono)
                .map(tuple2 -> PageableExecutionUtils.getPage(
                                tuple2.getT1(),
                                pageable,
                                tuple2::getT2
                        )
                );
    }

    @Override
    public Mono<Page<Purchase>> findAll(int page, int size) {
        return findAll(page, size, PurchaseFilter.builder().build());
    }

}
