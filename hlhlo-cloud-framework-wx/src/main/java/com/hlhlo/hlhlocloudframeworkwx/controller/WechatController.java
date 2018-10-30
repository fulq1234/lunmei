package com.hlhlo.hlhlocloudframeworkwx.controller;

import com.hlhlo.hlhlocloudframeworkwx.entity.KFScanResponse;
import com.hlhlo.hlhlocloudframeworkwx.entity.KFScanTransInfo;
import com.hlhlo.hlhlocloudframeworkwx.entity.ScanRequest;
import com.hlhlo.hlhlocloudframeworkwx.utils.CheckUtil;
import com.thoughtworks.xstream.XStream;
import lombok.Data;
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
     * 消息转发到客服
     */
    @PostMapping(value = "/verifyWX")
   public @ResponseBody String  weixinCreate(@RequestBody ScanRequest scan) {
        //public @ResponseBody Object weixinCreate(Scan scan) {
        if(scan == null) {
            log.error("接收到的字符串不能为空");
            return null;
        }
        log.info(scan.toString());

        String fromUserName = scan.getFromUserName();
        String toUserName = scan.getToUserName();
        System.out.println(fromUserName);
        System.out.println(toUserName);
        KFScanResponse nscan = new KFScanResponse();
        nscan.setFromUserName(toUserName);
        nscan.setToUserName(fromUserName);
        nscan.setCreateTime(new java.util.Date().getTime());

        KFScanTransInfo info = new KFScanTransInfo();
        info.setKfAccount("ddd");
        nscan.setTransInfo(info);
        XStream xStream = new XStream();
        xStream.alias("xml",nscan.getClass());;

        return xStream.toXML(nscan);
    }

    /**
     * 消息回复,测试使用
     * @param scan
     * @return
     *//*
    @PostMapping(value = "/verifyWX")
    public @ResponseBody String weixinCreate(@RequestBody ScanRequest scan) {
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

        XStream xStream = new XStream();
        xStream.alias("xml",nscan.getClass());;

        return xStream.toXML(nscan);
    }

    *//**
     * 文本回复消息
     *//*
    @Data
    class TextScanResponse {
        private Integer id;

        //接收方帐号（收到的OpenID）
        //@XmlElement(name="ToUserName")
        private String ToUserName;


        //开发者微信号
        //@XmlElement(name="FromUserName")
        private String FromUserName;

        //消息创建时间 （整型）
        //@XmlElement(name="CreateTime")
        private Long CreateTime;

        //@XmlElement(name="MsgType")
        private String MsgType = "text";

        //@XmlElement(name="Content")
        private String Content;

    }*/

}
