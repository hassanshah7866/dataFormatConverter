import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

public class Root {

    @JsonProperty("element")
    public Integer element;

    @JsonProperty("list")
    public List<String> list;

}