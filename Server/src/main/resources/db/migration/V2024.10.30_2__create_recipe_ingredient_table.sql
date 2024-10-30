CREATE TABLE IF NOT EXISTS recipe_ingredient
(
    id               varchar(36) NOT NULL PRIMARY KEY,
    recipe_id        varchar(36) NOT NULL,
    ingredient_id    varchar(36) NOT NULL,
    CREATE_DATE_TIME DATETIME    NULL,
    CREATED_BY       VARCHAR(50) NULL,
    UPDATE_DATE_TIME DATETIME    NULL,
    UPDATED_BY       VARCHAR(50) NULL,
    version          INT         NULL
);