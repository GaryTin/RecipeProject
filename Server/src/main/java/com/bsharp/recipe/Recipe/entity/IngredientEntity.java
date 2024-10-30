package com.bsharp.recipe.Recipe.entity;

import com.bsharp.recipe.Recipe.entity.enums.IngredientType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table("ingredient")
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class IngredientEntity extends BaseEntity {
    @Id
    String id;
    String name; // Name of the ingredient, need to be unique
    String description;
    IngredientType type;
    String recipeId; // Recipe id for recipe of this ingredient
}
