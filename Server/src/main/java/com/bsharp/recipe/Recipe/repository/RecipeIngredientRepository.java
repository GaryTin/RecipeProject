package com.bsharp.recipe.Recipe.repository;

import com.bsharp.recipe.Recipe.entity.RecipeEntity;
import com.bsharp.recipe.Recipe.entity.RecipeIngredientEntity;
import org.springframework.data.repository.CrudRepository;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredientEntity, String> {
}
