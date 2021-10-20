package tu.p_pavlov.mjt.project.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public abstract class BaseDocument implements Serializable {

    @Id
    public String id;

}
