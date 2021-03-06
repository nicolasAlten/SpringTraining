package com.spring.springTraining.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.spring.springTraining.Controller.UserController;
import com.spring.springTraining.Entity.UserEntity;
import com.spring.springTraining.Service.Interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @PersistenceContext
    private EntityManager entityManager;

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    //========================== GET METHODS  =========================================
    @Override
    public List<UserEntity> getUsers() {
       /* logger.info("Get First Result =======" + entityManager.createQuery("SELECT u FROM UserEntity u ORDER BY u.id DESC", UserEntity.class)
                .setMaxResults(10)
                .setFirstResult(page*10));*/

        logger.info("Get Single Result =======" + entityManager.createQuery("SELECT u FROM UserEntity u ORDER BY u.id DESC", UserEntity.class)
                .getResultList().stream().findFirst().orElse(null));

        return entityManager.createQuery("SELECT u FROM UserEntity u ORDER BY u.id DESC", UserEntity.class)
                .getResultList();
    }

    @Override
    public UserEntity getUserById(int id) {
        return entityManager.find(UserEntity.class, id);
        /*TypedQuery<UserEntity> query = entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.id LIKE :userId", UserEntity.class);
        query.setParameter("userId", id);
        return query.getSingleResult();*/
    }

    //============================= POST ==================================

    @Override
    @Transactional
    public UserEntity postUser(UserEntity user) {
        logger.info("=============== user: "+ user.toString());
        entityManager.merge(user);
        return user;
    }

    @Override
    @Transactional
    public JsonNode postJsonUser(JsonNode jsonNode) {
        String name = jsonNode.get("name").asText();
        String pass = jsonNode.get("pass").asText();
        return jsonNode;
    }

    @Override
    @Transactional
    public String deleteUser(int id) {
        UserEntity userInDB = entityManager.find(UserEntity.class, id);
        entityManager.remove(userInDB);
        return "user deleted";
    }

    @Override
    @Transactional
    public UserEntity updateUser(UserEntity user) {
        //return entityManager.merge(user);
        UserEntity userInDB = entityManager.find(UserEntity.class, user.getId());
        logger.info("=========== user object: " + userInDB.toString());
        userInDB.setName(user.getName());
        userInDB.setPass(user.getPass());
        entityManager.persist(userInDB);
        return user;
    }


}
