package model.creature;

public class Customer extends Person {
    private String customerId;

    public Customer() {}

    public Customer(String customerId) {
        this.customerId = customerId;
    }

    public Customer(String name, int age, String customerId) {
        super(name, age);
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Customer{" +
                "customerId='" + customerId + '\'' +
                '}';
    }
}
