package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.response.ObjectResponseDto;
import com.pragma.powerup.application.dto.response.RolResponseDto;
import com.pragma.powerup.domain.model.ObjectModel;
import com.pragma.powerup.domain.model.RolModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRolResponseMapper {
    RolResponseDto toResponse(RolModel rolModel);

    List<RolResponseDto> toResponseList(List<RolModel> rolModelList);
}
