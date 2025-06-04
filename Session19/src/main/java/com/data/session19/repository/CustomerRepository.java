package com.data.session19.repository;

import com.data.session19.entity.Customer;
import javassist.bytecode.stackmap.TypedBlock;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    SessionFactory sessionFactory;

    public List<Customer> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Customer", Customer.class)
                .getResultList();
    }

    public Customer findById(Long id) {
        return sessionFactory.getCurrentSession()
                .get(Customer.class, id);
    }

    public void save(Customer customer) {
        sessionFactory.getCurrentSession().saveOrUpdate(customer);
    }

    public void delete(Long id) {
        Customer customer = findById(id);
        if(customer != null){
            sessionFactory.getCurrentSession().delete(customer);
        }
    }

    public List<Customer> searchByNameOrEmail(String keyword) {
        TypedQuery<Customer> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Customer WHERE firstName LIKE :keyword OR lastName LIKE :keyword", Customer.class);
        query.setParameter("keyword", "%" + keyword + "%");
        return query.getResultList();
    }
}
