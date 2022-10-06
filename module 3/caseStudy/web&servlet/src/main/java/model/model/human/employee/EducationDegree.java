package model.model.human.employee;

public class EducationDegree {
    private String name;

    public EducationDegree() {
    }

    public EducationDegree(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EducationDegree{" +
                "name='" + name + '\'' +
                '}';
    }
}
