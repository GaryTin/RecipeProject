package com.bsharp.recipe.Recipe.service;

import com.bsharp.recipe.Recipe.dto.request.CreateRecipeRequest;
import com.bsharp.recipe.Recipe.entity.RecipeEntity;

public interface RecipeService {

    RecipeEntity createRecipe(CreateRecipeRequest request);
}
