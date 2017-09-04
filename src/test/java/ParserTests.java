import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ParserTests {

    @Test
    public void parseRootFromJson () {

        String json1 =
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

        String json2 = "{\n" +
                "\"root\": {\n" +
                "\"element\": 78,\n" +
                "\"element\": [\n" +
                "1,\n" +
                "2,\n" +
                "3\n" +
                "]\n" +
                "}\n" +
                "}";

        ObjectMapper jsonMapper = new ObjectMapper();
        //jsonMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        ObjectMapper xmlMapper = new XmlMapper();
        try{
            //Integer element = jsonMapper.readValue(json, Integer.TYPE);
            Root root = jsonMapper.readValue(json1, Root.class);
            //Root root = jsonMapper.readValue(json,Root.class);
            String xml = xmlMapper.writeValueAsString(root);
            Assert.assertEquals("<root><element>78</element><list><element>1</element><element>2</element><element>3</element></list><root>", xml);
        }catch (Exception e) {

            Assert.fail(e.toString());
        }
    }

    @Test
    public void parseRootFromJsonUsingTree () {

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

        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        ObjectMapper xmlMapper = new XmlMapper();
        try{
            //Integer element = jsonMapper.readValue(json, Integer.TYPE);
            JsonNode node = jsonMapper.readTree(json);
            //DataFormat dataFormat = jsonMapper.readValue(json, DataFormat.class);
            String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
            Assert.assertEquals("<root><element>78</element><list><element>1</element><element>2</element><element>3</element></list><root>", xml);
        }catch (Exception e) {
            Assert.fail(e.toString());
        }
    }

    @Test
    public void parseRootFromXmlUsingTree () {

        String xml =
                "<root>\n" +
                        "<element>78</element>\n" +
                        "<list>\n" +
                        "<element>1</element>\n" +
                        "<element>2</element>\n" +
                        "<element>3</element>\n" +
                        "</list>\n" +
                "</root>";

        String jsonString = "{\n" +
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

        ObjectMapper jsonMapper = new ObjectMapper();
        ObjectMapper xmlMapper = new XmlMapper();
        try{

            JsonNode node = xmlMapper.readTree(xml);
            String json = jsonMapper.writeValueAsString(node);

            Assert.assertEquals(jsonString, json);

        }catch (Exception e) {
            Assert.fail(e.toString());
        }
    }
}