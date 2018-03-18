package com.guardian.app.util;

import com.guardian.app.domain.dto.UserDto;
import com.guardian.app.domain.entity.User;

public class UserUtil {

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firsName(user.getFirsName())
                .lastName(user.getLastName())
                .inn(user.getInn())
                .citizenship(user.getCitizenship())
                .birthDate(user.getBirthDate())
                .city(user.getCity())
                .tel(user.getTel())
                .photos(user.getPhotos())
                .department(user.getDepartment())
                .createDate(user.getCreateDate())
                .updateDate(user.getUpdateDate())
                .build();
    }
}
