package com.codecool.krk.javadatabasewebapp.dao;

import com.codecool.krk.javadatabasewebapp.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//import org.hibernate.SessionFactory;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    SessionFactory sessionFactoryy;


//    public CustomerDAOImpl(SessionFactory sessionFactoryy) {
//        this.sessionFactoryy = sessionFactoryy;
//    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        Session currentSession = sessionFactoryy.getCurrentSession();
        Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
        List<Customer> customers = theQuery.getResultList();

        return customers;
    }
}
