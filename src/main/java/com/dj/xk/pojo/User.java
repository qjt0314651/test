package com.dj.xk.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author qjt
 * @version 1.0
 * @date 2019/11/5 11:55
 */
@TableName("dj_user")
@Data
@Accessors(chain = true)
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 级别
     */
    private  String pwd;

    private String level;
}
