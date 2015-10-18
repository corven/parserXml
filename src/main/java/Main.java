import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        try {
            ParserXML parser = new ParserXML(args[0]);
            parser.out();
        }catch (Exception ex) {
            System.out.println("Вы не указали или указали не существующий XML файл.");
        }
    }
}

