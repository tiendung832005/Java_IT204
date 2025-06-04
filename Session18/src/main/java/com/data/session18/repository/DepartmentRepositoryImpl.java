package com.data.session18.repository;

import com.data.session18.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepositoryImpl extends DepartmentRepository {
    private SessionFactory sessionFactory;

    public DepartmentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Department> findAll() {
        Session session = sessionFactory.openSession();

        // hql
        Query<Department> query = session.createQuery("FROM Department");
        // native sql
//        Query<Department> query = session.createSQLQuery("SELECT * FROM department");
        List<Department> departments = query.getResultList();
        return departments;
    }
}