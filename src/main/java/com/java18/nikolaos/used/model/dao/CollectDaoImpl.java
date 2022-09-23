package com.java18.nikolaos.used.model.dao;

import com.java18.nikolaos.used.model.UsedCollect;
import com.java18.nikolaos.used.model.dao.util.BaseQuery;
import com.java18.nikolaos.used.model.util.PageInfo;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CollectDaoImpl extends BaseQuery<UsedCollect> implements CollectDao {

    private String selectCollectByMemberIdAndProductId = "FROM com.java18.nikolaos.used.model.UsedCollect WHERE memberId=:memberId AND productId=:productId";
    private String selectCollectByMemberId = "FROM com.java18.nikolaos.used.model.UsedCollect WHERE memberId=:memberId";

    @Override
    public UsedCollect createCollect(Integer productId, Integer memberId) {
        UsedCollect collect = new UsedCollect();
        try {
            collect.setMemberId(memberId);
            collect.setProductId(productId);
            getSession().save(collect).toString();
            return collect;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UsedCollect deleteCollect(Integer productId, Integer memberId) {
        Query<UsedCollect> query = getSession().createQuery(selectCollectByMemberIdAndProductId, UsedCollect.class);
        query.setParameter("memberId", memberId);
        query.setParameter("productId", productId);
        UsedCollect collect = getOne(query);
        if(collect != null){
            try {
                getSession().delete(collect);
                return collect;
            }catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override
    public List<UsedCollect> getAllCollectList(Integer memberId) {
        Query<UsedCollect> query = getSession().createQuery(selectCollectByMemberId, UsedCollect.class);
        query.setParameter("memberId", memberId);
        return query.getResultList();
    }

    @Override
    public List<UsedCollect> getCollectListWithPage(Integer memberId, PageInfo pageInfo) {
        Query<UsedCollect> query = getSession().createQuery(selectCollectByMemberId, UsedCollect.class);
        query.setParameter("memberId", memberId);
        return getListWithPage(query, pageInfo);
    }


    @Override
    public UsedCollect getCollectByProductIdAndMemberId(Integer productId, Integer memberId) {
        Query<UsedCollect> query = getSession().createQuery(selectCollectByMemberIdAndProductId, UsedCollect.class);
        query.setParameter("memberId", memberId);
        query.setParameter("productId", productId);
        return getOne(query);
    }
}
