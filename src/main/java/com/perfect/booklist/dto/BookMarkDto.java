package com.perfect.booklist.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

/**
 * Created by Zloy on 03.09.2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookMarkDto {
    private Boolean favorite;
    private UUID id;

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BookMarkDto(Boolean favorite, UUID id) {
        this.favorite = favorite;
        this.id = id;
    }
}
