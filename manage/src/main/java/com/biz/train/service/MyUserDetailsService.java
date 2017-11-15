package com.biz.train.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 17:58 2017/11/14
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        String password = passwordEncoder.encode("123456");
        logger.info("加密密码是：{}",password);
        return new User("admin",password
                , true,true,true,true
                , AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
