package com.dj.xk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.xk.pojo.User;

/**
 * @author qjt
 * @version 1.0
 * @date 2019/11/5 11:52
 */
public interface UserMapper extends BaseMapper<User> {

    IPage<User> findAll(Page<User> page);
}
