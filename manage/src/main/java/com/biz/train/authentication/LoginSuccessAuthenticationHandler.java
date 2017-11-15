package com.biz.train.authentication;

import com.biz.train.SecurityProperties.SecurityProperties;
import com.biz.train.enumeration.LoginType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 10:53 2017/11/15
 */
@Component("loginSuccessAuthenticationHandler")
public class LoginSuccessAuthenticationHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        //默认是登录成功后跳转到之前访问的页面
        if (securityProperties.getLogin().getLoginType().equals(LoginType.JSON)) {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(authentication));
        } else {
            //重定向
            super.onAuthenticationSuccess(request, response, authentication);

        }
    }
}
