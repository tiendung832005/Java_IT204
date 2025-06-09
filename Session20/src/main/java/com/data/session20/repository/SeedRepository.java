package com.data.session20.repository;


import com.data.session20.entity.Seed;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeedRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Seed seed) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(seed);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    public void update(Seed seed) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(seed);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    public void delete(Integer id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Seed seed = session.get(Seed.class, id);
            if (seed != null) {
                session.delete(seed);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    public Seed findById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Seed.class, id);
        }
    }

    public List<Seed> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Seed", Seed.class).list();
        }
    }

    public Seed findBySeedNameIgnoreCase(String seedName) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Seed WHERE lower(seedName) = :seedName", Seed.class)
                    .setParameter("seedName", seedName.toLowerCase())
                    .uniqueResult();
        }
    }
}
