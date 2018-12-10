package sample.data.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Objects;

@Data
public class BackEndLocation {

    private String url;

    public BackEndLocation url (String url) {
        this.url = url;
        return this;
    }

    @DBRef
    private BackEndInstance backEndInstance;

    public BackEndLocation backEndInstance(BackEndInstance backEndInstance) {
        this.backEndInstance = backEndInstance;
        return this;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BackEndLocation {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n")
        .append("        url=").append(url).append("\n")
        .append("        backendInstance=").append(backEndInstance).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }


}
