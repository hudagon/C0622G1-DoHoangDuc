package ss6_inheritance.practice.demo;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        System.out.println(person1.info());

        Student student1 = new Student();
        student1.setName("Đức");
        System.out.println(student1.info());

        Teacher teacher1 = new Teacher();
        teacher1.setName("Mr.Peter");
        System.out.println(teacher1.info());
    }
}
