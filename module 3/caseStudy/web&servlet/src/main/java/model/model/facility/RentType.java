package model.model.facility;

public class RentType {
    private String name;

    public RentType(String name) {
        this.name = name;
    }

    public RentType() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RentType{" +
                "name='" + name + '\'' +
                '}';
    }
}
