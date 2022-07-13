package com.spring.springTraining.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.spring.springTraining.Entity.UserEntity;
import com.spring.springTraining.Model.User;
import com.spring.springTraining.Service.Interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/getUsers")
    @ResponseBody
    public List<UserEntity> getUser(){
        return userService.getUsers();
    }

    @GetMapping("/getUserById/{id}")
    @ResponseBody
    public UserEntity getUser(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @PostMapping("/postUser")
    @ResponseBody
    public UserEntity postUser(@RequestBody UserEntity user){
        logger.info("=============== inside post method");
        return userService.postUser(user);
    }

    @PostMapping(path="/postJsonUser/{id}", consumes="application/json")
    @ResponseBody
    public JsonNode postJsonUser(@RequestBody JsonNode json, @PathVariable int id){
        logger.info("=============== inside post method");
        logger.info("=============== id:" + id);
        return userService.postJsonUser(json);
    }

    @DeleteMapping("/deleteUser/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable int id){
        logger.info("=============== inside delete method");
        return userService.deleteUser(id);
    }

    @PutMapping("/updateUser")
    @ResponseBody
    public UserEntity update(@RequestBody UserEntity user){
        logger.info("=============== inside put method");
        return userService.updateUser(user);
    }
}