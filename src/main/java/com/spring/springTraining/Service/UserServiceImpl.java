package com.spring.springTraining.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.spring.springTraining.Model.User;
import com.spring.springTraining.Service.Interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public String getUsers() {
        return "inside service getUsers";
    }

    @Override
    public int getUserById(int id) {
        return id;
    }

    @Override
    public User postUser(User user) {
        return user;
    }

    @Override
    public JsonNode postJsonUser(JsonNode jsonNode) {
        return jsonNode;
    }

    @Override
    public User deleteUser(User user) {
        return user;
    }

    @Override
    public User updateUser(User user) {
        return user;
    }
}
