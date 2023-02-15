package com.pragma.powerup.domain.api;


import com.pragma.powerup.domain.model.UserModel;

import java.util.List;


/* MÉTODOS QUE NOS INTERESA QUE EXPONGA NUESTRO DOMINIO  */
public interface IUserServicePort {

    void saveObject(UserModel objectModel);

    List<UserModel> getAllObjects();
}