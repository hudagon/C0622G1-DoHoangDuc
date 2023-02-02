package models.creatures;

public class Customer extends Person {
    private String customerClassification;
    private String address;

    public Customer() {}

    public Customer(String name, String birthday, String gender, int citizenIdentityNumber, String phoneNumber, String emailAddress,
                    String customerId, String customerClassification, String address) {
        super(name, birthday, gender, citizenIdentityNumber, phoneNumber, emailAddress, customerId);
        this.customerClassification = customerClassification;
        this.address = address;
    }

    public String getCustomerClassification() {
        return customerClassification;
    }

    public void setCustomerClassification(String customerClassification) {
        this.customerClassification = customerClassification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Customer{" +
                "customerId=" + super.getId() +
                ", customerClassification='" + customerClassification + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
