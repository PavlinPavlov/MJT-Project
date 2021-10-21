package tu.p_pavlov.mjt.project.domain.repository;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import tu.p_pavlov.mjt.project.domain.model.Client;

@Repository
@Transactional(readOnly = true)
public class ClientRepositoryCustomImpl implements ClientRepositoryCustom {

    private final ReactiveMongoTemplate mongoTemplate;

    public ClientRepositoryCustomImpl(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    public <T extends Client> Flux<T> findAll(Class<T> clazz) {

        Query query = new Query().addCriteria(
                Criteria.where("_class")
                        .is(clazz.getName())
        );

        return mongoTemplate.find(query, clazz);
    }
}
