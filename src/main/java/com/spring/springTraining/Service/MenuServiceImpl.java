package com.spring.springTraining.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.spring.springTraining.Entity.Menu;
import com.spring.springTraining.Entity.UserEntity;
import com.spring.springTraining.Service.Interfaces.MenuService;
import com.spring.springTraining.SpringTrainingApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @PersistenceContext
    private EntityManager entityManager;

    private static Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Override
    public List<Menu> getMenu() {
        return entityManager.createQuery("SELECT m FROM Menu m ORDER BY m.id DESC", Menu.class)
                .getResultList();
    }

    @Override
    public Menu getMenuById(int id) {
         /*return entityManager.createQuery("SELECT menu FROM Menu m WHERE m.id LIKE :id", Menu.class)
                 .setParameter("id", id)
                 .getSingleResult();*/

        return entityManager.find(Menu.class, id);
    }

    @Override
    public Menu getMenuByIdAndByUser(String soda, String cake) {
        return null;
    }


    @Override
    @Transactional
    public JsonNode postJsonMenu(JsonNode jsonNode) {
        String name = jsonNode.get("name").asText();
        String pass = jsonNode.get("pass").asText();
        return jsonNode;
    }

    @Override
    @Transactional
    public Menu setMenu(Menu menu) {
        entityManager.persist(menu);
        return menu;
        //return entityManager.merge(menu);
    }

    @Override
    public Menu putMenu(Menu menu) {
        //logger.info("Inside the service for put menu function");
        //entityManager.merge(menu);
        //return menu;

        Menu menuFromDB = entityManager.find(Menu.class, menu.getId());
        menuFromDB.setCake(menu.getCake());
        entityManager.persist(menuFromDB);
        entityManager.merge(menuFromDB);
        return menu;
    }

    @Override
    public Menu deleteMenu(Menu menu) {
        //logger.info("Inside the service for delete menu function");
        Menu menuFromDB = entityManager.find(Menu.class, menu);
        entityManager.remove(menuFromDB);
        return menu;
    }
}
