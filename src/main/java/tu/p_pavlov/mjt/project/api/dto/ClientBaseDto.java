package tu.p_pavlov.mjt.project.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientBaseDto {

    private boolean isOrganization;

    private String address;

    private String phone;
}
