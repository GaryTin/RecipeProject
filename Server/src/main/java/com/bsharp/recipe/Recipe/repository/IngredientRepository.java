package com.bsharp.recipe.Recipe.repository;

import com.bsharp.recipe.Recipe.entity.IngredientEntity;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<IngredientEntity, String> {
}
