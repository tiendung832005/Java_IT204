package com.data.session19a.repository;

import com.data.session19a.entity.ScreenRoom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScreenRoomRepository {
    private final SessionFactory sessionFactory;

    public ScreenRoomRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<ScreenRoom> findActiveScreenRooms() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM ScreenRoom WHERE status = true", ScreenRoom.class).list();
        }
    }

    public void saveScreenRoom(ScreenRoom screenRoom) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(screenRoom);
            session.getTransaction().commit();
        }
    }

    public ScreenRoom findScreenRoomById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(ScreenRoom.class, id);
        }
    }

    public void updateScreenRoom(ScreenRoom screenRoom) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(screenRoom);
            session.getTransaction().commit();
        }
    }

    public void deactivateScreenRoom(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            ScreenRoom screenRoom = session.get(ScreenRoom.class, id);
            if (screenRoom != null) {
                screenRoom.setStatus(false);
                session.update(screenRoom);
            }
            session.getTransaction().commit();
        }
    }
}
