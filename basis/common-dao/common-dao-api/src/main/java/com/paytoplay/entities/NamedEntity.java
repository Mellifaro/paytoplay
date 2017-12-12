package com.paytoplay.entities;

import com.google.common.base.Preconditions;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Superclass for all business entities, which have name
 * @author v.skapoushchenko
 */
@MappedSuperclass
public class NamedEntity extends BaseEntity{

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    public NamedEntity(){}

    public NamedEntity(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
