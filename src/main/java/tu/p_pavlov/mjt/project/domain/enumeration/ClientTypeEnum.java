package tu.p_pavlov.mjt.project.domain.enumeration;

import tu.p_pavlov.mjt.project.domain.model.BusinessClient;
import tu.p_pavlov.mjt.project.domain.model.Client;
import tu.p_pavlov.mjt.project.domain.model.PersonalClient;

public enum ClientTypeEnum {

    PERSONAL(PersonalClient.class),
    BUSINESS(BusinessClient.class);

    private final Class<? extends Client> clazz;

    ClientTypeEnum(Class<? extends Client> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends Client> getClientClass() {
        return clazz;
    }
}
