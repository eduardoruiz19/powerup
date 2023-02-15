package com.pragma.powerup.domain.model;

import com.pragma.powerup.domain.exception.DomainException;
import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserModel {
    private Long id;
    private String nombre;
    private String apellido;
    private Long documentoIdentidad;
    private String celular;
    private String email;
    private String clave;

    private RolEntity rol;


    public UserModel() {
    }

    public UserModel(String nombre, String apellido, Long documentoIdentidad, String celular, String email, String clave, RolEntity rol) {
        if(nombre.isEmpty()){
            throw  new DomainException("El Nombre no puede estar Vacío");
        }
        if(apellido.isEmpty()){
            throw  new DomainException("El Apellido no puede estar Vacío");
        }

        this.nombre = nombre;
        this.apellido = apellido;
        this.documentoIdentidad = documentoIdentidad;
        this.celular = celular;
        if(validateEmail()==false){
            throw  new DomainException("Email no Válido");
        }
        this.email = email;
        this.clave = clave;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(Long documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }

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


    public boolean validateEmail() {

        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        // El email a validar
        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            System.out.println("El email ingresado es válido.");
            return true;
        } else {
            System.out.println("El email ingresado es inválido.");
            return false;
        }
    }



}
