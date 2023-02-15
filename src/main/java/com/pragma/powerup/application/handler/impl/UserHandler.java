package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.ObjectRequestDto;
import com.pragma.powerup.application.dto.request.UserRequestDto;
import com.pragma.powerup.application.dto.response.ObjectResponseDto;
import com.pragma.powerup.application.dto.response.UserResponseDto;
import com.pragma.powerup.application.handler.IObjectHandler;
import com.pragma.powerup.application.handler.IUserHandler;
import com.pragma.powerup.application.mapper.IObjectRequestMapper;
import com.pragma.powerup.application.mapper.IObjectResponseMapper;
import com.pragma.powerup.domain.api.IObjectServicePort;
import com.pragma.powerup.domain.model.ObjectModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {
    private final IObjectServicePort userServicePort;
    private final IObjectRequestMapper userRequestMapper;
    private final IObjectResponseMapper userResponseMapper;


    @Override
    public void saveObject(UserRequestDto userRequestDto) {

    }

    @Override
    public List<UserResponseDto> getAllObjects() {
        return null;
    }
}