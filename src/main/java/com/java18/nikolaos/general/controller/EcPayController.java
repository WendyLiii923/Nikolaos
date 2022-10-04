package com.java18.nikolaos.general.controller;

import com.java18.nikolaos.used.model.UsedCollectView;
import com.java18.nikolaos.used.model.service.ProductService;
import com.java18.nikolaos.used.model.util.Page;
import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutOneTime;
import ecpay.payment.integration.domain.InvoiceObj;
import ecpay.payment.integration.exception.EcpayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/EcPay")
public class EcPayController {

    public static final Logger log = LogManager.getLogger(EcPayController.class);

    @Autowired
    private ProductService productService;

//平台商測試資料：
//特店編號(MerchantID)：3002599
//特店後台登入帳號：stagetest2
//特店後台登入密碼：test1234
//身分證末四碼：3609
//串接金鑰HashKey：spPjZn66i0OhqJsQ
//串接金鑰HashIV：hT5OJckN45isQTTs
//一般信用卡測試卡號 : 4311-9522-2222-2222 安全碼 : 222
//信用卡測試有效月/年：輸入的 MM/YYYY 值請大於現在當下時間的月年

    @GetMapping(value = "/request", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String request(HttpServletRequest req){
        String baseURL = req.getScheme() + "://"
                + req.getServerName() + ":"
                + req.getServerPort()
                + req.getContextPath();
        // without invoice
        InvoiceObj invoice = null;

        AioCheckOutOneTime obj = new AioCheckOutOneTime();
        obj.setMerchantTradeNo(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 15));
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        obj.setMerchantTradeDate(sdf.format(date));

        //TODO 實際金額 跟 商品名稱
        obj.setTotalAmount("150");
        obj.setItemName("productOne#productTwo#productThree#");

        obj.setTradeDesc("test Description");

        obj.setReturnURL(baseURL);
        obj.setNeedExtraPaidInfo("N");
        obj.setRedeem("Y");
        try {
            AllInOne all = new AllInOne("");
            return all.aioCheckOut(obj, invoice);
        } catch (EcpayException e) {
            log.error("EcpayException: "+e);
            throw new EcpayException(e.getMessage());
        } catch (IOException e) {
            log.error("IOException: "+e);
            throw new EcpayException(e.getMessage());
        } catch (ParserConfigurationException e) {
            log.error("ParserConfigurationException: "+e);
            throw new EcpayException(e.getMessage());
        } catch (SAXException e) {
            log.error("SAXException: "+e);
            throw new EcpayException(e.getMessage());
        }
    }
}
