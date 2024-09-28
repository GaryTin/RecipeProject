package com.bsharp.recipe.Recipe.controller;

import com.bsharp.recipe.Recipe.dto.request.AddIngredientRequest;
import com.bsharp.recipe.Recipe.entity.IngredientEntity;
import com.bsharp.recipe.Recipe.service.IngredientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IngredientController {

    private final IngredientService ingredientService;

    @PostMapping("/ingredient")
    public IngredientEntity addIngredient(@RequestBody AddIngredientRequest request) {
        return ingredientService.addIngredient(request);
    }
}
