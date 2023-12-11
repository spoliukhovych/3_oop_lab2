package first.main.pars;

import first.main.prot.Dev;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class StAXParser {

    public List<Dev> parseStAX(File xml) throws XMLStreamException, FileNotFoundException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader;

        DevHandler devHandler = new DevHandler();
        reader = xmlInputFactory.createXMLEventReader(new FileInputStream(xml));

        while (reader.hasNext()) {
            XMLEvent nextXMLEvent = reader.nextEvent();

            if (nextXMLEvent.isStartElement()) {
                StartElement startElement = nextXMLEvent.asStartElement();

                nextXMLEvent = reader.nextEvent();
                String name = startElement.getName().getLocalPart();

                if (nextXMLEvent.isCharacters()) {
                    List<Attribute> attributesList = new ArrayList<>();
                    Iterator<Attribute> iter = startElement.getAttributes();

                    while (iter.hasNext()) {
                        attributesList.add(iter.next());
                    }

                    Map<String, String> attributeMap = new HashMap<>();

                    for (Attribute attribute : attributesList) {
                        attributeMap.put(attribute.getName().getLocalPart(), attribute.getValue());
                    }

                    devHandler.setField(name, nextXMLEvent.asCharacters().getData(), attributeMap);
                }
            }
        }

        return devHandler.getDeviceList();
    }
}
