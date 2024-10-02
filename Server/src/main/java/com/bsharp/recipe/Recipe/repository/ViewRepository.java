package com.bsharp.recipe.Recipe.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Repository
public abstract class ViewRepository {
    private final JdbcAggregateTemplate jdbcAggregateTemplate;

    public <T> Criteria appendOptionalCriteria(Criteria criteria, String column, T value) {
        return value != null ? criteria.and(column).is(value) : criteria;
    }

    public <T> Criteria appendOptionalCriteria(Criteria criteria, String column, List<T> values) {
        return values != null ? criteria.and(column).in(values) : criteria;
    }

    public <T> Criteria appendOptionalCriteriaGreaterThan(Criteria criteria, String column, T value) {
        return value != null ? criteria.and(column).greaterThan(value) : criteria;
    }

    public <T> Criteria appendOptionalCriteriaLessThan(Criteria criteria, String column, T value) {
        return value != null ? criteria.and(column).lessThan(value) : criteria;
    }

    public <T> Criteria appendOptionalCriteriaGreaterOrEq(Criteria criteria, String column, T value) {
        return value != null ? criteria.and(column).greaterThanOrEquals(value) : criteria;
    }

    public <T> Criteria appendOptionalCriteriaLessOrEq(Criteria criteria, String column, T value) {
        return value != null ? criteria.and(column).lessThanOrEquals(value) : criteria;
    }

    public <T> Page<T> preparePaginatedQuery(Criteria criteria, Pageable pageable, Class<T> clazz) {
        Query query = Query.query(criteria).with(pageable);

        List<T> allData = (List<T>) jdbcAggregateTemplate.findAll(query, clazz);
        long count = jdbcAggregateTemplate.count(Query.query(criteria), clazz);
        return new PageImpl<>(allData, pageable, count);
    }
}
