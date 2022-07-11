package com.spring.springTraining.Model;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
public class Menu {
    private String soda;
    private String cake;
}
