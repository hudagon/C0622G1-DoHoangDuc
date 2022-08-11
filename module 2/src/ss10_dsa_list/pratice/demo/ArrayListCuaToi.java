package ss10_dsa_list.pratice.demo;

public class ArrayListCuaToi {
    private int size;
    static final int DEFAULT_CAPACITY = 10;
    Object[] elements;

    public ArrayListCuaToi() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public ArrayListCuaToi(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must be positive");
        } else {
            []
        }
    }

    public int getSize() {
        return this.size;
    }


}
