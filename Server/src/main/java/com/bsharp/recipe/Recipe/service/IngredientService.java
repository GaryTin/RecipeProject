package com.bsharp.recipe.Recipe.service;

import com.bsharp.recipe.Recipe.dto.request.AddAllIngredientRequest;
import com.bsharp.recipe.Recipe.dto.request.AddIngredientRequest;
import com.bsharp.recipe.Recipe.dto.request.IngredientQueryParmas;
import com.bsharp.recipe.Recipe.entity.IngredientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IngredientService {
    IngredientEntity addIngredient(AddIngredientRequest request);

    List<IngredientEntity> addAllIngredients(AddAllIngredientRequest request);

    Page<IngredientEntity> getAllIngredients(IngredientQueryParmas parmas, Pageable pageable);

    IngredientEntity updateIngredient(String id, AddIngredientRequest request);

    void deleteIngredient(String id);
}
