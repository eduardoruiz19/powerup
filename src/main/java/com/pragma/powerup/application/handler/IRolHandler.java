package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.ObjectRequestDto;
import com.pragma.powerup.application.dto.request.RolRequestDto;
import com.pragma.powerup.application.dto.response.ObjectResponseDto;
import com.pragma.powerup.application.dto.response.RolResponseDto;

import java.util.List;

public interface IRolHandler {

    void saveObject(RolRequestDto rolRequestDto);

    List<RolResponseDto> getAllObjects();
}