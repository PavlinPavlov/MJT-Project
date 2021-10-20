package tu.p_pavlov.mjt.project.domain.service.impl;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tu.p_pavlov.mjt.project.domain.model.Item;
import tu.p_pavlov.mjt.project.domain.repository.ItemRepository;
import tu.p_pavlov.mjt.project.domain.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Mono<Item> save(Item itemToCreate) {
        return itemRepository.save(itemToCreate);
    }

    @Override
    public Mono<Item> findById(String id) {
        return itemRepository.findById(id);
    }

    @Override
    public Flux<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return itemRepository.deleteById(id);
    }
}
