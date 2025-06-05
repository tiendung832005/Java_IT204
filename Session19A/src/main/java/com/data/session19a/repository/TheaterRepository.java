package com.data.session19a.repository;

import com.data.session19a.entity.Theater;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TheaterRepository {
    private final SessionFactory sessionFactory;

    public TheaterRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Theater> findAllTheaters(int page, int size) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Theater", Theater.class)
                    .setFirstResult((page - 1) * size)
                    .setMaxResults(size)
                    .list();
        }
    }

    public void saveTheater(Theater theater) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(theater);
            session.getTransaction().commit();
        }
    }

    public Theater findTheaterById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Theater.class, id);
        }
    }

    public void updateTheater(Theater theater) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(theater);
            session.getTransaction().commit();
        }
    }

    public void deleteTheater(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Theater theater = session.get(Theater.class, id);
            if (theater != null) {
                session.delete(theater);
            }
            session.getTransaction().commit();
        }
    }

    public void setTheaterStatus(Long id, boolean status) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Theater theater = session.get(Theater.class, id);
            if (theater != null) {
                theater.setStatus(status);
                session.update(theater);
            }
            session.getTransaction().commit();
        }
    }
}