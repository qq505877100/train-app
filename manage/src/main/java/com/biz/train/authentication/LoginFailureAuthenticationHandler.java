package com.biz.train.authentication;

import com.biz.train.SecurityProperties.SecurityProperties;
import com.biz.train.enumeration.LoginType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 10:55 2017/11/15
 */
@Component("loginFailureAuthenticationHandler")
public class LoginFailureAuthenticationHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private ObjectMapper objectMapper;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        //默认是登录成功后跳转到之前访问的页面
        logger.info("配置的登录失败跳转方式：{}",securityProperties.getLogin().getLoginType());
        if (securityProperties.getLogin().getLoginType().equals(LoginType.JSON)) {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(exception));
        } else {
            //重定向
            super.onAuthenticationFailure(request,response,exception);
        }
    }
}
