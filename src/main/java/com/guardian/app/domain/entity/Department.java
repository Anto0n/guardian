package com.guardian.app.domain.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@EqualsAndHashCode
public class Department {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "department")
    private String department;

    @OneToMany(mappedBy = "department")  //fetch = FetchType.EAGER
    private List<User> userList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
