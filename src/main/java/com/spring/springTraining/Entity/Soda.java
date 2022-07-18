package com.spring.springTraining.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
@ToString
public class Soda {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private int menu_id;

    private String name;

    @ManyToOne
    @JoinColumn(name="menu", referencedColumnName = "id")
    private Menu menu;
}
