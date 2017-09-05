import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
        JsonNode externalNode = jp.readValueAsTree();
        JsonNode rootNode;

        if (jp.getClass().equals(FromXmlParser.class)) {

            rootNode = externalNode;
        }else {

            rootNode = externalNode.get("root");
        }

        Integer element;
        List<Integer> elements = new ArrayList<>();

        for (JsonNode node : rootNode) {

            if (node.isInt()) {

                element = node.asInt();
                root.element = element;
            } else {
                node = node.elements().next();
                for (Iterator<JsonNode> it = node.elements(); it.hasNext(); ) {
                    JsonNode innerNode = it.next();
                    elements.add(innerNode.asInt());
                }
            }

            root.list = elements;
        }

        return root;
    }
}
