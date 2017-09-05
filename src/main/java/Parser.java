import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Parser {

    private final ObjectMapper inputMapper;
    private final ObjectMapper outputMapper;
    private final File inFile;
    private final File outFile;


    public Parser(String name, Format inputFormat, Format outputFormat) {


        inputMapper = createInputMapper(inputFormat);
        outputMapper = createOutputMapper(outputFormat);
        outputMapper.enable(SerializationFeature.INDENT_OUTPUT);
        inFile = new File(name + "." + inputFormat.toString().toLowerCase());
        outFile = new File(name + "." + outputFormat.toString().toLowerCase());
    }

    public void convert () throws IOException {

        Root root = inputMapper.readValue(inFile, Root.class);
        FileWriter fw = new FileWriter(outFile);
        fw.flush();
        BufferedWriter bw = new BufferedWriter(fw);
        outputMapper.writeValue(bw, root);
        bw.close();
    }

    private static ObjectMapper createInputMapper (Format format) {

        SimpleModule module = new SimpleModule();
        module.addDeserializer(Root.class, new RootDeserializer());
        module.addSerializer(Root.class, new RootSerializer());

        switch (format) {

            case XML:
                return new XmlMapper();

            case JSON:
                ObjectMapper jsonMapper = new ObjectMapper();
                jsonMapper.registerModule(module);
                return jsonMapper;

            default:
                throw new RuntimeException("Unsupported file type");
        }

    }

    private static ObjectMapper createOutputMapper (Format format) {

        SimpleModule module = new SimpleModule();
        module.addDeserializer(Root.class, new RootDeserializer());
        module.addSerializer(Root.class, new RootSerializer());

        switch (format) {

            case XML:

                XmlMapper xmlMapper = new XmlMapper();
                xmlMapper.registerModule(module);
                return xmlMapper;

            case JSON:

                ObjectMapper jsonMapper = new ObjectMapper();
                jsonMapper.registerModule(module);
                jsonMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
                return jsonMapper;

            default:
                throw new RuntimeException("Unsupported file type");
        }
    }
}