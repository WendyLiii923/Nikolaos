package com.java18.nikolaos.used.model.dao;

import com.java18.nikolaos.used.model.UsedCollect;

public interface CollectDao {

    public UsedCollect createCollect(Integer productId, Integer memberId);

    public UsedCollect deleteCollect(Integer productId, Integer memberId);

    public UsedCollect getCollectByProductIdAndMemberId(Integer productId, Integer memberId);
}
