package tu.p_pavlov.mjt.project.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import tu.p_pavlov.mjt.project.domain.enumeration.FirmClientRank;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@Document("clients")
public class BusinessClient extends Client {

    @Field("Name")
    private String organizationName;

    @Field("BusinessRank")
    private FirmClientRank rank;
}
