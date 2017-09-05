import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ParserTests {

    @Test
    public void parseRootFromJson () {

        String json =
                        "{\n" +
                        "\"root\": {\n" +
                        "\"element\": 78,\n" +
                        "\"list\": {\n" +
                        "\"element\": [\n" +
                        "1,\n" +
                        "2,\n" +
                        "3\n" +
                        "]\n" +
                        "}\n" +
                        "}\n" +
                        "}";

        String correctXml = "<root><element>78</element><list><element>1</element><element>2</element><element>3</element></list></root>";

        ObjectMapper jsonMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Root.class, new RootDeserializer());
        module.addSerializer(Root.class, new RootSerializer());
        jsonMapper.registerModule(module);
        //jsonMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        ObjectMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(module);
        try{
            Root root = jsonMapper.readValue(json, Root.class);
            String xml = xmlMapper.writeValueAsString(root);
            Assert.assertEquals(correctXml, xml);
        }catch (Exception e) {

            Assert.fail(e.toString());
        }
    }


    @Test
    public void parseRootFromXml () {

        String correctJson =
                        "{" +
                        "\"root\":{" +
                        "\"element\":78," +
                        "\"list\":{" +
                        "\"element\":[" +
                        "1," +
                        "2," +
                        "3" +
                        "]" +
                        "}" +
                        "}" +
                        "}";

        String xml = "<root>\n" +
                "<element>78</element>\n" +
                "<list>\n" +
                "<element>1</element>\n" +
                "<element>2</element>\n" +
                "<element>3</element>\n" +
                "</list>\n" +
                "</root>";

        SimpleModule module = new SimpleModule();
        module.addDeserializer(Root.class, new RootDeserializer());
        module.addSerializer(Root.class, new RootSerializer());
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.registerModule(module);
        jsonMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        ObjectMapper xmlMapper = new XmlMapper();
        try{

            Root root = xmlMapper.readValue(xml, Root.class);
            String json = jsonMapper.writeValueAsString(root);
            Assert.assertEquals(correctJson, json);
        }catch (Exception e) {

            Assert.fail();
        }
    }
}