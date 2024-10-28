package com.bsharp.recipe.Recipe.dto.request.dto;


import com.bsharp.recipe.Recipe.entity.RecipeIngredientEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SystemRecipeIngredient {
    String ingredientId;

    public RecipeIngredientEntity toEntity(String recipeId) {
        return RecipeIngredientEntity.builder()
                .ingredientId(this.ingredientId)
                .recipeId(recipeId)
                .build();
    }
}
