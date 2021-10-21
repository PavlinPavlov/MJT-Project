package tu.p_pavlov.mjt.project.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PurchaseWriteDto {

    @NotEmpty(message = "At least one item should be provided.")
    private List<@NotBlank(message = "At least one item should be provided.") String> itemIds;

    @NotBlank(message = "Client id is required.")
    private String clientId;

    private LocalDateTime purchaseTime;

    @Positive(message = "Invalid price")
    private double totalPayedAmount;
}
