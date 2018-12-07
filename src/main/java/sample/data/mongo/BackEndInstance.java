package sample.data.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
//@AllArgsConstructor
@Document
public class BackEndInstance {

    @Id
    private String id;

    @Indexed(unique = true)
    private String url;

    public BackEndInstance url(String url) {
        this.url = url;
        return this;
    }

}
