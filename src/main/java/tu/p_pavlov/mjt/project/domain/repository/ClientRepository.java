package tu.p_pavlov.mjt.project.domain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import tu.p_pavlov.mjt.project.domain.model.Client;

@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, String>, ClientRepositoryCustom {
}
