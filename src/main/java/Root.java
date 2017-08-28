import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Root {

    public final Element element;
    public final List<Element> list;

    @JsonCreator
    public Root (@JsonProperty ("element") Element e,
                 @JsonProperty ("list") List<Element> l) {

        this.element = e;
        this.list = l;

    }
}