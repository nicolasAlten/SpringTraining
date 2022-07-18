package com.spring.springTraining.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.spring.springTraining.Entity.Menu;
import com.spring.springTraining.Service.Interfaces.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/getMenu")
    public List<Menu>  getMenu(){
        return menuService.getMenu();
    }

    @GetMapping("/getMenu/{id}")
    public Menu getMenuById(@PathVariable int id){
        return menuService.getMenuById(id);
    }

    @GetMapping("/getMenu/{soda}/{cake}")
    public Menu getMenuByIdAndByUser(@PathVariable String soda, @PathVariable String cake){
        return menuService.getMenuByIdAndByUser(soda,cake);
    }

    @PostMapping(path="/postJsonUser/{id}", consumes="application/json")
    @ResponseBody
    public JsonNode postJsonMenu(@RequestBody JsonNode json, @PathVariable int id){
        return menuService.postJsonMenu(json);
    }

    @PostMapping("/setMenu")
    @ResponseBody
    public Menu setMenu(@RequestBody Menu menu){
        return menuService.setMenu(menu);
    }

    @PutMapping("/setMenu")
    public Menu putMenu(@RequestBody Menu menu){
        return menuService.putMenu(menu);
    }

    @DeleteMapping("/setMenu")
    public Menu deleteMenu(@RequestBody Menu menu){
        return menuService.deleteMenu(menu);
    }
}
