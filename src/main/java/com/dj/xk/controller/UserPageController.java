package com.dj.xk.controller;

import com.dj.xk.pojo.User;
import com.dj.xk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qjt
 * @version 1.0
 * @date 2019/11/5 15:13
 */
@Controller
@RequestMapping("/user/")
public class UserPageController {
    @Autowired
    private UserService userService;
    /**
     * 注册用户
     * @return
     */
    @RequestMapping("toAdd")
    public String toAdd(){
        return "user/add";
    }

    @RequestMapping("toShow")
    public String toShow(){
        return "user/show";
    }


    @RequestMapping("toUpdate")
    public String toUpdate(Integer id, Model model) throws Exception {
        User user = userService.queryById(id);
        model.addAttribute("user", user);
        return "user/update";
    }

    /**
     * 用戶登陸
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "user/login";
    }
}
