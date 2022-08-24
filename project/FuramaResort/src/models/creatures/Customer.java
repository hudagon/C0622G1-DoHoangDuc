package models.creatures;

public class Customer extends Person {
    private String customerId;
    private String customerClassification;
    private String address;

    public Customer() {}

    public Customer(String name, String birthday, String gender, int idNumber, int phoneNumber, String emailAddress,
                    String customerId, String customerClassification, String address) {
        super(name, birthday, gender, idNumber, phoneNumber, emailAddress);
        this.customerId = customerId;
        this.customerClassification = customerClassification;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
                "customerId=" + customerId +
                ", customerClassification='" + customerClassification + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
