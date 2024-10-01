package com.bsharp.recipe.Recipe.service.Impl;

import com.bsharp.recipe.Recipe.dto.request.AddAllIngredientRequest;
import com.bsharp.recipe.Recipe.dto.request.AddIngredientRequest;
import com.bsharp.recipe.Recipe.entity.IngredientEntity;
import com.bsharp.recipe.Recipe.repository.IngredientRepository;
import com.bsharp.recipe.Recipe.service.IngredientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Override
    public IngredientEntity addIngredient(AddIngredientRequest request) {
        return ingredientRepository.save(IngredientEntity.builder()
                .id(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .type(request.getType())
                .build());
    }

    @Override
    @Transactional
    public List<IngredientEntity> addAllIngredients(AddAllIngredientRequest request) {
        List<AddIngredientRequest> ingredients = request.getIngredients();
        return ingredients.stream()
                .map(ingredient -> (IngredientEntity) ingredientRepository.save(IngredientEntity.builder()
                        .id(UUID.randomUUID().toString())
                        .name(ingredient.getName())
                        .description(ingredient.getDescription())
                        .type(ingredient.getType())
                        .build()))
                .toList();
    }
}
