package ss5_access_modifier_static.exercise.build_only_written_by_java_class;

public class Student {
    private String name = "John";
    private String classes = "C02";

    public Student() {};

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String display() {
        return this.name + " studies in the class of " + classes;
    }
}
