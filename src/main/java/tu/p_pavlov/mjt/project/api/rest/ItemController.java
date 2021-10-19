package tu.p_pavlov.mjt.project.api.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import tu.p_pavlov.mjt.project.domain.model.Item;
import tu.p_pavlov.mjt.project.domain.service.ItemService;

import static tu.p_pavlov.mjt.project.util.constant.Constants.ENDPOINT_API;

@RestController
@RequestMapping(ENDPOINT_API)
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public Mono<Item> create(@RequestBody Item itemToCreate) {
        return itemService.save(itemToCreate);
    }
}
