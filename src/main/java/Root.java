import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

public class Root {

    public final Element element;

    public final ListClass listClass;

    @JsonCreator
    public Root (@JsonProperty ("element") Element e,
                 @JsonProperty ("list") ListClass lc) {

        this.element = e;
        this.listClass = lc;
    }
}