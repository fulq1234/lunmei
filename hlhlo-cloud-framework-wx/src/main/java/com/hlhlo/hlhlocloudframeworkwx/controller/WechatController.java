package com.hlhlo.hlhlocloudframeworkwx.controller;

import com.hlhlo.hlhlocloudframeworkwx.entity.KFScanResponse;
import com.hlhlo.hlhlocloudframeworkwx.entity.ScanRequest;
import com.hlhlo.hlhlocloudframeworkwx.entity.TextScanResponse;
import com.hlhlo.hlhlocloudframeworkwx.utils.CheckUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/")
@Slf4j
public class WechatController {

    @ResponseBody
    @GetMapping("/verifyWX")
    public String verifyWX(String signature,String timestamp,String nonce,String echostr){
        if(signature == null || timestamp == null || nonce == null || echostr == null) {
            log.error("微信接入错误","微信参数有空值");
        }
        try {
            if(CheckUtil.checkSignature(signature, timestamp, nonce)){
                return echostr;
            }
        } catch (NoSuchAlgorithmException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            log.error("connection exception",e1);
        }
        log.error("微信接入错误");
        return "";
    }


    /**
     * 消息回复
     * @param scan
     * @return
     */
    @PostMapping(value = "/verifyWX")
   /* public @ResponseBody TextScanResponse weixinCreate(@RequestBody ScanRequest scan) {
        //public @ResponseBody Object weixinCreate(Scan scan) {
        if(scan == null) {
            log.error("接收到的字符串不能为空");
            return null;
        }
        log.info(scan.toString());

        String fromUserName = scan.getFromUserName();
        String toUserName = scan.getToUserName();
        TextScanResponse nscan = new TextScanResponse();
        nscan.setFromUserName(toUserName);
        nscan.setToUserName(fromUserName);
        nscan.setCreateTime(new java.util.Date().getTime());
        nscan.setContent(scan.getContent());

        return nscan;
    }*/

    /**
     * 消息转发到客服
     */
    public @ResponseBody KFScanResponse weixinCreate(@RequestBody ScanRequest scan) {
        //public @ResponseBody Object weixinCreate(Scan scan) {
        if(scan == null) {
            log.error("接收到的字符串不能为空");
            return null;
        }
        log.info(scan.toString());

        String fromUserName = scan.getFromUserName();
        String toUserName = scan.getToUserName();
        KFScanResponse nscan = new KFScanResponse();
        nscan.setFromUserName(toUserName);
        nscan.setToUserName(fromUserName);
        nscan.setCreateTime(new java.util.Date().getTime());
        return nscan;
    }


}
