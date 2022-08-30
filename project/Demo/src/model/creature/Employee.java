package model.creature;

public class Employee extends Person {
    private String employeeId;

    public Employee() {}

    public Employee(String name, int age, String employeeId) {
        super(name, age);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                '}';
    }
}
