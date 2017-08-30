import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomElementListSerializer extends JsonSerializer<ArrayList<Integer>> {

    @Override
    public void serialize(ArrayList<Integer> list, JsonGenerator generator, SerializerProvider provider)
        throws IOException {

        generator.writeStartObject();
        generator.writeFieldName("element");
        generator.writeStartArray();
        for (Integer i : list) {
            generator.writeNumber(i);
        }
        generator.writeEndArray();
        generator.writeEndObject();
    }

}
