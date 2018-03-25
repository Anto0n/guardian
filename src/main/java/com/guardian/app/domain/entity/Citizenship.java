package com.guardian.app.domain.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@EqualsAndHashCode
public class Citizenship {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "citizenship")
    private String citizenship;

    @OneToMany(mappedBy = "citizenship")  //fetch = FetchType.EAGER
    private List<User> userList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }
}
