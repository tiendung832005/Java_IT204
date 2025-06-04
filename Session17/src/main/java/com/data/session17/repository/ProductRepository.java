package com.data.session17.repository;

import com.data.session17.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> getProducts(int page, int pageSize) {
        try (Session session = sessionFactory.openSession()) {
            Query<Product> query = session.createQuery("FROM Product", Product.class);
            query.setFirstResult((page - 1) * pageSize);
            query.setMaxResults(pageSize);
            return query.getResultList();
        }
    }

    public Product getProductById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Product.class, id);
        }
    }

    public List<Product> findProducts(int page, int pageSize, String filter) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Product WHERE productName LIKE :filter ORDER BY id DESC";
            return session.createQuery(hql, Product.class)
                    .setParameter("filter", "%" + filter + "%")
                    .setFirstResult((page - 1) * pageSize)
                    .setMaxResults(pageSize)
                    .getResultList();
        }
    }

    public long countProducts(String filter) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT COUNT(*) FROM Product WHERE productName LIKE :filter";
            return (long) session.createQuery(hql)
                    .setParameter("filter", "%" + filter + "%")
                    .uniqueResult();
        }
    }

    public Product findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Product.class, id);
        }
    }

    public void saveOrUpdate(Product product) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    public void deleteById(int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            if (product != null) {
                session.delete(product);
            }
            session.getTransaction().commit();
        }
    }
}