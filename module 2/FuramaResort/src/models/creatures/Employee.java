package models.creatures;

public class Employee extends Person {
    private String employeeQualifications;
    private String employeePosition;
    private double employeeSalary;

    public Employee() {}

    public Employee(String name, String birthday, String gender, int citizenIdentityNumber, String phoneNumber, String emailAddress,
                    String employeeId, String employeeQualifications, String employeePosition, double employeeSalary) {
        super(name, birthday, gender, citizenIdentityNumber, phoneNumber, emailAddress, employeeId);
        this.employeeQualifications = employeeQualifications;
        this.employeePosition = employeePosition;
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeQualifications() {
        return employeeQualifications;
    }

    public void setEmployeeQualifications(String employeeQualifications) {
        this.employeeQualifications = employeeQualifications;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Employee{" +
                "employeeId=" + super.getId() +
                ", employeeQualifications='" + employeeQualifications + '\'' +
                ", employeePosition='" + employeePosition + '\'' +
                ", employeeSalary='" + employeeSalary + '\'' +
                '}';
    }
}
