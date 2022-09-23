package com.java18.nikolaos.used.model.dao;

import com.java18.nikolaos.used.model.UsedCollect;
import com.java18.nikolaos.used.model.util.PageInfo;

import java.util.List;

public interface CollectDao {

    public UsedCollect createCollect(Integer productId, Integer memberId);

    public UsedCollect deleteCollect(Integer productId, Integer memberId);

    public List<UsedCollect> getAllCollectList(Integer memberId);

    public List<UsedCollect> getCollectListWithPage(Integer memberId, PageInfo pageInfo);

    public UsedCollect getCollectByProductIdAndMemberId(Integer productId, Integer memberId);
}
