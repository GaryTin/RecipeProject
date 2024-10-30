package com.bsharp.recipe.Recipe.dto.request;


import com.bsharp.recipe.Recipe.dto.request.dto.ExtraRecipeIngredient;
import com.bsharp.recipe.Recipe.dto.request.dto.SystemRecipeIngredient;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateRecipeRequest {
    @NotEmpty
    String name;

    @Nullable
    String description;

    @NotEmpty
    String instructions;

    @NotNull
    Integer preparationTime;

    @NotNull
    Integer cookTime;

    @Builder.Default
    Integer servings = 1;

    @Nullable
    String imageUrl;

    @NotNull
    @Range(min = 1, max = 5)
    Integer difficulty;
    
    List<SystemRecipeIngredient> systemIngredients;
    List<ExtraRecipeIngredient> extraRecipeIngredients;

}
