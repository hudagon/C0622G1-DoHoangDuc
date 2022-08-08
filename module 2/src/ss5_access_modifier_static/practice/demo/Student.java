package ss5_access_modifier_static.practice.demo;

public class Student {
    private String name;
    private int code;
    public static String college = "CODEGYM";

    Student(String name, int code) {
        this.name = name;
        this.code = code;
    }


    static void change(String college1) {
        college = college1;
    }

    String display() {
        return "Học sinh + " + this.name + " có mã số " + this.code + " học ở" + college;
    }

}
