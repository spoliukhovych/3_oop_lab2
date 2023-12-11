package first.main.pars;

import first.main.prot.Dev;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CustomSAXParser {

    public List<Dev> parseSAX(File xml) throws SAXException, IOException, ParserConfigurationException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser();
        DevHandler devHandler = new DevHandler();
        saxParser.parse(xml, devHandler);
        return devHandler.getDeviceList();
    }

}
