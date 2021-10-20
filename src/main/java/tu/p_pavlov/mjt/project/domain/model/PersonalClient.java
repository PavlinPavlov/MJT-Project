package tu.p_pavlov.mjt.project.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@EqualsAndHashCode(callSuper = true)
@Document("clients")
public class PersonalClient extends Client {

    @Field("ClientFirstName")
    private String firstName;

    @Field("ClientLastName")
    private String lastName;
}
