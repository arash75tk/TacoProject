package org.practice.tacoproject.repository;

import org.practice.tacoproject.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository  extends CrudRepository<Ingredient, Long> {
    Optional<Ingredient> findById(String id);
    List<Ingredient> findAll();
}
