package com.java18.nikolaos.used.model.dao;

import com.java18.nikolaos.used.model.UsedCollect;

import java.util.List;
import java.util.Map;

public interface UsedCollectDao {

    public UsedCollect createCollect(Integer productId, Integer memberId);

    public UsedCollect deleteCollect(Integer productId, Integer memberId);

    public List<UsedCollect> getCollectList(Integer memberId);

    public UsedCollect getCollectByProductIdAndMemberId(Integer productId, Integer memberId);
}
