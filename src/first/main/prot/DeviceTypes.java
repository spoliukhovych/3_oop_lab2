package first.main.prot;

public class DeviceTypes {
    private Boolean peripheral;
    private Short energyConsumption;
    private Boolean cooler;
    private String port;
    private String group;

    @Override
    public String toString() {
        return "DeviceTypes{" +
                "peripheral=" + peripheral +
                ", energyConsumption=" + energyConsumption +
                ", cooler=" + cooler +
                ", port='" + port + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    public Boolean isPeripheral() {
        return peripheral;
    }

    public void setPeripheral(Boolean peripheral) {
        this.peripheral = peripheral;
    }

    public Short getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(Short energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public Boolean isCooler() {
        return cooler;
    }

    public void setCooler(Boolean cooler) {
        this.cooler = cooler;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
