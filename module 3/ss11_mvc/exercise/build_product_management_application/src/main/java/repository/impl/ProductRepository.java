package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Fan", 9800, "None", "Company A"));
        products.add(new Product(2, "Table", 7200, "None", "Company B"));
        products.add(new Product(3, "Chair", 9360, "None", "Company C"));
        products.add(new Product(4, "Computer", 6300, "None", "Company D"));
        products.add(new Product(5, "House", 4800, "None", "Company E"));
        products.add(new Product(6, "Van", 3150, "None", "Company F"));
        products.add(new Product(7, "Oven", 1350, "None", "Company G"));
        products.add(new Product(8, "Phone", 450, "None", "Company H"));
    }


    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void editProduct(int id, String value, int parameter) {
        switch (parameter) {
            case 1:
                products.get(id - 1).setName(value);
                break;
            case 2:
                double newPrice = Double.parseDouble(value);
                products.get(id - 1).setPrice(newPrice);
                break;
            case 3:
                products.get(id - 1).setDescription(value);
                break;
            case 4:
                products.get(id - 1).setManufacturer(value);
                break;
        }
    }

    @Override
    public void deleteProduct(int id) {
        products.remove(id - 1);
    }

    @Override
    public void viewProduct(int id) {

    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productsFound = new ArrayList<>();

        for (Product x : products) {
            if (x.getName().contains(name)) {
                productsFound.add(x);
            }
        }
        return productsFound;
    }
}
