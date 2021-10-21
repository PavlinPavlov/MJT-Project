package tu.p_pavlov.mjt.project.api.rest;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tu.p_pavlov.mjt.project.api.dto.BusinessClientDto;
import tu.p_pavlov.mjt.project.api.dto.ClientFullReadDto;
import tu.p_pavlov.mjt.project.api.dto.PersonalClientDto;
import tu.p_pavlov.mjt.project.domain.enumeration.ClientTypeEnum;
import tu.p_pavlov.mjt.project.domain.model.BusinessClient;
import tu.p_pavlov.mjt.project.domain.model.Client;
import tu.p_pavlov.mjt.project.domain.model.PersonalClient;
import tu.p_pavlov.mjt.project.domain.service.ClientService;

import javax.validation.Valid;

import static tu.p_pavlov.mjt.project.util.constant.Constants.ENDPOINT_API;
import static tu.p_pavlov.mjt.project.util.constant.Constants.ENDPOINT_CLIENTS;
import static tu.p_pavlov.mjt.project.util.constant.Constants.ENDPOINT_CLIENTS_BUSINESS;
import static tu.p_pavlov.mjt.project.util.constant.Constants.ENDPOINT_CLIENTS_PERSONAL;
import static tu.p_pavlov.mjt.project.util.constant.Constants.ENDPOINT_CLIENTS_TYPED;

@RestController
@RequestMapping(ENDPOINT_API + ENDPOINT_CLIENTS)
public class ClientController {

    private final ClientService clientService;
    private final ModelMapper modelMapper;

    public ClientController(ClientService clientService, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<Flux<ClientFullReadDto>> findAll() {
        Flux<ClientFullReadDto> clientsFlux = clientService.findAll()
                .map(c -> modelMapper.map(c, ClientFullReadDto.class));

        return ResponseEntity.ok(clientsFlux);
    }

    @GetMapping(ENDPOINT_CLIENTS_TYPED)
    public ResponseEntity<Flux<ClientFullReadDto>> findAllByType(@RequestParam ClientTypeEnum type) {
        Flux<ClientFullReadDto> clientsFlux = clientService.findAll(type.getClientClass())
                .map(c -> modelMapper.map(c, ClientFullReadDto.class));

        return ResponseEntity.ok(clientsFlux);
    }

    @PostMapping(ENDPOINT_CLIENTS_PERSONAL)
    public ResponseEntity<Mono<ClientFullReadDto>> createPersonal(@RequestBody @Valid PersonalClientDto clientToCreate) {
        Client clientEntity = modelMapper.map(clientToCreate, PersonalClient.class);

        Mono<ClientFullReadDto> savedClientMono = clientService.save(clientEntity)
                .map(c -> modelMapper.map(c, ClientFullReadDto.class));

        return new ResponseEntity<>(savedClientMono, HttpStatus.CREATED);
    }

    @PostMapping(ENDPOINT_CLIENTS_BUSINESS)
    public ResponseEntity<Mono<ClientFullReadDto>> createBusiness(@RequestBody @Valid BusinessClientDto clientToCreate) {
        Client clientEntity = modelMapper.map(clientToCreate, BusinessClient.class);

        Mono<ClientFullReadDto> savedClientMono = clientService.save(clientEntity)
                .map(c -> modelMapper.map(c, ClientFullReadDto.class));

        return new ResponseEntity<>(savedClientMono, HttpStatus.CREATED);
    }

}
