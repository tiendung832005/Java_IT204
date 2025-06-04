package com.data.session17.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public long countUsers() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT COUNT(*) FROM Customer";
            return (long) session.createQuery(hql).uniqueResult();
        }
    }

    public long countProducts() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT COUNT(*) FROM Product";
            return (long) session.createQuery(hql).uniqueResult();
        }
    }

    public long countOrders() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT COUNT(*) FROM Order";
            return (long) session.createQuery(hql).uniqueResult();
        }
    }

    public double calculateRevenueByMonth() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT SUM(totalMoney) FROM Order WHERE MONTH(offset datetime ) = MONTH(CURRENT_DATE)";
            return (double) session.createQuery(hql).uniqueResult();
        }
    }

    public double calculateRevenueByYear() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT SUM(totalMoney) FROM Order WHERE YEAR(offset datetime ) = YEAR(CURRENT_DATE)";
            return (double) session.createQuery(hql).uniqueResult();
        }
    }
}
