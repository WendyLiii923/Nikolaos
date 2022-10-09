package com.java18.nikolaos.used.model.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.java18.nikolaos.used.model.UsedCollectView;
import com.java18.nikolaos.used.model.dao.CollectViewDao;
import com.java18.nikolaos.used.model.dao.util.BaseQuery;
import com.java18.nikolaos.used.model.util.PageInfo;

@Repository
public class CollectViewDaoImpl extends BaseQuery<UsedCollectView> implements CollectViewDao {

    private String selectCollectByMemberId = "FROM com.java18.nikolaos.used.model.UsedCollectView WHERE memberId=:memberId";

    @Override
    public List<UsedCollectView> getCollectListWithPage(Integer memberId, PageInfo pageInfo) {
        Query<UsedCollectView> query = getSession().createQuery(selectCollectByMemberId, UsedCollectView.class);
        query.setParameter("memberId", memberId);
        return getListWithPage(query, pageInfo);
    }

    @Override
    public List<UsedCollectView> getUserAllCollectList(Integer memberId) {
        Query<UsedCollectView> query = getSession().createQuery(selectCollectByMemberId, UsedCollectView.class);
        query.setParameter("memberId", memberId);
        return query.getResultList();
    }

}
