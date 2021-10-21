package tu.p_pavlov.mjt.project.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tu.p_pavlov.mjt.project.domain.enumeration.FirmClientRank;

import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessClientDto extends ClientBaseDto {

    @Size(
            min = 5,
            max = 120,
            message = "Organization name must be in length range ['${min}', '${max}']"
    )
    private String organizationName;

    private FirmClientRank rank;

}
