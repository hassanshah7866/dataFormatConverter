import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListClass {

    public final List<Element> list;

    @JsonCreator
    public ListClass (@JsonProperty ("element") List<Element> l) {

        this.list = l;

    }

}
