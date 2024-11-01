package com.bsharp.recipe.Recipe.service.Impl;

import com.bsharp.recipe.Recipe.dto.request.AddAllIngredientRequest;
import com.bsharp.recipe.Recipe.dto.request.AddIngredientRequest;
import com.bsharp.recipe.Recipe.dto.request.IngredientQueryParmas;
import com.bsharp.recipe.Recipe.entity.IngredientEntity;
import com.bsharp.recipe.Recipe.entity.enums.TableNameEnum;
import com.bsharp.recipe.Recipe.exception.RecipeDatabaseExceptionEnum;
import com.bsharp.recipe.Recipe.exception.RecipeDatabaseRuntimeException;
import com.bsharp.recipe.Recipe.repository.IngredientRepository;
import com.bsharp.recipe.Recipe.repository.IngredientViewRepository;
import com.bsharp.recipe.Recipe.service.IngredientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientViewRepository ingredientViewRepository;

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

    @Override
    public Page<IngredientEntity> getAllIngredients(IngredientQueryParmas parmas, Pageable pageable) {
        return ingredientViewRepository.getIngredients(parmas, pageable);
    }

    @Override
    public IngredientEntity getIngredient(String id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new RecipeDatabaseRuntimeException(RecipeDatabaseExceptionEnum.INGREDIENT_NOT_FOUND, "db_recipe", TableNameEnum.INGREDIENT));
    }

    @Override
    public IngredientEntity updateIngredient(String id, AddIngredientRequest request) {
        IngredientEntity ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new RecipeDatabaseRuntimeException(RecipeDatabaseExceptionEnum.INGREDIENT_NOT_FOUND, "db_recipe", TableNameEnum.INGREDIENT));
        ingredient.setName(request.getName());
        ingredient.setDescription(request.getDescription());
        ingredient.setType(request.getType());
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteIngredient(String id) {
        ingredientRepository.deleteById(id);
    }
}
