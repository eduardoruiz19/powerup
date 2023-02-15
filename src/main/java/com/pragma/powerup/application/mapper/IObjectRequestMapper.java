package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.request.ObjectRequestDto;
import com.pragma.powerup.domain.model.ObjectModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/* ReportingPolicy.IGNORE, es para ignorar advertencias */
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IObjectRequestMapper {
    ObjectModel toObject(ObjectRequestDto objectRequestDto);
}
