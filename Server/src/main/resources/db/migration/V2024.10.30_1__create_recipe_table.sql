CREATE TABLE IF NOT EXISTS recipe
(
    id                   varchar(36)  NOT NULL PRIMARY KEY,
    name                 VARCHAR(255) NOT NULL,
    description          TEXT         NULL,
    instructions         TEXT         NOT NULL,
    external_ingredients TEXT         NULL,
    preparation_time     INT          NULL COMMENT 'in SECONDS',
    cook_time            INT          NULL COMMENT 'in SECONDS',
    servings             INT          NOT NULL DEFAULT 1,
    image_url            TEXT         NULL,
    difficulty           INT3         NOT NULL,
    CREATE_DATE_TIME     DATETIME     NULL,
    CREATED_BY           VARCHAR(50)  NULL,
    UPDATE_DATE_TIME     DATETIME     NULL,
    UPDATED_BY           VARCHAR(50)  NULL,
    version              INT          NULL
);