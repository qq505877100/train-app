package com.biz.train.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author fuxianhui
 * @Description:
 * @Date: create in 11:36 2017/11/15
 */
@Controller
public class ManageController {
    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }
}
