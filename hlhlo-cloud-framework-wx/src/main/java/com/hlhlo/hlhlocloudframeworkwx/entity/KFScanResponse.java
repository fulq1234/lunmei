package com.hlhlo.hlhlocloudframeworkwx.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * 将消息转发到客服
 */
//@XmlRootElement(name="xml")//xml文件的根元素
//@XmlAccessorType(XmlAccessType.FIELD)//控制默认情况下是否对字段或Javabean属性进行系列化
@Data
public class KFScanResponse {
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
    private String MsgType = "transfer_customer_service";

    /**
     * 如果您有多个客服人员同时登录了客服并且开启了自动接入在进行接待，每一个客户的消息转发给客服时，多客服系统会将客户分配给其中一个客服人员。如果您希望将某个客户的消息转给指定的客服来接待，可以在返回transfer_customer_service消息时附上TransInfo信息指定一个客服帐号。 需要注意，如果指定的客服没有接入能力(不在线、没有开启自动接入或者自动接入已满)，该用户会被直接接入到指定客服，不再通知其它客服，不会被其他客服接待。建议在指定客服时，先查询客服的接入能力（获取在线客服接待信息接口），指定到有能力接入的客服，保证客户能够及时得到服务。
     */
    //@XmlElement(name = "TransInfo")
    private KFScanTransInfo TransInfo;


}

