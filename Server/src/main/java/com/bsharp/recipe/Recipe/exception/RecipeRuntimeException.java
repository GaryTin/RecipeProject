package com.bsharp.recipe.Recipe.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RecipeRuntimeException extends RuntimeException {
    RecipeExceptionProvider recipeExceptionProvider;

    public RecipeRuntimeException(RecipeExceptionProvider recipeExceptionProvider) {
        super(recipeExceptionProvider.getMessage());
        this.recipeExceptionProvider = recipeExceptionProvider;
    }
}


