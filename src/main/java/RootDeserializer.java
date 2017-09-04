import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.util.List;

public class RootDeserializer extends StdDeserializer<Root> {

    public RootDeserializer () {
        this(null);
    }

    public RootDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Root deserialize (JsonParser jp, DeserializationContext ctx)
                             throws IOException, JsonProcessingException {

        Root root = new Root();
        JsonNode rootNode = jp.readValueAsTree();

        Integer element;
        List<Integer> elements;

        for (JsonNode node : rootNode) {
            if (node.isInt()) {
                element = node.asInt();
                root.element = element;

            }else {
                elements = (List<Integer>) node.elements();
                root.list = elements;
            }
        }
        return root;
    }

}
