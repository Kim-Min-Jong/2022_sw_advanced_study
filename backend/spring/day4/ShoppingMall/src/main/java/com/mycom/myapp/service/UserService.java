package com.mycom.myapp.service;

import com.mycom.myapp.dto.UserDto;
import com.mycom.myapp.dto.UserResultDto;

public interface UserService {
    UserResultDto userRegister(UserDto userDto);
    UserDto login(UserDto dto);
}
