package com.java18.nikolaos.used.model.service;

import com.java18.nikolaos.used.model.UsedCollect;
import com.java18.nikolaos.used.model.dao.CollectDao;
import com.java18.nikolaos.used.model.util.Page;
import com.java18.nikolaos.used.model.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CollectService {

    @Autowired
    private CollectDao collectDao;

    public Map<String,String> addNewCollect(Integer productId, Integer memberId){
        HashMap<String, String> map = new HashMap<>();
        if(checkIsCollectAlreadyExists(productId, memberId)){
            map.put("fail", "已收藏過此商品");
        }else{
            UsedCollect collect = collectDao.createCollect(productId, memberId);
            if(collect == null){
                map.put("fail", "尚未收藏成功，請稍後再試");
            }else {
                map.put("success", "成功加入收藏");
            }
        }
        return map;
    }

    public Map<String,String> deleteCollect(Integer productId, Integer memberId){
        HashMap<String, String> map = new HashMap<>();
        if(checkIsCollectAlreadyExists(productId, memberId)){
            UsedCollect collect = collectDao.deleteCollect(productId, memberId);
            if(collect == null){
                map.put("fail", "移除收藏失敗，請稍後再試");
            }else {
                map.put("success", "成功移除收藏");
            }
        }else{
            map.put("fail", "未收藏此商品");
        }
        return map;
    }

    public Page<UsedCollect> getCurrentPageCollectList(Integer memberId, PageInfo pageInfo){
        List<UsedCollect> data = collectDao.getCollectListWithPage(memberId, pageInfo);
        int totalElement = collectDao.getAllCollectList(memberId).size();
        return new Page<>(data, pageInfo.getCurrentPage(), pageInfo.getLimit(), totalElement);
    }

    private Boolean checkIsCollectAlreadyExists(Integer productId, Integer memberId){
        UsedCollect collect = collectDao.getCollectByProductIdAndMemberId(productId, memberId);
        return collect != null;
    }
}
