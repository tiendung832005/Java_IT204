package com.data.session19a.repository;

import com.data.session19a.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private final SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> findUsers(int page, int size) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM User", User.class)
                    .setFirstResult((page - 1) * size)
                    .setMaxResults(size)
                    .list();
        }
    }

    public void updateUserStatus(Long userId, boolean isActive) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, userId);
            if (user != null) {
                user.setIsActive(isActive);
                session.update(user);
            }
            session.getTransaction().commit();
        }
    }
}