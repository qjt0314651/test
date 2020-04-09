package com.dj.xk.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.xk.mapper.UserMapper;
import com.dj.xk.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author qjt
 * @version 1.0
 * @date 2019/11/5 11:56
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 用户展示
     * @return
     */
    @Override
    public IPage<User> findAll(Page<User> page) {
        return userMapper.findAll(page);
    }

    /**
     * 注册用户
     * @param user
     */
    @Override
    public void addUser(User user) {
        this.save(user);
    }

    /**
     * 删除用户
     * @param id
     */
    @Override
    public void delUser(Integer id) {
        this.removeById(id);
    }

    /**
     * 据用户id 查找信息
     * @param id
     * @return
     */
    @Override
    public User queryById(Integer id) {
        return this.getById(id);
    }

    /**
     * 修改
     * @param user
     */
    @Override
    public void updUser(User user) {
        this.saveOrUpdate(user);
    }

    /**
     * 登陸
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", user.getName());
        queryWrapper.eq("pwd", user.getPwd());
        return this.getOne(queryWrapper);
    }

    /**
     * 登录
     * @param name
     * @param pwd
     */
    @Override
    public User login1(String name, String pwd) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        queryWrapper.eq("pwd", pwd);
        return this.getOne(queryWrapper);
    }

    @Override
    public List<User> findAlls() {
        return this.list();
    }
}
