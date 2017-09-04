import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ListClass {

    @JsonProperty("element")
    public List<Element> element;

}
