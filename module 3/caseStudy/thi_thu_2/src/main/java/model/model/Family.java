package model.model;

public class Family {
    private int id;
    private String hostName;
    private String initialDate;
    private String address;

    public Family() {
    }

    public Family(int id, String hostName, String initialDate, String address) {
        this.id = id;
        this.hostName = hostName;
        this.initialDate = initialDate;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", hostName='" + hostName + '\'' +
                ", initialDate='" + initialDate + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
