package com.spring.springTraining.Service.Interfaces;

import com.fasterxml.jackson.databind.JsonNode;
import com.spring.springTraining.Model.User;

public interface UserService {
    String getUsers();
    int getUserById(int id);
    User postUser(User user);
    JsonNode postJsonUser(JsonNode jsonNode);
    User deleteUser(User user);
    User updateUser(User user);
}
