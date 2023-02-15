package com.pragma.powerup.domain.model;

import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserModel {
    private Long id;
    private String nombre;
    private String apellido;
    private Long documentoIdentidad;
    private String celular;
    private String email;
    private String clave;

    private RolEntity rol;

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", documentoIdentidad=" + documentoIdentidad +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", clave='" + clave + '\'' +
                ", rol=" + rol +
                '}';
    }

}
