package sample.data.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class BackEnd {

    private String url;

    @DBRef
    private BackEndInstance backEndInstance;

}
