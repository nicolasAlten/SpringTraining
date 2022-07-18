package com.spring.springTraining.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Data
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int menu_id;

    @Column(name="name")
    private String name;
    private String pass;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id", referencedColumnName="menu_id")
    private Menu menu;

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="menu_id", referencedColumnName="id")
    private Menu menu;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id", referencedColumnName="menu_id")
    private Menu menu;*/

}
