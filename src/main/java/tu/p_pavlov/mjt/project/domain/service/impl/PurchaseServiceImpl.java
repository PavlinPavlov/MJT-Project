package tu.p_pavlov.mjt.project.domain.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tu.p_pavlov.mjt.project.domain.PurchaseFilter;
import tu.p_pavlov.mjt.project.domain.model.Purchase;
import tu.p_pavlov.mjt.project.domain.repository.ClientRepository;
import tu.p_pavlov.mjt.project.domain.repository.ItemRepository;
import tu.p_pavlov.mjt.project.domain.repository.PurchaseRepository;
import tu.p_pavlov.mjt.project.domain.service.PurchaseService;

import java.util.HashSet;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final ItemRepository itemRepository;
    private final ClientRepository clientRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, ItemRepository itemRepository, ClientRepository clientRepository) {
        this.purchaseRepository = purchaseRepository;
        this.itemRepository = itemRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Mono<Purchase> save(Purchase purchaseToSave) {

        return Flux.fromIterable(purchaseToSave.getItems())
                .filterWhen(emptyItem -> itemRepository.existsById(emptyItem.getId()))
                .flatMap(emptyItem -> itemRepository.findById(emptyItem.getId()))
                .collectList()
                .flatMap(fetchedItems -> {
                    purchaseToSave.setItems(new HashSet<>(fetchedItems));
                    return Mono.just(purchaseToSave);
                })
                .flatMap(purchase -> clientRepository.findById(purchase.getClient().getId()))
                .flatMap(client -> {
                    purchaseToSave.setClient(client);
                    return purchaseRepository.save(purchaseToSave);
                });
    }

    @Override
    public Mono<Purchase> findById(String id) {
        return purchaseRepository.findById(id);
    }

    @Override
    public Flux<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    @Override
    public Mono<Page<Purchase>> findAll(int page, int size, PurchaseFilter filter) {
        return purchaseRepository.findAll(page, size, filter);
    }

    @Override
    public Mono<Page<Purchase>> findAll(int page, int size) {
        return purchaseRepository.findAll(page, size);
    }
}
