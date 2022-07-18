package com.spring.springTraining.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private int soda_id;

    @Column(name="cake")
    private String cake;

    @OneToMany
    @JoinColumn(name="menu_id", referencedColumnName = "id")
    @OrderBy("name")
    @JsonIgnore
    private List<Soda> soda = new ArrayList<>();
}
