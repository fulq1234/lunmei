Page({
  data: {
    //判断小程序的API，回调，参数，组件等是否在当前版本可用。
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  onLoad: function () {
    // 查看是否授权
    /*wx.getSetting({
      success: function (res) {
        if (res.authSetting['scope.userInfo']) {
          wx.getUserInfo({
            success: function (res) {
              console.log(res);
              console.log(res.userInfo)
              console.log(res.rawData)
              console.log("signature", res.signature);
              console.log("encryptedData", res.encryptedData);
              console.log("iv", res.iv);
              //用户已经授权过
            }
          })
        }

        

      }
    })*/
    const app = getApp();
    // 登录
    wx.login({
      success: function(res){
        // ------ 获取凭证 ------
        var code = res.code;
        console.log("code",code);
       if (code) {
          // console.log('获取用户登录凭证：' + code);
          // ------ 发送凭证 ------
          wx.request({
            url: 'http://localhost:8082/wt/code2session?jscode=' + code,
            method: 'POST',
            header: {
              'content-type': 'application/json'
            },
            success: function (res) {
              if (res.statusCode == 200) {
               console.log(res.data);
               if(res.data.success){
                 console.log("---here");
                 var openid = res.data.data.openid;
                 console.log("openid", openid);
                 app.globalData.openid = openid;//把openid的值赋给全局参数
               }
              
              } else {
                console.log(res.errMsg)
              }
            }
          })
        } else {
          console.log('获取用户登录失败：' + res.errMsg);
        }
      }
    })

   
  },
  bindGetUserInfo: function (e) {
    console.log(e.detail.userInfo)
    if (e.detail.userInfo) {
      //用户按了允许授权按钮
    } else {
      //用户按了拒绝按钮
    }
  },
  formSubmit: function (e) {
    const app = getApp();
    console.log("formid",e.detail.formId);
    console.log("openid2", app.globalData.openid);
    wx.request({
      url: 'http://localhost:8082/wt/sendTM',
      data: { 'formid': '1539052612818','openid': app.globalData.openid},
      method: 'POST',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function (res) {
        console.log("success2",res);
        if (res.statusCode == 200) {

        } else {
          console.log(res.errMsg)
        }
      },
      fail(rej){
        console.log(rej)
      }
    })
  }
})
