package com.bsharp.recipe.Recipe.dto.request;


import com.bsharp.recipe.Recipe.dto.request.dto.RecipeIngredientBaseClass;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateRecipeRequest {
    String name;
    String description;
    String instructions;
    List<RecipeIngredientBaseClass> ingredients;

}
