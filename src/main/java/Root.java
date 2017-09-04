import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@JsonTypeName("root")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonDeserialize(using = RootDeserializer.class)
@JsonSerialize(using = RootSerializer.class)
public class Root {

    @JsonProperty("element")
    public Integer element;

    @JsonProperty("list")
    public List<Integer> list;

}