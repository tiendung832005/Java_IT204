package com.data.session17.repository;


import com.data.session17.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<User> findUsers(int page, int pageSize, String filter) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM User WHERE username LIKE :filter OR email LIKE :filter ORDER BY id DESC";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("filter", "%" + filter + "%");
            query.setFirstResult((page - 1) * pageSize);
            query.setMaxResults(pageSize);
            return query.getResultList();
        }
    }

    public long countUsers(String filter) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT COUNT(*) FROM User WHERE username LIKE :filter OR email LIKE :filter";
            return (long) session.createQuery(hql)
                    .setParameter("filter", "%" + filter + "%")
                    .uniqueResult();
        }
    }

    public void updateUserStatus(int userId, String status) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, userId);
            if (user != null) {
                user.setStatus(status);
                session.update(user);
            }
            session.getTransaction().commit();
        }
    }
}
