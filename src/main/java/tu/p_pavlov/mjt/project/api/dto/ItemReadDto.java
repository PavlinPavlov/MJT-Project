package tu.p_pavlov.mjt.project.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
//@Builder
public class ItemReadDto extends ItemBaseDto {

    private String id;
}
