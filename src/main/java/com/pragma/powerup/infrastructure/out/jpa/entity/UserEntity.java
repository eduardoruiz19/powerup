package com.pragma.powerup.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name="nombre", length = 200)
    private String nombre;

    @Column(name="apellido", length = 200)
    private String apellido;

    @Column(name="dni", unique=true)
    private Long documentoIdentidad;

    @Column(name="celular", length = 13)
    private String celular;

    @Column(name="email", unique=true)
    private String email;

    @Column(name="clave")
    private String clave;


    @Column(name="rol")
    private String rol;


    @Override
    public String toString() {
        return "UserEntity{" +
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
