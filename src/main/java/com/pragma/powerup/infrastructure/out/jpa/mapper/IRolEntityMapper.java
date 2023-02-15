package com.pragma.powerup.infrastructure.out.jpa.mapper;

import com.pragma.powerup.domain.model.ObjectModel;
import com.pragma.powerup.domain.model.RolModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IRolEntityMapper {

    RolEntity toEntity(RolModel rolModel);
    RolModel toObjectModel(RolEntity rolEntity);
    List<RolModel> toRolModelList(List<RolEntity> rolEntityList);
}