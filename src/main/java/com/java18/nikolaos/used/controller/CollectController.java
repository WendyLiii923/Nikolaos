package com.java18.nikolaos.used.controller;

<<<<<<< HEAD
import static com.java18.nikolaos.used.model.service.impl.ProductServiceImpl.PRODUCT_STATUS_PUBLISHED;

import java.util.HashMap;
import java.util.Map;

=======
import com.java18.nikolaos.used.model.Members;
import com.java18.nikolaos.used.model.ProductInfoView;
import com.java18.nikolaos.used.model.UsedCollectView;
import com.java18.nikolaos.used.model.UsedProduct;
import com.java18.nikolaos.used.model.service.ProductService;
import com.java18.nikolaos.used.model.service.CollectService;
import com.java18.nikolaos.used.model.util.Page;
import com.java18.nikolaos.used.model.util.PageInfo;
import com.java18.nikolaos.used.model.util.PageInfo.Sort;
import com.java18.nikolaos.used.model.util.PageInfo.Sort.Direction;
>>>>>>> 8295c552b60b5263c4e6c854a43682a8f2b074f6
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
=======
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
>>>>>>> 8295c552b60b5263c4e6c854a43682a8f2b074f6

import com.java18.nikolaos.used.model.ProductInfoView;
import com.java18.nikolaos.used.model.UsedCollect;
import com.java18.nikolaos.used.model.service.CollectService;
import com.java18.nikolaos.used.model.service.ProductService;
import com.java18.nikolaos.used.model.util.Page;
import com.java18.nikolaos.used.model.util.PageInfo;
import com.java18.nikolaos.used.model.util.PageInfo.Sort;
import com.java18.nikolaos.used.model.util.PageInfo.Sort.Direction;

@Controller
@SessionAttributes("loginMember")
@RequestMapping("/CollectService")
public class CollectController {

    @Autowired
    private CollectService collectService;

    @Autowired
    private ProductService productService;

    @GetMapping("/showCollectList")
    public String showCollectList(
            Model model,
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "10") Integer limit,
            @SessionAttribute("loginMember") Members member
    ){
        Sort sort = new Sort(Direction.DESC, new String[]{"createTime"});
        PageInfo pageInfo = new PageInfo(limit, currentPage, sort);
        Page<UsedCollectView> collectPage = collectService.getCurrentPageCollectList(member.getId(), pageInfo);
        model.addAttribute("collectPage", collectPage);
        return "used/Collect";
    }

    @GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<UsedCollectView>> getCollectList(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "10") Integer limit,
            @SessionAttribute("loginMember") Members member
    ){
        Sort sort = new Sort(Direction.DESC, new String[]{"createTime"});
        PageInfo pageInfo = new PageInfo(limit, currentPage, sort);
        return ResponseEntity.ok(collectService.getCurrentPageCollectList(member.getId(), pageInfo));
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String,String>> addNewCollect(
            @RequestParam Integer productId,
            @SessionAttribute("loginMember") Members member
    ){
        Map<String, String> map;
        map = checkProductAndMemberStatus(productId, member.getId());
        if(map.containsKey("success")){
            return ResponseEntity.ok(collectService.addNewCollect(productId, member.getId()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }

    @DeleteMapping(path = "/remove", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String,String>> removeCollect(
            @RequestParam Integer productId,
            @SessionAttribute("loginMember") Members member
    ){
        Map<String, String> map;
        map = checkProductAndMemberStatus(productId, member.getId());
        if(map.containsKey("success")){
            return ResponseEntity.ok(collectService.deleteCollect(productId, member.getId()));
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
        ProductInfoView product = productService.getProduct(productId);
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
