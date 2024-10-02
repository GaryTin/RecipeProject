package com.bsharp.recipe.Recipe.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum TableNameEnum {
    RECIPE("recipe"),
    INGREDIENT("ingredient"),
    RECIPE_INGREDIENT("recipe_ingredient");

    @JsonValue
    String tableName;
}
