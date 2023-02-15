package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.ObjectRequestDto;
import com.pragma.powerup.application.dto.request.RolRequestDto;
import com.pragma.powerup.application.dto.response.ObjectResponseDto;
import com.pragma.powerup.application.dto.response.RolResponseDto;
import com.pragma.powerup.application.handler.IObjectHandler;
import com.pragma.powerup.application.handler.IRolHandler;
import com.pragma.powerup.application.mapper.IObjectRequestMapper;
import com.pragma.powerup.application.mapper.IObjectResponseMapper;
import com.pragma.powerup.application.mapper.IRolRequestMapper;
import com.pragma.powerup.application.mapper.IRolResponseMapper;
import com.pragma.powerup.domain.api.IObjectServicePort;
import com.pragma.powerup.domain.api.IRolServicePort;
import com.pragma.powerup.domain.model.ObjectModel;
import com.pragma.powerup.domain.model.RolModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RolHandler implements IRolHandler {
    private final IRolServicePort rolServicePort;
    private final IRolRequestMapper rolRequestMapper;
    private final IRolResponseMapper rolResponseMapper;



    @Override
    public void saveObject(RolRequestDto rolRequestDto) {
        RolModel objectModel = rolRequestMapper.toObject(rolRequestDto);
        rolServicePort.saveObject(objectModel);

    }

    @Override
    public List<RolResponseDto> getAllObjects() {

        return rolResponseMapper.toResponseList(rolServicePort.getAllObjects());
    }
}