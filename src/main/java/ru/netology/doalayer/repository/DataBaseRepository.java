package ru.netology.doalayer.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class DataBaseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<String> getProductName(String name) {
        String nativeSqlQuery = "SELECT product_name FROM homework.orders " +
                "INNER JOIN homework.customers ON orders.customer_id = customers.id " +
                "WHERE lower(name) like lower(:name)";
        var query = entityManager.createNativeQuery(nativeSqlQuery);
        query.setParameter("name", name);
        @SuppressWarnings("unchecked")
        ArrayList<String> productsList = (ArrayList<String>) query.getResultList();
        System.out.println(productsList);
        return productsList;
    }
}
