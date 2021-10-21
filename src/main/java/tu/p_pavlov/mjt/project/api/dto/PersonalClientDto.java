package tu.p_pavlov.mjt.project.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = true)
public class PersonalClientDto extends ClientBaseDto {

    @Size(
            min = 2,
            max = 64,
            message = "Client first name must be in length range ['${min}', '${max}']"
    )
    private String firstName;

    @Size(
            min = 2,
            max = 64,
            message = "Client last name must be in length range ['${min}', '${max}']"
    )
    private String lastName;

}
