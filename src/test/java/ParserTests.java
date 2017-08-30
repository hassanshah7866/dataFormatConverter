import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ParserTests {

    @Test
    public void instantiateDataFormatFromJsonAndXmlResultsInEqualObject () {

        String xml = "<root>\n" +
                "<element>78</element>\n" +
                "<list>\n" +
                "<element>1</element>\n" +
                "<element>2</element>\n" +
                "<element>3</element>\n" +
                "</list>\n" +
                "</root>";


        String json = "{\n" +
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

        /**
        String json = "{\n" +
                "  \"root\" : {\n" +
                "    \"element\" : {\n" +
                "      \"element\" : \"78\"\n" +
                "    },\n" +
                "    \"list\" : [ {\n" +
                "      \"element\" : \"1\"\n" +
                "    }, {\n" +
                "      \"element\" : \"2\"\n" +
                "    }, {\n" +
                "      \"element\" : \"3\"\n" +
                "    } ]\n" +
                "  }\n" +
                "}";
         */

        ObjectMapper xmlMapper = new XmlMapper();
        ObjectMapper jsonMapper = new ObjectMapper();

        try {
            //DataFormat fromXml = xmlMapper.readValue(xml, DataFormat.class);
            DataFormat fromJson = jsonMapper.readValue(json, DataFormat.class);

            //String element1 = fromXml.root.element;
            Integer element2 = fromJson.root.element;

            //Assert.assertEquals(element1, "78");
            Assert.assertEquals(element2, "78");
        }catch (IOException e){
            Assert.fail(e.toString());
        }
    }

    @Test
    public void parseElementFromJson () {


        //String json = "{\"element\": 78}";

        //String json = "{\"element\": 78, \"list\":{\"element\": [5]}}";
        String json = "{\"element\": 78, \"list\":[1,2,3]}";


        /*
        String json = "{\n" +
                "\"element\": 78,\n" +
                "\"list\": {\n" +
                "\"element\": [\n" +
                "1,\n" +
                "2,\n" +
                "3\n" +
                "]\n" +
                "}\n" +
                "}";*/

        /*String xml = "<element>78</element>\n" +
                "<list>\n" +
                "<element>1</element>\n" +
                "<element>2</element>\n" +
                "<element>3</element>\n" +
                "</list>";*/

        //ObjectMapper xmlMapper = new XmlMapper();
        ObjectMapper jsonMapper = new ObjectMapper();

        try {
            //Root rootFromXml = xmlMapper.readValue(xml, Root.class);
            Root rootFromJson = jsonMapper.readValue(json, Root.class);

            //JsonNode rootNode = jsonMapper.readTree(json).get("element");

            Integer element1 = rootFromJson.element;
            //ListClass lc = rootFromJson.listClass;
            //String element2 = rootFromXml.element;

            Assert.assertEquals((int)element1, 78);

        } catch (IOException e) {
            Assert.fail(e.toString());
        }
    }
}