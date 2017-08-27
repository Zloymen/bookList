package com.perfect.booklist.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * Created by Zloy on 24.08.2017.
 */

@MappedSuperclass
public class IdEntity {
    @Id
    @Column
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
