package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.ObjectModel;
import com.pragma.powerup.domain.model.UserModel;

import java.util.List;


/*  PERSISTENCIA */
public interface IUserPersistencePort {

    UserModel saveUser(UserModel userModel);

    UserModel getUserByDocumentoIdentidad(Long documentoIdentidad);
    List<UserModel> getAllUsers();
}