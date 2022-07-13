package com.spring.springTraining.Service.Interfaces;

import com.spring.springTraining.Model.Menu;
import org.springframework.web.bind.annotation.*;

public interface MenuService {
    String getMenu();
    Menu getMenuById(int id);
    Menu getMenuByIdAndByUser(String soda, String cake);
    Menu setMenu(Menu menu);
    Menu putMenu(Menu menu);
    Menu deleteMenu(Menu menu);
}
