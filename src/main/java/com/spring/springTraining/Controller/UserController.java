package com.spring.springTraining.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.spring.springTraining.Model.User;
import com.spring.springTraining.Service.Interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/getUsers")
    @ResponseBody
    public String getUser(){
        return userService.getUsers();
    }

    @GetMapping("/getUserById/{id}")
    public int getUser(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @PostMapping("/postUser")
    @ResponseBody
    public User postUser(@RequestBody User user){
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

    @DeleteMapping("/deleteUser")
    @ResponseBody
    public User deleteUser(@RequestBody User user){
        logger.info("=============== inside delete method");
        return userService.deleteUser(user);
    }

    @PutMapping("/updateUser")
    @ResponseBody
    public User update(@RequestBody User user){
        logger.info("=============== inside put method");
        return userService.updateUser(user);
    }
}