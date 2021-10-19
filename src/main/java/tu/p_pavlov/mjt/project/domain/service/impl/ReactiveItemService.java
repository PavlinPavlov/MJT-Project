package tu.p_pavlov.mjt.project.domain.service.impl;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import tu.p_pavlov.mjt.project.domain.model.Item;
import tu.p_pavlov.mjt.project.domain.repository.ItemRepository;
import tu.p_pavlov.mjt.project.domain.service.ItemService;

@Service
public class ReactiveItemService implements ItemService {

    private final ItemRepository itemRepository;

    public ReactiveItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Mono<Item> save(Item itemToCreate) {
        return itemRepository.save(itemToCreate);
    }
}
