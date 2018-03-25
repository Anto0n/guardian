package com.guardian.app.util;

import java.util.function.Function;
import java.util.stream.Collectors;

import com.guardian.app.domain.dto.CitizenshipDto;
import com.guardian.app.domain.dto.CityDto;
import com.guardian.app.domain.dto.DepartmentDto;
import com.guardian.app.domain.dto.PhotoDto;
import com.guardian.app.domain.dto.UserDto;
import com.guardian.app.domain.entity.Citizenship;
import com.guardian.app.domain.entity.City;
import com.guardian.app.domain.entity.Department;
import com.guardian.app.domain.entity.Photo;
import com.guardian.app.domain.entity.User;

public class DtoUtil {

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .inn(user.getInn())
                .citizenship(CitizenshipDto.builder()
                        .citizenship(applyIfNotNull(user.getCitizenship(), Citizenship::getCitizenship))
                        .build())
                .birthDate(user.getBirthDate())
                .city(CityDto.builder()
                        .city(applyIfNotNull(user.getCity(), City::getCity))
                        .build())
                .tel(user.getTel())
                .photos(applyIfNotNull(user.getPhotos(), photos ->  photos.stream()
                        .map(p -> PhotoDto.builder().reference(p.getReference()).build())
                        .collect(Collectors.toList())))
                .department(DepartmentDto.builder()
                        .department(applyIfNotNull(user.getDepartment(), Department::getDepartment))
                        .build())
                .createDate(user.getCreateDate())
                .updateDate(user.getUpdateDate())
                .build();
    }

    public static CityDto toDto(City city) {
        return CityDto.builder().city(city.getCity()).build();
    }

    public static DepartmentDto toDto(Department department) {
        return DepartmentDto.builder().department(department.getDepartment()).build();
    }

    public static PhotoDto toDto(Photo photo) {
        return PhotoDto.builder().reference(photo.getReference()).build();
    }

    public static CitizenshipDto toDto(Citizenship citizenship) {
        return CitizenshipDto.builder().citizenship(citizenship.getCitizenship()).build();
    }

    /**
     * Apply function to parameter if parameter is not null
     * @param t is object to explore
     * @param function what has to be applied to parameter t
     * @param <T> generic type of investigated object
     * @param <O> result of function allying on object
     * @return null in case object is null, else apply a function
     */
    public static <T, O> O applyIfNotNull(T t, Function<T, O> function) {
        return t !=null
                ? function.apply(t)
                : null;
    }

    public static <T, O> Boolean applyIfNotNullOrTrue(T t, Function<T, Boolean> function) {
        return t !=null
                ? function.apply(t)
                : true;
    }
}
