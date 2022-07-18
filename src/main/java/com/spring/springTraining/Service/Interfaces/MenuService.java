package com.spring.springTraining.Service.Interfaces;

import com.fasterxml.jackson.databind.JsonNode;
import com.spring.springTraining.Entity.Menu;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface MenuService {
    List<Menu>  getMenu();
    Menu getMenuById(int id);
    Menu getMenuByIdAndByUser(String soda, String cake);
    JsonNode postJsonMenu(JsonNode jsonNode);
    Menu setMenu(Menu menu);
    Menu putMenu(Menu menu);
    Menu deleteMenu(Menu menu);
}
