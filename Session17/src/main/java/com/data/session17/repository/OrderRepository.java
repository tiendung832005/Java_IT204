package com.data.session17.repository;

import com.data.session17.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class OrderRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveOrder(Order order) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        }
    }

    public List<Order> findOrdersByCustomerId(int customerId, int page, int pageSize) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Order WHERE customerId = :customerId ORDER BY id DESC";
            Query<Order> query = session.createQuery(hql, Order.class);
            query.setParameter("customerId", customerId);
            query.setFirstResult((page - 1) * pageSize);
            query.setMaxResults(pageSize);
            return query.getResultList();
        }
    }

    public void deleteOrderById(int orderId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Order order = session.get(Order.class, orderId);
            if (order != null) {
                session.delete(order);
            }
            session.getTransaction().commit();
        }
    }

    public List<Order> findOrders(int page, int pageSize, String recipientName, Date orderDate, String status) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Order WHERE (:recipientName IS NULL OR recipientName LIKE :recipientName) " +
                    "AND (:orderDate IS NULL OR orderDate = :orderDate) " +
                    "AND (:status IS NULL OR status = :status) " +
                    "ORDER BY id DESC";
            Query<Order> query = session.createQuery(hql, Order.class);
            query.setParameter("recipientName", recipientName != null ? "%" + recipientName + "%" : null);
            query.setParameter("orderDate", orderDate);
            query.setParameter("status", status);
            query.setFirstResult((page - 1) * pageSize);
            query.setMaxResults(pageSize);
            return query.getResultList();
        }
    }

    public long countOrders(String recipientName, Date orderDate, String status) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT COUNT(*) FROM Order WHERE (:recipientName IS NULL OR recipientName LIKE :recipientName) " +
                    "AND (:orderDate IS NULL OR orderDate = :orderDate) " +
                    "AND (:status IS NULL OR status = :status)";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("recipientName", recipientName != null ? "%" + recipientName + "%" : null);
            query.setParameter("orderDate", orderDate);
            query.setParameter("status", status);
            return query.uniqueResult();
        }
    }

    public void updateOrderStatus(int orderId, String status) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Order order = session.get(Order.class, orderId);
            if (order != null) {
                order.setStatus(status);
                session.update(order);
            }
            session.getTransaction().commit();
        }
    }

    public void deleteOrder(int orderId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Order order = session.get(Order.class, orderId);
            if (order != null) {
                session.delete(order);
            }
            session.getTransaction().commit();
        }
    }
}
