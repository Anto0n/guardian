package com.guardian.app.domain.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EqualsAndHashCode
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

    private Integer birthDate;
    private Integer tel;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }

    public Citizenship getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Citizenship citizenship) {
        this.citizenship = citizenship;
    }

    public Integer getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Integer birthDate) {
        this.birthDate = birthDate;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
