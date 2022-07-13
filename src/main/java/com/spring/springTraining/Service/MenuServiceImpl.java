package com.spring.springTraining.Service;

import com.spring.springTraining.Model.Menu;
import com.spring.springTraining.Service.Interfaces.MenuService;
import com.spring.springTraining.SpringTrainingApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {
    private static Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Override
    public String getMenu() {
        logger.info("Inside the service for get menu function");
        return "Some random string from the service";
    }

    @Override
    public Menu getMenuById(int id) {
        return null;
    }

    @Override
    public Menu getMenuByIdAndByUser(String soda, String cake) {
        return null;
    }

    @Override
    public Menu setMenu(Menu menu) {
        logger.info("Inside the service for set menu function");
        return menu;
    }

    @Override
    public Menu putMenu(Menu menu) {
        logger.info("Inside the service for put menu function");
        return menu;
    }

    @Override
    public Menu deleteMenu(Menu menu) {
        logger.info("Inside the service for delete menu function");
        return menu;
    }
}
