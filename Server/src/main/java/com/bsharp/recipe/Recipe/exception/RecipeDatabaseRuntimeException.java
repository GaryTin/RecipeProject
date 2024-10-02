package com.bsharp.recipe.Recipe.exception;


import com.bsharp.recipe.Recipe.entity.enums.TableNameEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RecipeDatabaseRuntimeException extends RecipeRuntimeException {

    public RecipeDatabaseRuntimeException(RecipeExceptionProvider recipeExceptionProvider, String dbName, TableNameEnum tableName) {
        super(recipeExceptionProvider);
        this.dbName = dbName;
        this.tableName = tableName;
    }

    String dbName;
    TableNameEnum tableName;
}
