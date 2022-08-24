package ss17_binary_file.exercise.product_management_export_binary_file.service;

import java.io.IOException;

public interface IProductService {
    void add() throws IOException, ClassNotFoundException;

    void display() throws IOException, ClassNotFoundException;

    void search() throws IOException, ClassNotFoundException;
}
