package com.guardian.app.domain.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@EqualsAndHashCode
public class City {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "city")  //fetch = FetchType.EAGER
    private List<User> userList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

}
