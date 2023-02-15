package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.ObjectModel;
import com.pragma.powerup.domain.model.RolModel;

import java.util.List;


/* MÉTODOS QUE NOS INTERESA QUE EXPONGA NUESTRO DOMINIO  */
public interface IRolServicePort {

    void saveObject(RolModel objectModel);

    List<RolModel> getAllObjects();
}