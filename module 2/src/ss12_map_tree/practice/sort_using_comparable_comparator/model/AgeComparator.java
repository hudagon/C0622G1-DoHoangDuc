package ss12_map_tree.practice.sort_using_comparable_comparator.model;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getAge() > o2.getAge()){
            return 1;
        }else if(o1.getAge().equals(o2.getAge())){
            return 0;
        }else{
            return -1;
        }
    }

    @Override
    public Comparator<Student> reversed() {
        return null;
    }

    @Override
    public Comparator<Student> thenComparing(Comparator<? super Student> other) {
        return null;
    }

    @Override
    public <U> Comparator<Student> thenComparing(Function<? super Student, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return null;
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Student> thenComparing(Function<? super Student, ? extends U> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Student> thenComparingInt(ToIntFunction<? super Student> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Student> thenComparingLong(ToLongFunction<? super Student> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Student> thenComparingDouble(ToDoubleFunction<? super Student> keyExtractor) {
        return null;
    }
}