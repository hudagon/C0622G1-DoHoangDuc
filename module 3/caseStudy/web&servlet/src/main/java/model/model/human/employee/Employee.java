package model.model.human.employee;

import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private String DateOfBirth;
    private String idCard;
    private String phoneNumber;
    private String email;
    private double salary;
    private String address;
    private int educationDegreeId;
    private int positionId;
    private int divisionId;
    private String username;

    public Employee() {
    }

    public Employee(int id, String name, String dateOfBirth, String idCard, String phoneNumber, String email,
                    double salary, String address, int educationDegreeId, int positionId, int divisionId, String username) {
        this.id = id;
        this.name = name;
        this.DateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.salary = salary;
        this.address = address;
        this.educationDegreeId = educationDegreeId;
        this.positionId = positionId;
        this.divisionId = divisionId;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", idCard='" + idCard + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                ", educationDegreeId=" + educationDegreeId +
                ", positionId=" + positionId +
                ", divisionId=" + divisionId +
                ", username='" + username + '\'' +
                '}';
    }
}
