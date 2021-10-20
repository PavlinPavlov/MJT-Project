package tu.p_pavlov.mjt.project.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class ItemReadDto extends ItemBaseDto {

    private String id;
}
