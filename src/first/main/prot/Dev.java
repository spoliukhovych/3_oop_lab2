package first.main.prot;

public class Dev {

    private String name;
    private String id;
    private String origin;
    private Integer price;
    private Boolean critical;
    private DeviceTypes deviceTypes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public DeviceTypes getDeviceTypes() {
        return deviceTypes;
    }

    public void setDeviceTypes(DeviceTypes deviceTypes) {
        this.deviceTypes = deviceTypes;
    }

    public Boolean isCritical() {
        return critical;
    }

    public void setCritical(Boolean critical) {
        this.critical = critical;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}