package tu.p_pavlov.mjt.project.domain.repository;

import reactor.core.publisher.Flux;
import tu.p_pavlov.mjt.project.domain.model.Client;

public interface ClientRepositoryCustom {
    <T extends Client> Flux<T> findAll(Class<T> clazz);
}
