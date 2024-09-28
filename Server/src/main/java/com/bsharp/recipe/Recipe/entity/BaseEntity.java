package com.bsharp.recipe.Recipe.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Column;

import java.time.ZonedDateTime;

@SuperBuilder
@NoArgsConstructor
@Data
public abstract class BaseEntity {
    @Column("CREATED_BY")
    @CreatedBy
    private String createdBy;

    @Column("CREATE_DATE_TIME")
    @CreatedDate
    private ZonedDateTime createDateTime;

    @Column("UPDATED_BY")
    @LastModifiedBy
    private String updatedBy;

    @Column("UPDATE_DATE_TIME")
    @LastModifiedDate
    private ZonedDateTime updateDateTime;

    @Version
    private Integer version; // Represents the version number of the entity. It is used for optimistic locking.
}
