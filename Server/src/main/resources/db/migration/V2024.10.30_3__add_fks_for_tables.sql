ALTER TABLE ingredient
    ADD COLUMN recipe_id VARCHAR(36) NULL;

ALTER TABLE ingredient
    ADD CONSTRAINT fk_ingredient_recipe_id FOREIGN KEY (recipe_id) REFERENCES recipe (id);

ALTER TABLE recipe_ingredient
    ADD CONSTRAINT fk_ingredient_id FOREIGN KEY (ingredient_id) REFERENCES ingredient (id),
    ADD CONSTRAINT fk_recipe_id FOREIGN KEY (recipe_id) REFERENCES recipe (id);