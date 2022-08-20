package ss12_map_tree.exercise.practice_using_arrayList_linkedlist_in_java_collection_framework.service.impl;

import ss12_map_tree.exercise.practice_using_arrayList_linkedlist_in_java_collection_framework.model.Product;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

    public int compare(Product o1, Product o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }


}
