package com.imelnykov.springair.service;

import com.imelnykov.springair.dao.UserDao;
import com.imelnykov.springair.dto.in.UserInDto;
import com.imelnykov.springair.dto.out.UserOutDto;
import com.imelnykov.springair.entities.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserDao userDao;

    public Optional<UserOutDto> getUserById(int id) {
        return userDao.findById(id).map(this::mapUserEntityToUserOutDto);
    }

    public Optional<UserOutDto> getUserByEmail(String email) {
        return userDao.findByEmail(email).map(this::mapUserEntityToUserOutDto);
    }

    public UserOutDto createUser(UserInDto userInDto) {
        User user = mapUserInDtoToUserEntity(userInDto);
        return modelMapper.map(userDao.save(user), UserOutDto.class);
    }

    private UserOutDto mapUserEntityToUserOutDto(User userToMap) {
        return modelMapper.map(userToMap, UserOutDto.class);
    }

    private User mapUserInDtoToUserEntity(UserInDto userInDtoToMap) {
        return modelMapper.map(userInDtoToMap, User.class);
    }
}
