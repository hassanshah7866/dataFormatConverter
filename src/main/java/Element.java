import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.List;

public class Element {

    @JsonIgnore
    public static final TypeReference<ArrayList<Element>> typeReference = new TypeReference<ArrayList<Element>>() {};

    @JsonProperty ("element")
    public final Integer element;

    @JsonCreator
    public Element (Integer e) {

        this.element = e;
    }

    @JsonValue(false)
    public Integer toJson() {
        return this.element;
    }
}
