package bai_tap_them.bai_1.model;

public class Teacher extends Person {
    private String expertiseAt;

    public Teacher() {}

    public Teacher(int id, String name, String birthday, String gender, String expertiseAt) {
        super(id, name, birthday, gender);
        this.expertiseAt = expertiseAt;
    }

    public String getExpertiseAt() {
        return expertiseAt;
    }

    public void setExpertiseAt(String expertiseAt) {
        this.expertiseAt = expertiseAt;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", birthday='" + super.getBirthday() + '\'' +
                ", expertiseAt='" + this.getExpertiseAt() + '\'' +
                ", gender='" + this.getGender() + '\'' +
                '}';
    }
}
