package com.java18.nikolaos.used.model.dao;

import com.java18.nikolaos.used.model.UsedCollectView;
import com.java18.nikolaos.used.model.util.PageInfo;

import java.util.List;

public interface CollectViewDao {

    public List<UsedCollectView> getCollectListWithPage(Integer memberId, PageInfo pageInfo);

    public List<UsedCollectView> getUserAllCollectList(Integer memberId);
}
