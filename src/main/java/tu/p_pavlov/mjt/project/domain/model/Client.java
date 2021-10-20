package tu.p_pavlov.mjt.project.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@EqualsAndHashCode(callSuper = true)
@Document("clients")
public class Client extends BaseDocument {

    @Field("Organization")
    private boolean isOrganization;

    @Field("BillingAddress")
    private String address;

    @Field("Phone")
    private String phone;

}
