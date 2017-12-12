package com.paytoplay.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Base class for all business entities, which have id
 * @author v.skapoushchenko
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity implements Serializable{
    public static final int START_SEQ = 100000;

    /**
     * Unique entity identifier
     */
    @Id
//    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    protected Long id;

    public BaseEntity() {
    }

    protected BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isNew(){
        return (this.id == null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;
        if (id == null || that.id == null) {
            return false;
        }

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
