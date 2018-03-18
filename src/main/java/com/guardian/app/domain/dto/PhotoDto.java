package com.guardian.app.domain.dto;


import com.guardian.app.domain.entity.Photo;

public class PhotoDto {

    private String reference;


    public PhotoDto(Photo photo) {
        this.reference = photo.getReference();
    }

    public PhotoDto() {
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
