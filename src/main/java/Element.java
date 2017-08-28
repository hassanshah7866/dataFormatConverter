import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public class Element {

    public static final TypeReference<List<Element>> typeReference = new TypeReference<List<Element>>() {};
    public final String element;

    @JsonCreator
    public Element (@JsonProperty String v) {

        this.element = v;
    }
}
