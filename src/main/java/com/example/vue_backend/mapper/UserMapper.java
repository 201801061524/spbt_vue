package com.example.vue_backend.mapper;

import com.example.vue_backend.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;


//@Mapper
public interface UserMapper {


    @Select("select * from vue_table")
    List<User> findAll();

    @Insert("insert into vue_table(username,password,nickname,email,phone,address) VALUES (#{username}, #{password}, #{nickname}, #{email}, #{phone}, #{address});")
    int insert(User user);

    int update(User user);

    @Delete("delete from vue_table where id = #{id}")
    Integer deleteById(Integer id);

    @Select("select * from vue_table where username like ${username} limit #{pageNum},#{pageSize}")
    List<User>  selectPage(Integer pageNum, Integer pageSize,String username);

    @Select("select count(*) from vue_table  where username like #{username}")
    Integer selectTotal(String username);
}

