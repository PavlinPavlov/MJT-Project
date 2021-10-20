package tu.p_pavlov.mjt.project.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tu.p_pavlov.mjt.project.domain.enumeration.FirmClientRank;

@Data
@EqualsAndHashCode(callSuper = true)
//@Builder
public class ClientFullReadDto extends ClientBaseDto {

    private String id;

    private String firstName;

    private String lastName;

    private String organizationName;

    private FirmClientRank organizationRank;

}
