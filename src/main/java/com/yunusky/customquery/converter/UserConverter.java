package com.yunusky.customquery.converter;

import com.yunusky.customquery.dto.UserDto;
import com.yunusky.customquery.model.User;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class UserConverter {
    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.username());
        user.setActive(userDto.active());
        user.setSalary(userDto.salary());
        user.setBirthDate(userDto.birthDate());
        return user;
    }

    public UserDto toDto(User user) {
        return new UserDto(
                user.getUsername(),
                user.isActive(),
                user.getSalary(),
                user.getBirthDate()
        );
    }

    public static List<UserDto> toDtoList(List<User> users) {
        return users.stream().map(UserConverter::toDto).toList();
    }
}
