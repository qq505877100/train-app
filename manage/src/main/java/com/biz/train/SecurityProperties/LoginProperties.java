package com.biz.train.SecurityProperties;

import com.biz.train.enumeration.LoginType;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 10:47 2017/11/15
 */
public class LoginProperties {
    private  String loginUrl;
    private LoginType loginType = LoginType.REDIRECT;

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
