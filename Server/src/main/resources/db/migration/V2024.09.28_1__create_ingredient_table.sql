CREATE TABLE IF NOT EXISTS ingredient
(
    id               varchar(36)  NOT NULL PRIMARY KEY,
    name             VARCHAR(255) NOT NULL,
    description      TEXT         NULL,
    type             VARCHAR(50)  NOT NULL,
    CREATE_DATE_TIME DATETIME     NULL,
    CREATED_BY       VARCHAR(50)  NULL,
    UPDATE_DATE_TIME DATETIME     NULL,
    UPDATED_BY       VARCHAR(50)  NULL,
    version          INT          NULL
);