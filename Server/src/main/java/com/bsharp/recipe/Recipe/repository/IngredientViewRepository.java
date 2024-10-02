package com.bsharp.recipe.Recipe.repository;

import com.bsharp.recipe.Recipe.dto.request.IngredientQueryParmas;
import com.bsharp.recipe.Recipe.entity.IngredientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;

@Repository
public class IngredientViewRepository extends ViewRepository {
    public IngredientViewRepository(JdbcAggregateTemplate jdbcAggregateTemplate) {
        super(jdbcAggregateTemplate);
    }

    public Page<IngredientEntity> getIngredients(IngredientQueryParmas parmas, Pageable page) {
        Criteria criteria = Criteria.empty();
        criteria = appendOptionalCriteria(criteria, "id", parmas.getId());
        criteria = appendOptionalCriteria(criteria, "name", parmas.getName());
        criteria = appendOptionalCriteria(criteria, "type", parmas.getType());

        return preparePaginatedQuery(criteria, page, IngredientEntity.class);
    }
}

