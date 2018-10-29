package com.hlhlo.hlhlocloudframeworkwx.enums;

/**
 * 消息类型
 */
public enum MsgTypeEnum {
    text("text"),//文本类型
    news("news"),//图文
    image("image"),//图片消息
    voice("voice"),//语音消息
    music("music"),//音乐
    video("video"),//视频消息
    mpnews("mpnews"),//图文消息（点击跳转到图文消息页面）
    wxcard("wxcard"),//卡券
    miniprogrampage("miniprogrampage"),//微信小程序
    scancode_push("scancode_push"),//扫码推送
    link("link"),
    location("location"),
    event("event"),
    subscribe("subscribe"),
    unsubscribe("unsubscribe"),
    CLICK("CLICK"),
    VIEW("VIEW");
    private String name;

    private MsgTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
