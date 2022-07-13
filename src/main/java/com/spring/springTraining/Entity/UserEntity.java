package com.spring.springTraining.Entity;

import lombok.Data;
import lombok.ToString;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@ToString
public class UserEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name="name")
    private String name;
    private String pass;
}
