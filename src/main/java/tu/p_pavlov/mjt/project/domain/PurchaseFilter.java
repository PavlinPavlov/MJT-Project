package tu.p_pavlov.mjt.project.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PurchaseFilter {

    private LocalDateTime lastDate;
    private LocalDateTime firstDate;
}
