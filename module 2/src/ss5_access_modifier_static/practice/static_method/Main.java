package ss5_access_modifier_static.practice.static_method;

class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();

        Student student1 = new Student(10,"Đức");

        System.out.println(student1.display());
    }
}
