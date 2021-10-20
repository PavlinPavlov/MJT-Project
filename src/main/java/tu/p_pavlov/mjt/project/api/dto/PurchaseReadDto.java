package tu.p_pavlov.mjt.project.api.dto;

import lombok.Builder;
import lombok.Data;
import tu.p_pavlov.mjt.project.domain.model.Client;
import tu.p_pavlov.mjt.project.domain.model.Item;

import java.time.OffsetDateTime;
import java.util.Set;

@Data
@Builder
public class PurchaseReadDto {

    private String id;

    private Set<Item> items;

    private Client client;

    private OffsetDateTime purchaseTime;

    private double totalPayedAmount;
}
