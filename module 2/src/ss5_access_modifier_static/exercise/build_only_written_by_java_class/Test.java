package ss5_access_modifier_static.exercise.build_only_written_by_java_class;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student();

        student1.setClasses("C06");
        student1.setName("Đức");
        System.out.println(student1.display());
    }
}
