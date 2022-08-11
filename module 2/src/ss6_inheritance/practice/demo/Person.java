package ss6_inheritance.practice.demo;

import java.util.Calendar;

public class Person {
    private String name;
    private String code;
    private int birthday;
    Calendar now = Calendar.getInstance();

    Person(String name, String code, int birthday) {
        this.name = name;
        this.birthday = birthday;
        this.code = code;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return now.get(Calendar.YEAR) - this.getBirthday();
    }

    public String info() {
        return "Person{" +
                "name ='" + name + '\'' +
                ", birthday =" + birthday +
                ", code ='" + code + '\'' +
                ", age ='" + getAge() + '\'' +
                '}';
    }

}
