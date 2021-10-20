package tu.p_pavlov.mjt.project.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Document("items")
public class Item extends BaseDocument {

    @Field("ItemName")
    private String name;

    @Field("ItemPrice")
    private double price;

    @Field("Quantity")
    private long quantity;

    @Field("ItemCategories")
    private Set<String> categories;
}
