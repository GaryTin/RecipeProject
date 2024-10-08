package com.bsharp.recipe.Recipe.controller;

import com.bsharp.recipe.Recipe.dto.request.AddIngredientRequest;
import com.bsharp.recipe.Recipe.dto.request.IngredientQueryParmas;
import com.bsharp.recipe.Recipe.entity.IngredientEntity;
import com.bsharp.recipe.Recipe.service.IngredientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IngredientController {

    private final IngredientService ingredientService;

    @PostMapping("/ingredient")
    public IngredientEntity addIngredient(@RequestBody AddIngredientRequest request) {
        return ingredientService.addIngredient(request);
    }

    @GetMapping("/ingredient")
    public Page<IngredientEntity> getIngredients(@Valid IngredientQueryParmas parmas,
                                                 Pageable pageable) {
        return ingredientService.getAllIngredients(parmas, pageable);
    }

    @PutMapping("/ingredient/{id}")
    public IngredientEntity updateIngredient(@PathVariable String id, @RequestBody AddIngredientRequest request) {
        return ingredientService.updateIngredient(id, request);
    }

    @DeleteMapping("/ingredient/{id}")
    public void deleteIngredient(@PathVariable String id) {
        ingredientService.deleteIngredient(id);
    }
}
