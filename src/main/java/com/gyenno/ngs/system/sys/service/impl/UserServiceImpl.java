package com.gyenno.ngs.system.sys.service.impl;

import com.gyenno.ngs.system.sys.entity.User;
import com.gyenno.ngs.system.sys.mapper.UserMapper;
import com.gyenno.ngs.system.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author fancyliu
 * @since 2020-02-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    private UserMapper userMapper;

}
