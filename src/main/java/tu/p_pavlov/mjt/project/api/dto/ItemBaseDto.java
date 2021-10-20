package tu.p_pavlov.mjt.project.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Set;

@Data
@NoArgsConstructor
public class ItemBaseDto {

    @NotBlank(message = "Item name can not be positive.")
    private String name;

    @Positive(message = "Item price must be positive.")
    private double price;

    @Positive(message = "Item quantity must be positive.")
    private long quantity;

    private Set<String> categories;
}
