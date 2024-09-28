package com.bsharp.recipe.Recipe.service;

import com.bsharp.recipe.Recipe.dto.request.AddIngredientRequest;
import com.bsharp.recipe.Recipe.entity.IngredientEntity;

public interface IngredientService {
    IngredientEntity addIngredient(AddIngredientRequest request);
}
