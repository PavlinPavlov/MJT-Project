package tu.p_pavlov.mjt.project.api.rest;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import tu.p_pavlov.mjt.project.api.dto.PurchaseReadDto;
import tu.p_pavlov.mjt.project.api.dto.PurchaseWriteDto;
import tu.p_pavlov.mjt.project.domain.PurchaseFilter;
import tu.p_pavlov.mjt.project.domain.model.Purchase;
import tu.p_pavlov.mjt.project.domain.repository.PurchaseRepository;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/test")
public class PurchaseController {

    private final PurchaseRepository purchaseService;
    private final ModelMapper modelMapper;

    public PurchaseController(PurchaseRepository purchaseService, ModelMapper modelMapper) {
        this.purchaseService = purchaseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<Mono<Page<Purchase>>> findAll(
            @RequestParam(defaultValue = "0") @Positive Integer pageParam,
            @RequestParam(defaultValue = "12") @Positive Integer sizeParam,
            @RequestParam(required = false) LocalDateTime lastDate,
            @RequestParam(required = false) LocalDateTime firstDate
    ) {

        PurchaseFilter filter = PurchaseFilter.builder()
                .lastDate(lastDate)
                .firstDate(firstDate)
                .build();

        Mono<Page<Purchase>> purchasePageMono = purchaseService.findAll(pageParam, sizeParam, filter);

        return ResponseEntity.ok(purchasePageMono);
    }

    @PostMapping
    public ResponseEntity<Mono<PurchaseReadDto>> create(@RequestBody @Valid PurchaseWriteDto purchaseToCreate) {

        Purchase purchase = modelMapper.map(purchaseToCreate, Purchase.class);

        Mono<PurchaseReadDto> readDto = purchaseService.save(purchase)
                .map(entity -> modelMapper.map(entity, PurchaseReadDto.class));

        return new ResponseEntity<>(readDto, HttpStatus.CREATED);
    }
}
