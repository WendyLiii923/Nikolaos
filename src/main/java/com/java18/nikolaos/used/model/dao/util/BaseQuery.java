package com.java18.nikolaos.used.model.dao.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java18.nikolaos.used.model.util.PageInfo;

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

    public List<T> getListWithPage(Query<T> query, PageInfo pageInfo){
        Integer skip = pageInfo.getLimit() * (pageInfo.getCurrentPage() - 1);
        return query.setFirstResult(skip).setMaxResults(pageInfo.getLimit())
                .getResultList();
    }
}
