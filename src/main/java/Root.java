import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;

@JsonRootName("root")
//@JacksonXmlRootElement(localName = "root")
//@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
//@JsonDeserialize(using = RootDeserializer.class)
//@JsonSerialize(using = RootSerializer.class)
public class Root {

    //@JsonProperty("element")
    @JacksonXmlProperty(localName = "element")
    public Integer element;

    //@JsonProperty("list")
    @JacksonXmlElementWrapper(localName = "list")
    //@JacksonXmlProperty(localName = "element")
    public List<Integer> list;
}