package first.main.pars;

import first.main.prot.Dev;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DOMParser {

    public List<Dev> parseDOM(File xml) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xml);
            document.getDocumentElement().normalize();
            Element rootNode = document.getDocumentElement();
            DevHandler devHandler = new DevHandler();
            NodeList listOfDevices = rootNode.getElementsByTagName(devHandler.getName());

            for (int i = 0; i < listOfDevices.getLength(); i++) {
                Element deviceElement = (Element) listOfDevices.item(i);
                detouringNodes(deviceElement, devHandler);
            }
            return devHandler.getDeviceList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void detouringNodes(Node node, DevHandler devHandler) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Map<String, String> attributes = new HashMap<>();
            if (node.getAttributes() != null) {
                for (int i = 0; i < node.getAttributes().getLength(); i++) {
                    attributes.put(node.getAttributes().item(i).getNodeName(), node.getAttributes().item(i).getTextContent());
                }
            }
            devHandler.setField(node.getNodeName(), node.getTextContent(), attributes);
            if (node.getChildNodes() != null) {
                for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                    detouringNodes(node.getChildNodes().item(i), devHandler);
                }
            }
        }
    }
}
