package models.things;

public class Voucher {
    private String name;

    public Voucher() {
    }

    public Voucher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " off voucher";
    }
}
