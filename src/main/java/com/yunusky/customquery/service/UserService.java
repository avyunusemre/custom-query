package com.yunusky.customquery.service;

import com.yunusky.customquery.converter.UserConverter;
import com.yunusky.customquery.dto.UserDto;
import com.yunusky.customquery.model.User;
import com.yunusky.customquery.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> getActiveUsersJPA(){
        List<User> activeUsers = userRepository.findByActiveTrue();
        return UserConverter.toDtoList(activeUsers);
    }

    public List<UserDto> getActiveUsersJPQL(){
        List<User> activeUsers = userRepository.findByActiveTrueJPQL();
        return UserConverter.toDtoList(activeUsers);
    }

    public List<UserDto> getActiveUsersNative(){
        List<User> activeUsers = userRepository.findByActiveTrueNative();
        return UserConverter.toDtoList(activeUsers);
    }

    public List<UserDto> getByUsernameAndActive(String username){
        List<User> users = userRepository.findByUsernameAndActiveTrue(username);
        return UserConverter.toDtoList(users);
    }

    public List<UserDto> getByUsernameAndActiveJPQL(String username){
        List<User> users = userRepository.findByUsernameAndActiveTrueJPQL(username);
        return UserConverter.toDtoList(users);
    }

    public List<UserDto> getByUsernameAndActiveNative(String username){
        List<User> users = userRepository.findByUsernameAndActiveTrueNative(username);
        return UserConverter.toDtoList(users);
    }


}
