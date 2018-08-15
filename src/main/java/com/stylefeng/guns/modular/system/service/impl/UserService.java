package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.persistence.dao.UserMapper;
import com.stylefeng.guns.common.persistence.model.User;
import com.stylefeng.guns.modular.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {


    @Autowired
    UserMapper userMapper;
    @Override
    @DataSource(name= DSEnum.DATA_SOURCE_GUNS)
    public User selectOne(User user) {
        return userMapper.selectOne(user);
    }
}
