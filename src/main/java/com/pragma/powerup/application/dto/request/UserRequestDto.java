package com.pragma.powerup.application.dto.request;

import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;
import lombok.Getter;
import lombok.Setter;

/* COMUNICACIONES O RESPUESTAS CON EL EXTERIOR PARA NO EXPONER LOS OBJECTMODEL */
@Getter
@Setter
public class UserRequestDto {
    private Long id;
    private String nombre;
    private String apellido;
    private Long documentoIdentidad;
    private String celular;
    private String email;
    private String clave;

    private RolEntity rol;

}
