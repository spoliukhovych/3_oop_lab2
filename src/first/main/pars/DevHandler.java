package first.main.pars;

import first.main.prot.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DevHandler extends DefaultHandler {

    private String valueOfElement;
    private List<Dev> deviceList = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String attributeName, Attributes attributes) {
        switch (attributeName) {
            case DeviceElements.DEVICE:
                Dev device = new Dev();
                deviceList.add(device);
                break;
            case DeviceElements.DEVICE_TYPES:
                DeviceTypes types = new DeviceTypes();
                getLastDevice().setDeviceTypes(types);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String attributeName) {
        switch (attributeName) {
            case DeviceElements.ID -> getLastDevice().setId(valueOfElement);
            case DeviceElements.NAME -> getLastDevice().setName(valueOfElement);
            case DeviceElements.ORIGIN -> getLastDevice().setOrigin(valueOfElement);
            case DeviceElements.PRICE -> getLastDevice().setPrice(Integer.valueOf(valueOfElement));
            case DeviceElements.CRITICAL -> getLastDevice().setCritical(Boolean.parseBoolean(valueOfElement));
            case DeviceElements.PERIPHERAL -> getLastDevice().getDeviceTypes().setPeripheral(Boolean.parseBoolean(valueOfElement));
            case DeviceElements.ENERGY_CONSUMPTION -> getLastDevice().getDeviceTypes().setEnergyConsumption(Short.parseShort(valueOfElement));
            case DeviceElements.COOLER -> getLastDevice().getDeviceTypes().setCooler(Boolean.parseBoolean(valueOfElement));
            case DeviceElements.GROUP -> getLastDevice().getDeviceTypes().setGroup(valueOfElement);
            case DeviceElements.PORT -> getLastDevice().getDeviceTypes().setPort(valueOfElement);
        }
    }

    public void setField(String attributeName, String str, Map<String, String> attributes) {
        switch (attributeName) {
            case DeviceElements.DEVICE -> {
                Dev device = new Dev();
                deviceList.add(device);
            }
            case DeviceElements.NAME -> getLastDevice().setName(str);
            case DeviceElements.ID -> getLastDevice().setId(str);
            case DeviceElements.ORIGIN -> getLastDevice().setOrigin(str);
            case DeviceElements.PRICE -> getLastDevice().setPrice(Integer.valueOf(str));
            case DeviceElements.CRITICAL -> getLastDevice().setCritical(Boolean.parseBoolean(str));
            case DeviceElements.PERIPHERAL -> getLastDevice().getDeviceTypes().setPeripheral(Boolean.parseBoolean(str));
            case DeviceElements.ENERGY_CONSUMPTION -> getLastDevice().getDeviceTypes().setEnergyConsumption(Short.parseShort(str));
            case DeviceElements.COOLER -> getLastDevice().getDeviceTypes().setCooler(Boolean.parseBoolean(str));
            case DeviceElements.PORT -> getLastDevice().getDeviceTypes().setPort(str);
            case DeviceElements.GROUP -> getLastDevice().getDeviceTypes().setGroup(str);
            case DeviceElements.DEVICE_TYPES -> {
                DeviceTypes types = new DeviceTypes();
                getLastDevice().setDeviceTypes(types);
            }
        }
    }

    public List<Dev> getDeviceList() {
        return deviceList;
    }

    @Override
    public void startDocument() throws SAXException {
        deviceList = new ArrayList<>();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        valueOfElement = new String(ch, start, length);
    }

    private Dev getLastDevice() {
        return deviceList.get(deviceList.size() - 1);
    }

    public String getName() {
        return DeviceElements.DEVICE;
    }
}
