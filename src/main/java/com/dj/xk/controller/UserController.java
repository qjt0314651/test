package com.dj.xk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.xk.common.RedisUtils;
import com.dj.xk.common.ResultModel;
import com.dj.xk.pojo.User;
import com.dj.xk.pojo.UserQuery;
import com.dj.xk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qjt
 * @version 1.0
 * @date 2019/11/5 15:13
 */
@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;
    @Resource
    private RedisUtils redisUtils;


    @RequestMapping("add")
    public ResultModel add(User user) throws Exception {
        userService.addUser(user);
        return new ResultModel().success();
    }

    @RequestMapping("show")
    public ResultModel show(UserQuery userQuery) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Page<User> page = new Page<>((userQuery.getPageNo()-1) * 2, 2);
        IPage<User> pageInfo = userService.findAll(page);
        map.put("userList", pageInfo.getRecords());
        map.put("pages",pageInfo.getTotal());
        return new ResultModel().success(map);
    }

    /**
     * 删除用户
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("del/{id}")
    public ResultModel del(@PathVariable Integer id) throws Exception {
        userService.delUser(id);
        return new ResultModel().success();
    }

    /**
     * 修改用户
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping("update")
    public ResultModel update(User user) throws Exception {
        userService.updUser(user);
        return new ResultModel().success();
    }

    /**
     * 用戶登陸
     * @param user
     * @return
     */
    @RequestMapping("login")
    public ResultModel login(User user) throws Exception {
        User user1 = userService.login(user);
        if(user1 == null){
            return  new ResultModel().error("輸入錯誤");
        }
        redisUtils.set("name", user1.getName(), 60);
        return new ResultModel().success();
    }
}
