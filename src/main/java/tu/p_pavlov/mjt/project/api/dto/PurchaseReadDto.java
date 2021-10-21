package tu.p_pavlov.mjt.project.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import tu.p_pavlov.mjt.project.domain.model.Client;
import tu.p_pavlov.mjt.project.domain.model.Item;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
public class PurchaseReadDto {

    private String id;

    private Set<Item> items;

    private Client client;

    private LocalDateTime purchaseTime;

    private double totalPayedAmount;
}
