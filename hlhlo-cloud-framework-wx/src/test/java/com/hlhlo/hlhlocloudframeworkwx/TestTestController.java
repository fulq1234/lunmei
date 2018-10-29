package com.hlhlo.hlhlocloudframeworkwx;

import com.hlhlo.hlhlocloudframeworkwx.entity.BaseAccessTokenResponse;
import com.hlhlo.hlhlocloudframeworkwx.entity.BaseResponse;
import com.hlhlo.hlhlocloudframeworkwx.entity.KFAccountRequest;
import com.hlhlo.hlhlocloudframeworkwx.service.WxKFService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.RunAs;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTestController {
    private String appId = "wxec40750a90b478e5";
    private String appSecret = "87eb940de1cd6a9f02258162b2ccf80d";
    @Autowired
    private WxKFService kf;

    /**
     * 新增客服
     */
    @Test
    public void addkf(){
        BaseAccessTokenResponse atResponse = kf.getAccessToken(appId,appSecret);

        KFAccountRequest account = new KFAccountRequest();
        account.setAccessToken(account.getAccessToken());
        account.setKfAccount("test1@test");
        account.setNickName("客服1");
        account.setPassword("pswmd5");

        account.setAccessToken(atResponse.getAccessToken());
        BaseResponse response = kf.addAccount(account);
        System.out.println(response);
    }

    /**
     *     public BaseResponse uploadHeaderImg(@RequestParam(value="kfAccount") String kfAccount, @RequestParam(value="filePath") String filePath){
     *         BaseAccessTokenResponse atResponse = kf.getAccessToken(appId,appSecret);
     *         String accessToken = atResponse.getAccessToken();
     *         BaseResponse s = kf.uploadHeadImg(accessToken,kfAccount,filePath);
     *         return s;
     *     }
     *
     *
     *      * 获取所有客服

    public KFList getkflist() {
     *BaseAccessTokenResponse atResponse = kf.getAccessToken(appId, appSecret);
     *KFList response = kf.getList(atResponse.getAccessToken());
     *return response;
     *}
     */
}
