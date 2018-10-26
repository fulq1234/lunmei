package com.hlhlo.hlhlocloudframeworkwx.entity;


import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * xml和java bean，互相转换
 * XmlAccessorType:
 FIELD:    JAXB 绑定类中的每个非静态、非瞬态字段将会自动绑定到 XML，除非由 XmlTransient 注释。
 NONE:     所有字段或属性都不能绑定到 XML，除非使用一些 JAXB 注释专门对它们进行注释。
 PROPERTY: JAXB 绑定类中的每个获取方法/设置方法对将会自动绑定到 XML，除非由 XmlTransient 注释。
 PUBLIC_MEMBER:每个公共获取方法/设置方法对和每个公共字段将会自动绑定到 XML，除非由 XmlTransient 注释。
 * @author fu
 *
 */
@XmlRootElement(name="xml")//xml文件的根元素
@XmlAccessorType(XmlAccessType.FIELD)//控制默认情况下是否对字段或Javabean属性进行系列化
@Data
public class ScanRequest {
    private Integer id;

    //文本消息内容
    @XmlElement(name="Content")
    private String content;

    //消息id，64位整型
    @XmlElement(name="MsgId")
    private Integer msgId;

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
    private String msgType;


    public ScanRequest() {
        super();
    }

    public ScanRequest(String toUserName, String fromUserName, String content) {
        super();
        setMsgType(msgType);
        setCreateTime(new Date().getTime());
        setToUserName(toUserName);
        setFromUserName(fromUserName);
        this.content = content;
    }
}
