package com.spring.springTraining.Controller;

import com.spring.springTraining.Model.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @GetMapping("/getMenu")
    public String getMenu(){
        return "this is the menu without id";
    }

    @GetMapping("/getMenu/{id}")
    public String getMenuById(@PathVariable int id){
        return "this is the menu with id" + id;
    }

    @GetMapping("/getMenu/{soda}/{cake}")
    public Menu getMenuByIdAndByUser(@PathVariable String soda, @PathVariable String cake){
        Menu menu = new Menu();
        menu.setCake(cake);
        menu.setSoda(soda);
        return menu;
    }

    @PostMapping("/setMenu")
    public Menu getMenu(@RequestBody Menu menu){
        return menu;
    }

    @PutMapping("/setMenu")
    public Menu putMenu(@RequestBody Menu menu){
        return menu;
    }

    @DeleteMapping("/setMenu")
    public Menu deleteMenu(@RequestBody Menu menu){
        return menu;
    }
}
