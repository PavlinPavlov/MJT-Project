package tu.p_pavlov.mjt.project.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tu.p_pavlov.mjt.project.domain.enumeration.FirmClientRank;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientFullReadDto extends ClientBaseDto {

    private String id;

    private String firstName;

    private String lastName;

    private String organizationName;

    private FirmClientRank organizationRank;

}
