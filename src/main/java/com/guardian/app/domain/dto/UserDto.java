package com.guardian.app.domain.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class UserDto {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final Integer inn;
    private final CitizenshipDto citizenship;
    private final String birthDate;
    private final CityDto city;
    private final Integer tel;
    private final List<PhotoDto> photos;
    private final DepartmentDto department;
    private final Date createDate;
    private final Date updateDate;

}

