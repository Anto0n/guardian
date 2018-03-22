package com.guardian.app.domain.dto;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class UserDto {
    private final Integer id;
    private final String firsName;
    private final String lastName;
    private final int inn;
    private final CitizenshipDto citizenship;
    private final Integer birthDate;
    private final CityDto city;
    private final Integer tel;
    private final List<PhotoDto> photos;
    private final DepartmentDto department;
    private final Date createDate;
    private final Date updateDate;

}
