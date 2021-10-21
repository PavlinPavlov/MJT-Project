package tu.p_pavlov.mjt.project.api.rest;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tu.p_pavlov.mjt.project.api.dto.ItemReadDto;
import tu.p_pavlov.mjt.project.api.dto.ItemWriteDto;
import tu.p_pavlov.mjt.project.domain.model.Item;
import tu.p_pavlov.mjt.project.domain.service.ItemService;

import javax.validation.Valid;

import static tu.p_pavlov.mjt.project.util.constant.Constants.ENDPOINT_API;
import static tu.p_pavlov.mjt.project.util.constant.Constants.ENDPOINT_ITEMS;

@RestController
@RequestMapping(ENDPOINT_API + ENDPOINT_ITEMS)
public class ItemController {

    private final ItemService itemService;
    private final ModelMapper modelMapper;

    public ItemController(ItemService itemService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<Flux<ItemReadDto>> findAll() {

        Flux<ItemReadDto> allItemsFlux = itemService.findAll()
                .map(i -> modelMapper.map(i, ItemReadDto.class));

        return ResponseEntity.ok(allItemsFlux);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<ItemReadDto>> findById(@PathVariable String id) {

        Mono<ItemReadDto> allItemsFlux = itemService.findById(id)
                .map(i -> modelMapper.map(i, ItemReadDto.class));

        return ResponseEntity.ok(allItemsFlux);
    }

    @PostMapping
    public ResponseEntity<Mono<ItemReadDto>> create(@RequestBody @Valid ItemWriteDto itemToCreate) {
        Item itemToSave = modelMapper.map(itemToCreate, Item.class);

        Mono<ItemReadDto> createdItemMono = itemService.save(itemToSave)
                .map(i -> modelMapper.map(i, ItemReadDto.class));

        return new ResponseEntity<>(createdItemMono, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> delete(@PathVariable String id) {
        return ResponseEntity.ok(itemService.deleteById(id));
    }
}
