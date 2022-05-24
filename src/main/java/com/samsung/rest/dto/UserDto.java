package com.samsung.rest.dto;

import com.samsung.domain.Author;
import com.samsung.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private int id;

    private String login;

    private String password;

    private int totalHours;


    public static UserDto toDto(User user){

        return new UserDto(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getTotalHours()
        );
    }

    public static User toDomainObject(UserDto userDto){

        return new User(
                userDto.getId(),
                userDto.getLogin(),
                userDto.getPassword(),
                userDto.getTotalHours()
        );
    }
}
