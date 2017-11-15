package com.biz.train.po;

import org.springframework.security.core.GrantedAuthority;

/**
 * 存储权限信息的类，继承自GrantedAuthority,auth实际上就是一个字符串。
 */

public class AdminAuthority implements GrantedAuthority, Comparable<AdminAuthority> {

    private static final long serialVersionUID = -5552846571848884281L;

    private String auth = null;

    public AdminAuthority(String auth) {
        super();
        this.auth = auth;
    }

    public int hashCode() {
        return auth.hashCode();
    }

    public boolean equals(AdminAuthority oAuth) {
        return !(oAuth == null || oAuth.getAuthority() == null) && oAuth.getAuthority().equals(this.auth);
    }

    public String getAuthority() {
        return auth;
    }

    @Override
    public int compareTo(AdminAuthority oAuth) {
        if (oAuth == null || oAuth.getAuthority() == null)
            return -1;
        return oAuth.getAuthority().compareTo(this.auth);
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}
