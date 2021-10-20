package tu.p_pavlov.mjt.project.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ItemBaseDto {

    private String name;

    private double price;

    private long quantity;

    private Set<String> categories;
}
