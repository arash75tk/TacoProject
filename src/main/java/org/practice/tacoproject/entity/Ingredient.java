package org.practice.tacoproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ingredient {
    @Id
    private String id;
    private String name;
    private Type type;


    public enum Type {
        WRAP, PROTEIN, VEGGIES , CHEESE , SAUCE
    }
}
