import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class Element {

    public static final TypeReference<List<Element>> typeReference = new TypeReference<List<Element>>() {};
    public final String value;

    @JsonCreator
    public Element (@JacksonXmlProperty @JsonProperty String v) {
        this.value = v;
    }

}
