package tu.p_pavlov.mjt.project.domain.service.impl;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tu.p_pavlov.mjt.project.domain.model.Purchase;
import tu.p_pavlov.mjt.project.domain.repository.PurchaseRepository;
import tu.p_pavlov.mjt.project.domain.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public Mono<Purchase> save(Purchase purchaseToSave) {
        return purchaseRepository.save(purchaseToSave);
    }

    @Override
    public Mono<Purchase> findById(String id) {
        return purchaseRepository.findById(id);
    }

    @Override
    public Flux<Purchase> findAll() {
        return purchaseRepository.findAll();
    }
}
