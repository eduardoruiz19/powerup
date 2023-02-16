package com.pragma.powerup.application.dto.response;

import com.pragma.powerup.domain.model.RolModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private Long id;
    private String nombre;
    private String apellido;
    private Long documentoIdentidad;
    private String celular;
    private String email;
    private String clave;
    private String rol;
}
