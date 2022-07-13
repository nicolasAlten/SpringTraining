package com.spring.springTraining.Controller;

import com.spring.springTraining.Model.Menu;
import com.spring.springTraining.Service.Interfaces.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/getMenu")
    public String getMenu(){
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

    @PostMapping("/setMenu")
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
