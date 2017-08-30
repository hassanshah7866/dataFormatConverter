import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DataFormat {

    public final Root root;

    @JsonCreator
    public DataFormat(@JsonProperty ("root") Root root) {

        this.root = root;
    }
}
