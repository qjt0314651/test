package com.dj.xk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.xk.pojo.User;
import java.util.List;

/**
 * @author qjt
 * @version 1.0
 * @date 2019/11/5 11:56
 */
public interface UserService {
    /**
     * 查询全部
     * @return
     */
    IPage<User> findAll(Page<User> page) throws Exception;

    /**
     * 注册用户
     * @param user
     */
    void addUser(User user)throws Exception;

    /**
     * 删除用户
     * @param id
     */
    void delUser(Integer id)throws Exception;

    /**
     * 据id查找信息
     * @param id
     * @return
     * @throws Exception
     */
    User queryById(Integer id)throws Exception;

    /**
     * 用户修改
     * @param user
     * @throws Exception
     */
    void updUser(User user)throws Exception;

    /**
     * 用户的登录
     * @param user
     * @return
     * @throws Exception
     */
    User login(User user)throws Exception;

    /**
     * 登录
     * @param name
     * @param pwd
     */
    User login1(String name, String pwd);

    List<User> findAlls();
}
