package com.java18.nikolaos.used.controller;

import com.java18.nikolaos.used.model.UsedProduct;
import com.java18.nikolaos.used.model.service.ProductService;
import com.java18.nikolaos.used.model.service.UsedCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.java18.nikolaos.used.model.service.ProductService.PRODUCT_STATUS_PUBLISHED;

@Controller
@RequestMapping("/CollectService")
public class UsedCollectController {

    @Autowired
    private UsedCollectService usedCollectService;

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String,String>> addNewCollect(
            @RequestBody Map<String, Integer> data
    ){
        Integer productId = data.get("productId");
        Integer memberId = data.get("memberId");
        Map<String, String> map;
        map = checkProductAndMemberStatus(productId, memberId);
        if(map.containsKey("success")){
            return ResponseEntity.ok(usedCollectService.addNewCollect(productId, memberId));
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }

    @DeleteMapping(path = "/remove", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String,String>> removeCollect(
            @RequestBody Map<String, Integer> data
    ){
        Integer productId = data.get("productId");
        Integer memberId = data.get("memberId");
        Map<String, String> map;
        map = checkProductAndMemberStatus(productId, memberId);
        if(map.containsKey("success")){
            return ResponseEntity.ok(usedCollectService.deleteCollect(productId, memberId));
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }

    private Map<String, String> checkProductAndMemberStatus(Integer productId, Integer memberId){
        HashMap<String, String> map = new HashMap<>();
        if(memberId == null){
            map.put("fail","使用者未登入");
            return map;
        }
        if(productId == null){
            map.put("fail","未指定商品");
            return map;
        }
        UsedProduct product = productService.getProduct(productId);
        System.out.println("product="+product);
        if(product == null){
            map.put("fail","找不到該項商品");
        }else if(!PRODUCT_STATUS_PUBLISHED.equals(product.getStatus())){
            map.put("fail","找不到該項商品");
        }else {
            map.put("success","");
        }
        return map;
    }
}
