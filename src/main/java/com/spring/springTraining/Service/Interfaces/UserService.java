package com.spring.springTraining.Service.Interfaces;

import com.fasterxml.jackson.databind.JsonNode;
import com.spring.springTraining.Entity.UserEntity;
import com.spring.springTraining.Model.User;

import java.util.List;

public interface UserService {
    List<UserEntity> getUsers();
    UserEntity getUserById(int id);
    UserEntity postUser(UserEntity user);
    JsonNode postJsonUser(JsonNode jsonNode);
    String deleteUser(int id);
    UserEntity updateUser(UserEntity user);
}
