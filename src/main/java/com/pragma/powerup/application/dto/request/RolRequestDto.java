package com.pragma.powerup.application.dto.request;

import com.pragma.powerup.infrastructure.out.jpa.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RolRequestDto {


    private Long id;

    private String name;

}
