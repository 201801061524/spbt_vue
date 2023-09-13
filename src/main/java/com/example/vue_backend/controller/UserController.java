package com.example.vue_backend.controller;

import com.example.vue_backend.entity.User;
import com.example.vue_backend.mapper.UserMapper;
import com.example.vue_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @PostMapping
    public Integer save(@RequestBody User user) { //新增或者更新都在这里面
        System.out.println("11111111111111111");
        int x = userService.save(user);
        ;
        System.out.println(x + "     111111111");
        return x;
    }

    @GetMapping
    public List<User> findAll() {
        List<User> all = userMapper.findAll();
        return all;
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return userMapper.deleteById(id);
    }

    // @RequestParam 接受 ?pageNum = 1 & pageSize = 10
    @GetMapping("/page") //这个接口路径就是/user/page
    public Map<String,Object> findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<User> data = userMapper.selectPage(pageNum,pageSize);
        Integer total = userMapper.selectTotal();
        Map<String,Object> res = new HashMap<>();
        res.put("data",data);
        res.put("res",total);
        return res;
    }

}
