package com.hlhlo.hlhlocloudframeworkwx.controller;

import com.hlhlo.hlhlocloudframeworkwx.entity.KFAccountRequest;
import com.hlhlo.hlhlocloudframeworkwx.entity.KFList;
import com.hlhlo.hlhlocloudframeworkwx.entity.BaseAccessTokenResponse;
import com.hlhlo.hlhlocloudframeworkwx.entity.BaseResponse;
import com.hlhlo.hlhlocloudframeworkwx.service.WxKFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class TestTestController {

    private String appId = "wxec40750a90b478e5";
    private String appSecret = "87eb940de1cd6a9f02258162b2ccf80d";
    @Autowired
    private WxKFService kf;

    @PostMapping("/add")
    @ResponseBody
    public BaseResponse addkf(KFAccountRequest account){
        BaseAccessTokenResponse atResponse = kf.getAccessToken(appId,appSecret);

        if(account == null){
            account.setAccessToken(account.getAccessToken());
            account.setKfAccount("test1@test");
            account.setNickName("客服1");
            account.setPassword("pswmd5");
        }

        account.setAccessToken(atResponse.getAccessToken());
        BaseResponse response = kf.addAccount(account);
        return response;
    }

    @PostMapping("/uploadHImg")
    @ResponseBody
    public BaseResponse uploadHeaderImg(@RequestParam(value="kfAccount") String kfAccount, @RequestParam(value="filePath") String filePath){
        BaseAccessTokenResponse atResponse = kf.getAccessToken(appId,appSecret);
        String accessToken = atResponse.getAccessToken();
        BaseResponse s = kf.uploadHeadImg(accessToken,kfAccount,filePath);
        return s;
    }

    /**
     * 获取所有客服
     * @return
     */
    @PostMapping("/getkflist")
    @ResponseBody
    public KFList getkflist(){
        BaseAccessTokenResponse atResponse = kf.getAccessToken(appId,appSecret);
        KFList response = kf.getList(atResponse.getAccessToken());
        return response;
    }
}
