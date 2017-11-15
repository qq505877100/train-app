package com.biz.train.SecurityProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 10:47 2017/11/15
 */
@ConfigurationProperties(prefix = "com.biz")
public class SecurityProperties {
    private LoginProperties login = new LoginProperties();

    public LoginProperties getLogin() {
        return login;
    }

    public void setLogin(LoginProperties login) {
        this.login = login;
    }
}
