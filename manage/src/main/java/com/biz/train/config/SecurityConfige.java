package com.biz.train.config;

import com.biz.train.authentication.LoginFailureAuthenticationHandler;
import com.biz.train.authentication.LoginSuccessAuthenticationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 17:42 2017/11/14
 */
@Configuration
public class SecurityConfige extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginFailureAuthenticationHandler loginFailureAuthenticationHandler;
    @Autowired
    private LoginSuccessAuthenticationHandler loginSuccessAuthenticationHandler;

    @Bean
    public PasswordEncoder getPasswordEncode() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/loginHandler")//定义form表单的提交路径
                .successHandler(loginSuccessAuthenticationHandler)
                .failureHandler(loginFailureAuthenticationHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/loginHandler","/login").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }
}
