package com.dj.xk.controller;

import com.dj.xk.pojo.User;
import com.dj.xk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @author qjt
 * @version 1.0
 * @date 2019/11/5 10:31
 */
@Controller
public class Test {

    @Autowired
    private UserService userService;

    @RequestMapping("toTest")
    private String toTest(){
        return "test";
    }

   /* @RequestMapping("queryAll")
    private String queryAll(Model model){
        List<User> all = userService.findAll();
        model.addAttribute("list", all);
        return "userList";
    }*/

}
