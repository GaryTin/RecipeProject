package com.bsharp.recipe.Recipe.service.Impl;

import com.bsharp.recipe.Recipe.dto.request.IngredientQueryParmas;
import com.bsharp.recipe.Recipe.entity.IngredientEntity;
import com.bsharp.recipe.Recipe.entity.enums.TableNameEnum;
import com.bsharp.recipe.Recipe.exception.RecipeDatabaseExceptionEnum;
import com.bsharp.recipe.Recipe.exception.RecipeDatabaseRuntimeException;
import com.bsharp.recipe.Recipe.repository.IngredientRepository;
import com.bsharp.recipe.Recipe.repository.IngredientViewRepository;
import com.bsharp.recipe.Recipe.service.IngredientQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IngredientQueryServiceImpl implements IngredientQueryService {

    private final IngredientRepository ingredientRepository;
    private final IngredientViewRepository ingredientViewRepository;

    @Override
    public Page<IngredientEntity> getAllIngredients(IngredientQueryParmas parmas, Pageable pageable) {
        return ingredientViewRepository.getIngredients(parmas, pageable);
    }

    @Override
    public IngredientEntity getIngredient(String id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new RecipeDatabaseRuntimeException(RecipeDatabaseExceptionEnum.INGREDIENT_NOT_FOUND, "db_recipe", TableNameEnum.INGREDIENT));
    }


}
