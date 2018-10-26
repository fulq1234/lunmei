package com.hlhlo.hlhlocloudframeworkwx.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")//xml文件的根元素
@XmlAccessorType(XmlAccessType.FIELD)//控制默认情况下是否对字段或Javabean属性进行系列化
@Data
public class TextScanResponse {
    private Integer id;

    //接收方帐号（收到的OpenID）
    @XmlElement(name="ToUserName")
    private String toUserName;


    //开发者微信号
    @XmlElement(name="FromUserName")
    private String fromUserName;

    //消息创建时间 （整型）
    @XmlElement(name="CreateTime")
    private Long createTime;

    @XmlElement(name="MsgType")
    private String msgType = "text";

    @XmlElement(name="Content")
    private String content;

}
