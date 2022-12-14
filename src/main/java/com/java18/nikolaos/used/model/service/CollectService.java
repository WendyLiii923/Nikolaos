package com.java18.nikolaos.used.model.service;

import java.util.Map;
import com.java18.nikolaos.used.model.UsedCollectView;
import com.java18.nikolaos.used.model.util.Page;
import com.java18.nikolaos.used.model.util.PageInfo;

public interface CollectService {

	Map<String, String> addNewCollect(Integer productId, Integer memberId);

	Map<String, String> deleteCollect(Integer productId, Integer memberId);

	Page<UsedCollectView> getCurrentPageCollectList(Integer memberId, PageInfo pageInfo);

}