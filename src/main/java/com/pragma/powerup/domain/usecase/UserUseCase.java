package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IUserServicePort;
import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.domain.spi.IUserPersistencePort;

import java.util.List;

public class UserUseCase implements IUserServicePort {

    /* APLICAR INYECCIÓN DE DEPENDENCIAS EN EL CONSTRUCTOR  -  NO USAR AUTOWIRED */
    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort objectPersistencePort) {
        this.userPersistencePort = objectPersistencePort;
    }

    @Override
    public void saveObject(UserModel userModel) {
        userPersistencePort.saveObject(userModel);
    }

    @Override
    public List<UserModel> getAllObjects() {
        return userPersistencePort.getAllObjects();
    }
}