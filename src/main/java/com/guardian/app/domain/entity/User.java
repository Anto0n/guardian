package com.guardian.app.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EqualsAndHashCode
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "firstName", columnDefinition = "MEDIUMTEXT")
    private String firstName;
    @Column(name = "lastName", columnDefinition = "MEDIUMTEXT")
    private String lastName;
    private Integer inn;

    @ManyToOne
    @JoinColumn(name = "citizenshipId")
    private Citizenship citizenship;
    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;
    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    @OneToMany(mappedBy = "user")  //fetch = FetchType.EAGER
    private List<Photo> photos;

    private String birthDate;
    private Integer tel;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

}
