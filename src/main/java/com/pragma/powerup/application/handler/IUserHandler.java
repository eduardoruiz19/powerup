package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.ObjectRequestDto;
import com.pragma.powerup.application.dto.request.UserRequestDto;
import com.pragma.powerup.application.dto.response.ObjectResponseDto;
import com.pragma.powerup.application.dto.response.UserResponseDto;
import com.pragma.powerup.application.mapper.IObjectRequestMapper;
import com.pragma.powerup.application.mapper.IObjectResponseMapper;
import com.pragma.powerup.application.mapper.IUserRequestMapper;
import com.pragma.powerup.application.mapper.IUserResponseMapper;
import com.pragma.powerup.domain.api.IObjectServicePort;
import com.pragma.powerup.domain.api.IUserServicePort;

import java.util.List;

public interface IUserHandler {

    void saveObject(UserRequestDto userRequestDto);

    List<UserResponseDto> getAllObjects();
}