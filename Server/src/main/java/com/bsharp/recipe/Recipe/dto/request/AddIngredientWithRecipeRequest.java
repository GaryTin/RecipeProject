package com.bsharp.recipe.Recipe.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.AssertTrue;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddIngredientWithRecipeRequest extends AddIngredientRequest {
    String recipeId;
    CreateRecipeRequest newRecipeRequest;

    @AssertTrue
    public boolean isRecipeIdOrNewRecipeRequest() {
        boolean recipeIdExist = StringUtils.isNotEmpty(recipeId);
        boolean newRecipeRequestExist = Objects.nonNull(newRecipeRequest);
        return BooleanUtils.xor(new Boolean[]{recipeIdExist, newRecipeRequestExist});
    }

}
