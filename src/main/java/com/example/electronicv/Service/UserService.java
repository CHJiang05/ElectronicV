package com.example.electronicv.Service;

import com.example.electronicv.Mapper.UserMapper;
import com.example.electronicv.entity.User;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;



@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public String insert(int user_id, String user_name, String password, String email, String phone_number,String address) {
        userMapper.insert(user_id,user_name,password,email,phone_number,address);
        return "succeed";
    }

    public User findById(int user_id) {
        return userMapper.findById(user_id);
    }


    public void update(User user) {
        userMapper.update(user);
    }

    public void delete(int id) {
        userMapper.delete(id);
    }
}

