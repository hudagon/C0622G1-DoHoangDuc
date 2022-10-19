package com.repository;

import com.model.Product;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductRepositoryImpl implements IProductRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager
                .createQuery("select s from Student as s", Product.class);
        return query.getResultList();
    }
}
