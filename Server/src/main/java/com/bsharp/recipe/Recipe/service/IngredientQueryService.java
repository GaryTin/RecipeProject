package com.bsharp.recipe.Recipe.service;

import com.bsharp.recipe.Recipe.dto.request.IngredientQueryParmas;
import com.bsharp.recipe.Recipe.entity.IngredientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IngredientQueryService {


    Page<IngredientEntity> getAllIngredients(IngredientQueryParmas parmas, Pageable pageable);


    IngredientEntity getIngredient(String id);

}
