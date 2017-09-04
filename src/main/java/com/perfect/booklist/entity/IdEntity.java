package com.perfect.booklist.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Zloy on 24.08.2017.
 */

@MappedSuperclass
public class IdEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @PrePersist
    void preInsert(){
        if(id == null) id = UUID.randomUUID();
    }

    @PreUpdate
    void preUpdate(){
        if(id == null) id = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdEntity)) return false;

        IdEntity idEntity = (IdEntity) o;

        return getId().equals(idEntity.getId());
    }

    @Override
    public int hashCode() {
        return getId() == null ? 0 : getId().hashCode();
    }
}
