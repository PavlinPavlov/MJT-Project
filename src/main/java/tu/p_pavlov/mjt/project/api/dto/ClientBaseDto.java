package tu.p_pavlov.mjt.project.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
//@Builder
public class ClientBaseDto {

    private boolean isOrganization;


    @Size(
            min = 5,
            max = 120,
            message = "Value '${validatedValue}' must be in length range ['${min}', '${max}']"
    )
    private String address;

    private String phone;
}
