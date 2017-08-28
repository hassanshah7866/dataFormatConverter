import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataFormatConverter {

    public static void main (String[] args) {

        System.setProperty("log4j.configurationFile", "resources/log4j2.xml");
        Logger logger = LogManager.getLogger();

        String fileName = args[0];
        Format inputFormat = Format.valueOf(fileName.substring(fileName.indexOf(".")+1).toUpperCase());
        Format outputFormat = Format.valueOf(args[1].toUpperCase());

        if (inputFormat.equals(outputFormat)) {
            String message = "Destination format same as source. No changes made.";
            System.out.println(message);
            logger.info(message);
            System.exit(0);
        }

        Parser parser = new Parser (fileName.substring(0, fileName.indexOf(".")), inputFormat, outputFormat);
        try {
            parser.convert();
        }catch (Exception e) {
            logger.error(e.toString());
            System.out.println(e.toString());
        }
    }

}
