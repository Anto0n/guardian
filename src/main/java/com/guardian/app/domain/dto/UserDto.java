package com.guardian.app.domain.dto;

import com.guardian.app.domain.entity.Citizenship;
import com.guardian.app.domain.entity.City;
import com.guardian.app.domain.entity.Department;
import com.guardian.app.domain.entity.Photo;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UserDto {
    private final int id;
    private final String firsName;
    private final String lastName;
    private final int inn;
    private final CitizenshipDto citizenship;
    private final int birthDate;
    private final CityDto city;
    private final int tel;
    private final List<PhotoDto> photos;
    private final DepartmentDto department;
    private final Date createDate;
    private final Date updateDate;

    private UserDto(int id, String firsName, String lastName, int inn, CitizenshipDto citizenship, int birthDate, CityDto city, int tel, List<PhotoDto> photos, DepartmentDto department, Date createDate, Date updateDate) {
        this.id = id;
        this.firsName = firsName;
        this.lastName = lastName;
        this.inn = inn;
        this.citizenship = citizenship;
        this.birthDate = birthDate;
        this.city = city;
        this.tel = tel;
        this.photos = photos;
        this.department = department;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public static UserDtoBuilder builder() {
        return  new UserDtoBuilder();
    }

    public static class UserDtoBuilder{
        private int id;
        private String firsName;
        private String lastName;
        private int inn;
        private CitizenshipDto citizenship;
        private int birthDate;
        private CityDto city;
        private int tel;
        private List<PhotoDto> photos;
        private DepartmentDto department;
        private Date createDate;
        private Date updateDate;

        public UserDto build() {
            return new UserDto(id, firsName, lastName, inn, citizenship, birthDate, city, tel, photos, department, createDate, updateDate);
        }


        public UserDtoBuilder id(int id) {
            this.id = id;
            return this;
        }

        public UserDtoBuilder firsName(String firsName) {
            this.firsName = firsName;
            return this;
        }

        public UserDtoBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserDtoBuilder inn(int inn) {
            this.inn = inn;
            return this;
        }

        public UserDtoBuilder createDate(Date createDate) {
            this.createDate = createDate;
            return this;
        }

        public UserDtoBuilder updateDate(Date updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public UserDtoBuilder tel(int tel) {
            this.tel = tel;
            return this;
        }

        public UserDtoBuilder birthDate(int birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public UserDtoBuilder citizenship(Citizenship citizenship) {
            CitizenshipDto citizenshipDto = new CitizenshipDto();
            citizenshipDto.setCitizenship(citizenship.getCitizenship());
            this.citizenship = citizenshipDto;
            return this;
        }

        public UserDtoBuilder department(Department department) {
            DepartmentDto departmentDto = new DepartmentDto();
            departmentDto.setDepartment(department.getDepartment());
            this.department = departmentDto;
            return this;
        }

        public UserDtoBuilder photos(List<Photo> photos) {
            this.photos = photos.stream().map(PhotoDto::new).collect(Collectors.toList());
            return this;
        }

        public UserDtoBuilder city(City city) {
            CityDto cityDto = new CityDto();
            cityDto.setCity(city.getCity());
            this.city = cityDto;
            return this;
        }
    }

    public int getId() {
        return id;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getInn() {
        return inn;
    }

    public CitizenshipDto getCitizenship() {
        return citizenship;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public CityDto getCity() {
        return city;
    }

    public int getTel() {
        return tel;
    }

    public List<PhotoDto> getPhotos() {
        return photos;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }
}
