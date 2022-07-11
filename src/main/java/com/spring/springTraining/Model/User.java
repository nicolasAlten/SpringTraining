package com.spring.springTraining.Model;

import lombok.NonNull;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
public class User {
    private long id;
    private String name;
    private String pass;
}
