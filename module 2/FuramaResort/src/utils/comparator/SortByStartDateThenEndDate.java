package utils.comparator;

import models.things.Booking;

import java.util.Comparator;

public class SortByStartDateThenEndDate implements Comparator<Booking> {
    @Override
    public int compare(Booking o2, Booking o1) {
        int comparison = 0;
        comparison = o1.getStartDate().compareTo(o2.getStartDate());
        if (comparison == 0) {
            comparison = o1.getEndDate().compareTo(o2.getEndDate());
        }
        return comparison;
    }
}
