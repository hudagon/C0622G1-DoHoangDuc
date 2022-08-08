package ss5_access_modifier_static.practice.demo;

public class Main {
    public static void main(String[] args) {
        Student hocSinh1 = new Student("Vịnh", 10);
        Student hocSinh2 = new Student("ĐỨc", 11);
        Student hocSinh3 = new Student("ĐỨc", 11);
        Student hocSinh4 = new Student("ĐỨc", 11);
        Student hocSinh5 = new Student("ĐỨc", 11);
        Student hocSinh6 = new Student("ĐỨc", 11);
        Student hocSinh7 = new Student("ĐỨc", 11);

        Student.change("DUE");

        System.out.println(hocSinh1.display());
        System.out.println(hocSinh2.display());
        System.out.println(hocSinh3.display());
        System.out.println(hocSinh4.display());
        System.out.println(hocSinh5.display());
        System.out.println(hocSinh6.display());
        System.out.println(hocSinh7.display());

    }
}
