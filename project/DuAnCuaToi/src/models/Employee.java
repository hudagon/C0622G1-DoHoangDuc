package models;

public class Employee extends Person {
    private double salary;
    private String department;
    private String position;

    public Employee() {
    }

    public Employee(String id, String name, String birthday, String address, String phoneNumber,
                    double salary, String department, String position) {
        super(id, name, birthday, address, phoneNumber);
        this.salary = salary;
        this.department = department;
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String getInfo() {
        return super.getId() + "," + super.getName() + "," + super.getBirthday() + "," + super.getAddress() + ","
                + super.getPhoneNumber() + "," + this.salary + "," + this.department + ","+ this.position;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + super.getId() + '\'' +
                ", name=" + super.getName() + '\'' +
                ", birthday=" + super.getBirthday() + '\'' +
                ", address=" + super.getAddress() + '\'' +
                ", phone number=" + super.getPhoneNumber() + '\'' +
                ", salary=" + salary + '\'' +
                ", department=" + department + '\'' +
                ", position=" + position + '\'' +
                '}';
    }
}
