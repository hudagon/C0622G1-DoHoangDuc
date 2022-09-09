package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends Person {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private double score;
    private String className;
    private Date startingDate;

    public Student() {
    }

    public Student(String id, String name, String birthday, String address, String phoneNumber,
                   double score, String className, Date startingDate) {
        super(id, name, birthday, address, phoneNumber);
        this.score = score;
        this.className = className;
        this.startingDate = startingDate;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    @Override
    public String getInfo() {
        return super.getId() + "," + super.getName() + "," + super.getBirthday() + "," + super.getAddress() + ","
                + super.getPhoneNumber() + "," + this.score + "," + this.className + "," + dateFormat.format(this.startingDate);

    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + super.getId() + '\'' +
                ", name=" + super.getName() + '\'' +
                ", birthday=" + super.getBirthday() + '\'' +
                ", address=" + super.getAddress() + '\'' +
                ", phone number=" + super.getPhoneNumber() + '\'' +
                ", score=" + score +
                ", className='" + className + '\'' +
                ", startingDate=" + dateFormat.format(startingDate) +
                '}';
    }
}
