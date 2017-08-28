import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DataFormat {

    public final Root root;

    @JsonCreator
    public DataFormat(@JsonProperty Root r) {

        this.root = r;
    }

}
