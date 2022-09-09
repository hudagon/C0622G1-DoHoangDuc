package demo;

import java.util.Comparator;

public class SortByNameThenByScore implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        int result = o1.getId().compareTo(o2.getId());
        if (result == 0) {
            result = (int) (o1.getScore() - o2.getScore());
        }
        return result;
    }
}
