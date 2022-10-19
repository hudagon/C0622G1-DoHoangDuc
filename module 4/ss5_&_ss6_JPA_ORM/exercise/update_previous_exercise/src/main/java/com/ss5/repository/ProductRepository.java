package com.ss5.repository;

import com.ss5.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> getProductList() {
        TypedQuery<Product> query = em
                .createQuery("select s from Product as s", Product.class);
        return query.getResultList();
    }

    @Override
    public boolean addProduct(Product newProduct) {
        em.persist(newProduct);
        return true;
    }

    @Override
    public Product findProductById(int id) {
        TypedQuery<Product> query = em
                .createQuery("select  p from Product as p" +
                        " where p.id=:id", Product.class).setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public boolean updateProduct(Product productUpdate) {
        em.merge(productUpdate);
        return true;
    }

    @Override
    public boolean deleteProduct(int idDelete) {
        Product product = findProductById(idDelete);
        em.remove(product);
        return false;
    }

    @Override
    public List<Product> searchByName(String productNameSearch) {

        TypedQuery<Product> query = em
                .createQuery("select  p from Product as p" +
                        " where p.name=:productNameSearch", Product.class).
                        setParameter("productNameSearch", productNameSearch);
        return query.getResultList();
    }
}
