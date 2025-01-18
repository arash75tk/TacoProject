package org.practice.tacoproject.utils;

import org.practice.tacoproject.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import org.practice.tacoproject.entity.Ingredient;


@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    public Ingredient convert(String id) {
        return ingredientRepository.findById(id).orElse(null);
    }

}