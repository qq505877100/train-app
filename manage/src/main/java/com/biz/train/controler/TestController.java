package com.biz.train.controler;

import com.biz.train.po.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 15:21 2017/11/15
 */
@Controller
public class TestController {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired()
    private ObjectMapper objectMapper;

    @GetMapping("/test")
    @ResponseBody
    public String test1() throws JsonProcessingException {
        String sql = "select * from test1";
        Query nativeQuery = entityManager.createNativeQuery(sql, User.class);
        List<User> resultList = nativeQuery.getResultList();
        for (User u : resultList) {
            System.out.println(u.getId() + u.getName());
        }
        System.out.println(objectMapper.writeValueAsString(resultList));

        return null;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String test2() {
        return "hello world!!好的";
    }

    @GetMapping("/hello1")
    @ResponseBody
    public String test3() {
        return "hello world111!!";
    }

    @GetMapping("/jsp")
    public String jsp212() {
        return "hello";
    }
}
