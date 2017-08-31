import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ElementList{

    @JsonProperty("element")
    public List<Integer> list;

}
