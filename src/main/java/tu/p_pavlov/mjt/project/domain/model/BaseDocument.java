package tu.p_pavlov.mjt.project.domain.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public abstract class BaseDocument implements Serializable {

    @Id
    public String id;

}
