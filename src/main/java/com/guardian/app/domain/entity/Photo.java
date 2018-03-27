package com.guardian.app.domain.entity;


import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@EqualsAndHashCode
public class Photo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "reference")
    private String reference;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
