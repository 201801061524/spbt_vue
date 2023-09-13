package com.example.vue_backend.service;

import com.example.vue_backend.entity.User;
import com.example.vue_backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int save(User user) {
        if (user.getId() == null) {
            return userMapper.insert(user);
        } else { //没有id表示为新增，否则为更新
            return userMapper.update(user);
        }

    }
}
