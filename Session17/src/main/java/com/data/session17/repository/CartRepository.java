package com.data.session17.repository;

import com.data.session17.entity.ProductCart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public ProductCart findCartItem(int customerId, int productId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM ProductCart WHERE customerId = :customerId AND productId = :productId";
            return session.createQuery(hql, ProductCart.class)
                    .setParameter("customerId", customerId)
                    .setParameter("productId", productId)
                    .uniqueResult();
        }
    }

    public void saveOrUpdateCartItem(ProductCart productCart) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(productCart);
            session.getTransaction().commit();
        }
    }

    public List<ProductCart> findCartItemsByCustomerId(int customerId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM ProductCart WHERE customerId = :customerId";
            return session.createQuery(hql, ProductCart.class)
                    .setParameter("customerId", customerId)
                    .getResultList();
        }
    }

    public ProductCart findCartItemById(int cartId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(ProductCart.class, cartId);
        }
    }

    public void deleteCartItem(ProductCart productCart) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(productCart);
            session.getTransaction().commit();
        }
    }

}
