package com.bsharp.recipe.Recipe.controller;

import com.bsharp.recipe.Recipe.dto.request.CreateRecipeRequest;
import com.bsharp.recipe.Recipe.entity.RecipeEntity;
import com.bsharp.recipe.Recipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping("/recipe")
    public RecipeEntity createRecipe(@RequestBody CreateRecipeRequest request) {
        return recipeService.createRecipe(request);
    }

}
