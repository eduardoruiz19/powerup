package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.ObjectModel;
import com.pragma.powerup.domain.model.RolModel;
import com.pragma.powerup.domain.spi.IRolPersistencePort;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.out.jpa.entity.ObjectEntity;
import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IObjectEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IRolEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IRolRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RolJpaAdapter implements IRolPersistencePort {

    private final IRolRepository objectRepository;
    private final IRolEntityMapper objectEntityMapper;


    @Override
    public RolModel saveObject(RolModel objectModel) {
        RolEntity objectEntity = objectRepository.save(objectEntityMapper.toEntity(objectModel));
        return objectEntityMapper.toObjectModel(objectEntity);
    }

    @Override
    public List<RolModel> getAllObjects() {
        List<RolEntity> entityList = objectRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return objectEntityMapper.toRolModelList(entityList);
    }
}