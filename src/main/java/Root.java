import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class Root {

    public final Element element;
    public final List<Element> list;

    @JsonCreator
    public Root (@JacksonXmlProperty @JsonProperty ("element") Element e,
                 @JacksonXmlProperty @JsonProperty ("list") List<Element> l) {

        this.element = e;
        this.list = l;

    }

}
