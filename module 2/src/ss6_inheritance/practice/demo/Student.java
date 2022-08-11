package ss6_inheritance.practice.demo;


import java.util.Calendar;

public class Student extends Person {
    private int score;

    public Student(String name) {
        super(name);
    }

    public Student() {
        super();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return super.getName();
    }
}
