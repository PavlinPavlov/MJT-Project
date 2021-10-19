package tu.p_pavlov.mjt.project.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
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
