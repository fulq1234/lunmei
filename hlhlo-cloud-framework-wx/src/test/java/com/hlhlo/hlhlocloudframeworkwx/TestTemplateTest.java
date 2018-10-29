package com.hlhlo.hlhlocloudframeworkwx;

import com.hlhlo.hlhlocloudframeworkwx.entity.*;
import com.hlhlo.hlhlocloudframeworkwx.service.WxKFService;
import com.hlhlo.hlhlocloudframeworkwx.service.WxTService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTemplateTest {
    private String appId = "wxec40750a90b478e5";
    private String appSecret = "87eb940de1cd6a9f02258162b2ccf80d";
    private String accessToken = "15_M_WUwHYflPsKY3G22ft9Z-vMDYMT6X387l-Z6E2jMExHQTaHlhZIXmee6G7fwYzQNgkmoLYShcrmebFnZqtGuDMZS0mB8wmSsq3zALmFEg7SLw5rlmgreiMf3FqwQHKzDEXlF-pJQe_17NgYQOOdAAABZZ";
    @Autowired
    private WxKFService kf;

    @Autowired
    private WxTService wxTemplateService;

    @Test
    public void testSetIndustry(){
        //BaseAccessTokenResponse atResponse = kf.getAccessToken(appId,appSecret);
        WxTSetReq template = new WxTSetReq();
        template.setIndustry_id1("1");
        template.setIndustry_id2("4");
        Object object = wxTemplateService.setIndustry(this.accessToken,template);
        System.out.println(object.toString());
    }

    @Test
    public void sendT(){
        WxTSendReq req = new WxTSendReq();
        String openid = "ddd";
        req.setTemplate_id("is9PoJNLvYHKLVsRx2ilWYEpbU3oSVmvaX0FtHyAtvM");
        req.setTouser(openid);
        req.setUrl("http://www.baidu.com");
        WxTSendDataReq ss = new WxTSendDataReq();
        WxTKeyWord kw = new WxTKeyWord();
        kw.setValue("我的吱吱");
        kw.setColor("#173177");
        ss.setKeyword1(kw);
        req.setData(ss);
        WxTSendRes template = wxTemplateService.sendTtemplate(accessToken, req);
        System.out.println(template.toString());
    }
}
