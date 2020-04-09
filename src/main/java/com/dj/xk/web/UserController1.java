package com.dj.xk.web;

import com.dj.xk.common.ResultModel;
import com.dj.xk.pojo.User;
import com.dj.xk.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qjt
 * @version 1.0
 * @date 2019/11/5 22:42
 */
@RestController
@RequestMapping("/user1/")
@Api(tags = "用户api")
public class UserController1 {

    @Autowired
    private UserService userService;

    @GetMapping("login")
    @ApiOperation(value="用户登录", notes="根据用户名和密码获取用户详细信息")
    @ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String", paramType = "query"),
                    @ApiImplicitParam(name = "pwd", value = "密码", required = true, dataType = "String", paramType = "query")
    })
    public ResultModel login(String name, String pwd){
        User user = userService.login1(name, pwd);
        if(user == null){
            return  new ResultModel().error("用户名或密码错误");
        }
        return  new ResultModel().success();
    }

    @PostMapping("addUser")
    @ApiOperation(value="用户注冊", notes="注冊用戶相关信息")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User", paramType = "body")
    public ResultModel addUser(@RequestBody User user) throws Exception {
        userService.addUser(user);
        return new ResultModel().success();
    }

    /**
     * 删除用户
     * @param id
     * @return
     * @throws Exception
     */
    @PostMapping("delUser")
    @ApiOperation(value="用户删除", notes="删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "query")
    public ResultModel addUser(Integer id) throws Exception {
        userService.delUser(id);
        return new ResultModel().success();
    }

    /**
     * 用户展示
     * @return
     * @throws Exception
     */
    @PostMapping("queryUser")
    @ApiOperation(value="用户展示", notes="用户展示的详细信息")
    public ResultModel show() throws Exception {
        List<User> alls = userService.findAlls();
        return new ResultModel().success(alls);
    }

}
