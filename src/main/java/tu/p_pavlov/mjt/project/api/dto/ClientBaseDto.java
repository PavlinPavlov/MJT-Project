package tu.p_pavlov.mjt.project.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class ClientBaseDto {

    private boolean isOrganization;


    @Size(
            min = 5,
            max = 120,
            message = "Client address must be in length range ['${min}', '${max}']"
    )
    private String address;

    @Pattern(
            regexp = "(0|\\+359)([0-9]){9}",
            message = "Not a valid phone number."
    )
    private String phone;
}
