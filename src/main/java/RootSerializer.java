import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

public class RootSerializer extends StdSerializer<Root> {

    public RootSerializer () {

        this(null);
    }

    public RootSerializer (Class<Root> t) {

        super(t);
    }

    @Override
    public void serialize (Root value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeNumberField("element", value.element);
        jgen.writeFieldName("list");
        jgen.writeStartObject();
        jgen.writeFieldName("element");
        jgen.writeStartArray();

        for(Integer element : value.list) {

            jgen.writeNumber(element);
        }

        jgen.writeEndArray();
        jgen.writeEndObject();
        jgen.writeEndObject();
    }
}
