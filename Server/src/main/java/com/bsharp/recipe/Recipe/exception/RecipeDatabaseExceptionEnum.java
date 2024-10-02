package com.bsharp.recipe.Recipe.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum RecipeDatabaseExceptionEnum implements RecipeExceptionProvider {
    INGREDIENT_NOT_FOUND("RECIPE-001", "Ingredient not found", "Ingredient not found in the database");

    String code;
    String message;
    String details;
}
