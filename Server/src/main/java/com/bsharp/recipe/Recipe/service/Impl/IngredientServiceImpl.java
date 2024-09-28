package com.bsharp.recipe.Recipe.service.Impl;

import com.bsharp.recipe.Recipe.dto.request.AddIngredientRequest;
import com.bsharp.recipe.Recipe.entity.IngredientEntity;
import com.bsharp.recipe.Recipe.repository.IngredientRepository;
import com.bsharp.recipe.Recipe.service.IngredientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
