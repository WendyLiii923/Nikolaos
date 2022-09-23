package com.java18.nikolaos.used.model.service;

import com.java18.nikolaos.used.model.UsedCollect;
import com.java18.nikolaos.used.model.dao.UsedCollectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UsedCollectService {

    @Autowired
    private UsedCollectDao usedCollectDao;

    public Map<String,String> addNewCollect(Integer productId, Integer memberId){
        HashMap<String, String> map = new HashMap<>();
        if(checkIsCollectAlreadyExists(productId, memberId)){
            map.put("fail", "已收藏過此商品");
        }else{
            UsedCollect collect = usedCollectDao.createCollect(productId, memberId);
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
            UsedCollect collect = usedCollectDao.deleteCollect(productId, memberId);
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

    public Boolean checkIsCollectAlreadyExists(Integer productId, Integer memberId){
        UsedCollect collect = usedCollectDao.getCollectByProductIdAndMemberId(productId, memberId);
        return collect != null;
    }
}
