import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

public class Root {

    @JsonIgnore
    public static final TypeReference<ArrayList<Integer>> typeReference = new TypeReference<ArrayList<Integer>>() {};

    @JsonProperty("element")
    public Integer element;

    @JsonProperty("list")
    public ElementList list;
}