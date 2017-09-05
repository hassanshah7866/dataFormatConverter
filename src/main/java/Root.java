import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;

@JsonRootName("root")
public class Root {

    @JacksonXmlProperty(localName = "element")
    public Integer element;

    @JacksonXmlElementWrapper(localName = "list")
    public List<Integer> list;
}