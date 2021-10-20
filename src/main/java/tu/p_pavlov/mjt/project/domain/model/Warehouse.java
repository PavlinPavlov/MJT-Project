package tu.p_pavlov.mjt.project.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@EqualsAndHashCode(callSuper = true)
@Document("warehouses")
public class Warehouse extends BaseDocument {

    @Field("WarehouseAddress")
    private String address;

}
