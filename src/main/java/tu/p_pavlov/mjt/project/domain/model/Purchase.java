package tu.p_pavlov.mjt.project.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Document("purchases")
public class Purchase extends BaseDocument {

    @Field("PurchasedItems")
    private Set<Item> items;

    @Field("Client")
    private Client client;

    @Field("TimeOfPurchase")
    private LocalDateTime purchaseTime;

    @Field("TotalPayedAmount")
    private double totalPayedAmount;
}
