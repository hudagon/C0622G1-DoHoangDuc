package ss3_array_and_method_in_java.practice.demo;

import java.util.Calendar;

public class Students {
    public String name;
    public String code;
    public int birthday;

    public Students() {
        this.name = "SV Name";
        this.code = "SV Code";
        this.birthday = 2000;
    }

    public Students(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Students(String name, String code, int birthday) {
        this.name = name;
        this.code = code;
        this.birthday = birthday;
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
    public void setCode() {
        this.code = "SV000";
    }
    public void setCode(String str, int number) {
        this.code = str + number;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public void showInfo() {
        System.out.println("Student 1's info: ");
        System.out.println("Name 1: " + this.getName());
        System.out.println("Code: " + this.getCode());
        System.out.println("Birthday: " + this.getBirthday());
        System.out.println("Age: " + getAge());
    }

    public int getAge() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.YEAR) - this.birthday;
    }
}
