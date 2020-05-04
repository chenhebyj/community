package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public void insertOrUpdate(User user) {
        UserExample example = new UserExample();
        example.createCriteria()
                .andAccountIdEqualTo(user.getAccountId());
        List<User> userList = userMapper.selectByExample(example);
        if(userList.size() == 0){
            //插入
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModify(user.getGmtCreate());
            userMapper.insert(user);
        }else {
            //更新
            User dbUser = userList.get(0);
            User updUser = new User();
            updUser.setGmtCreate(System.currentTimeMillis());
            updUser.setGmtModify(user.getGmtCreate());
            updUser.setToken(user.getToken());
            updUser.setName(user.getName());
            updUser.setAvatarUrl(user.getAvatarUrl());
            UserExample example1 = new UserExample();
            example1.createCriteria()
                    .andIdEqualTo(dbUser.getId());
            userMapper.updateByExampleSelective(updUser,example1);

        }
    }
}
