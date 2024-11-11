package com.bsharp.recipe.Recipe.service;

import com.bsharp.recipe.Recipe.dto.request.AddAllIngredientRequest;
import com.bsharp.recipe.Recipe.dto.request.AddIngredientRequest;
import com.bsharp.recipe.Recipe.dto.request.AddIngredientsWithReceiptRequest;
import com.bsharp.recipe.Recipe.entity.IngredientEntity;

import java.util.List;

public interface IngredientService {
    IngredientEntity addIngredient(AddIngredientRequest request);

    List<IngredientEntity> addAllIngredients(AddAllIngredientRequest request);

    List<IngredientEntity> addIngredientsWithRecipe(AddIngredientsWithReceiptRequest request);

    IngredientEntity updateIngredient(String id, AddIngredientRequest request);

    void deleteIngredient(String id);
}
