package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.ObjectModel;
import com.pragma.powerup.domain.model.UserModel;

import java.util.List;


/*  PERSISTENCIA */
public interface IUserPersistencePort {

    UserModel saveUser(UserModel userModel);

    UserModel getUserByDocumentoIdentidad(Long documentoIdentidad);

    UserModel findOneByEmail(String email);

    UserModel findOneById(long id);

    UserModel findOneByPassword(String password);
    UserModel getUserByEmailAndPassword(String email, String password);
    List<UserModel> getAllUsers();
}