package com.spring.springTraining.Model;

import lombok.NonNull;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Table;

@Component
@Data
@ToString
@Table(name="user_entity")
public class User {
    private long id;
    private String name;
    private String pass;
}
