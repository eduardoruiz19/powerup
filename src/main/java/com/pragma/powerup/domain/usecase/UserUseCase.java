package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IUserServicePort;
import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.domain.spi.IUserPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.List;

public class UserUseCase implements IUserServicePort {

    /* APLICAR INYECCIÓN DE DEPENDENCIAS EN EL CONSTRUCTOR  -  NO USAR AUTOWIRED */
    private final IUserPersistencePort userPersistencePort;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
        //this.encrypt = encrypt;
    }

    @Override
    public void saveUser(UserModel userModel) {


        userModel.setClave(passwordEncoder.encode(userModel.getClave()));

        userPersistencePort.saveUser(userModel);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userPersistencePort.getAllUsers();
    }


    public UserModel getUserByEmail(String email) {
        return userPersistencePort.findOneByEmail(email);
    }

    @Override
    public UserModel getUserByiD(long id) {
        return userPersistencePort.findOneById(id);
    }

}