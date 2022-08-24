package models.creatures;

public class Employee extends Person {
    private String employeeId;
    private String employeeQualifications;
    private String employeePosition;
    private String employeeSalary;

    public Employee() {}

    public Employee(String name, String birthday, String gender, int idNumber, int phoneNumber, String emailAddress,
                    String employeeId, String employeeQualifications, String employeePosition, String employeeSalary) {
        super(name, birthday, gender, idNumber, phoneNumber, emailAddress);
        this.employeeId = employeeId;
        this.employeeQualifications = employeeQualifications;
        this.employeePosition = employeePosition;
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Employee{" +
                "employeeId=" + employeeId +
                ", employeeQualifications='" + employeeQualifications + '\'' +
                ", employeePosition='" + employeePosition + '\'' +
                ", employeeSalary='" + employeeSalary + '\'' +
                '}';
    }
}
