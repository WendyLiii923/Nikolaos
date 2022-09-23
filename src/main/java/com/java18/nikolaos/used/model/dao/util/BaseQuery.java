package com.java18.nikolaos.used.model.dao.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class BaseQuery<T> {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public T getOne(Query<T> query){
        return query.setMaxResults(1).getResultList().stream().findFirst().orElse(null);
    }
}
