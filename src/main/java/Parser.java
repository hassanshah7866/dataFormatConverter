import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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

        inputMapper = getMapper(inputFormat);
        outputMapper = getMapper(outputFormat);
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


    private static ObjectMapper getMapper (Format format) throws RuntimeException {

        switch (format) {

            case XML:
                return new XmlMapper();

            case JSON:
                return new ObjectMapper();

            default:
                throw new RuntimeException("Unsupported file type");
        }
    }
}