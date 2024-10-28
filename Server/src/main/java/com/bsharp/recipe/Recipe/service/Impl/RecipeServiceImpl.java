package com.bsharp.recipe.Recipe.service.Impl;

import com.bsharp.recipe.Recipe.dto.request.CreateRecipeRequest;
import com.bsharp.recipe.Recipe.dto.request.dto.SystemRecipeIngredient;
import com.bsharp.recipe.Recipe.entity.RecipeEntity;
import com.bsharp.recipe.Recipe.repository.RecipeIngredientRepository;
import com.bsharp.recipe.Recipe.repository.RecipeRepository;
import com.bsharp.recipe.Recipe.service.RecipeService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RecipeServiceImpl implements RecipeService {

    private final IngredientServiceImpl ingredientService;
    private final RecipeRepository recipeRepository;
    private final RecipeIngredientRepository recipeIngredientRepository;
    private final ObjectMapper objectMapper;

    public RecipeEntity createRecipe(CreateRecipeRequest request) {
        validateSystemIngredient(request.getSystemIngredients());
        return saveRecipe(request);
    }

    private RecipeEntity saveRecipe(CreateRecipeRequest request){
        JsonNode extraRecipeIngredients = objectMapper.convertValue(request.getExtraRecipeIngredients(), JsonNode.class);

        RecipeEntity newRecipe = recipeRepository.save(RecipeEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .instructions(request.getInstructions())
                .externalIngredients(extraRecipeIngredients.toString())
                .build());

        request.getSystemIngredients()
                .forEach(systemIngredient -> recipeIngredientRepository.save(systemIngredient.toEntity(newRecipe.getId())));

        return newRecipe;

    }

    private void validateSystemIngredient(List<SystemRecipeIngredient> requestSystemIngredients) {
       requestSystemIngredients.forEach(requestSystemIngredient -> ingredientService.getIngredient(requestSystemIngredient.getIngredientId()));
    }

}
