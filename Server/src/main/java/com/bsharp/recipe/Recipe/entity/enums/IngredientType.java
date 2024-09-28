package com.bsharp.recipe.Recipe.entity.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum IngredientType {
    MEAT("Meat"),
    VEGETABLE("Vegetable"),
    SPICE("Spice"),
    FRUIT("Fruit");


    String description;
}
