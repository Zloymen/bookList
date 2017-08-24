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
}
