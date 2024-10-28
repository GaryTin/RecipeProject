package com.bsharp.recipe.Recipe.repository;

import com.bsharp.recipe.Recipe.entity.IngredientEntity;
import com.bsharp.recipe.Recipe.entity.RecipeEntity;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<RecipeEntity, String> {
}
