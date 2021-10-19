package tu.p_pavlov.mjt.project.domain.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Warehouse extends BaseDocument {

    private String address;

}
