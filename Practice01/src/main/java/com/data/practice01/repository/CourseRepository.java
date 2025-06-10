package com.data.practice01.repository;

import com.data.practice01.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Repository
public class CourseRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Course> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Course> query = session.createQuery("FROM Course", Course.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Course findById(Set<Long> id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Course.class, (Serializable) id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void save(Course course) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(course);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Course course = session.get(Course.class, id);
            if (course != null) {
                session.delete(course);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean hasStudents(int courseId) {
        try (Session session = sessionFactory.openSession()) {
            Query<Long> query = session.createQuery(
                    "SELECT COUNT(s) FROM Student s JOIN s.courses c WHERE c.id = :courseId",
                    Long.class
            );
            query.setParameter("courseId", courseId);
            Long count = query.getSingleResult();
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}