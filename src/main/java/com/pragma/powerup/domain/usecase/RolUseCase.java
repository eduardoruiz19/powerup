package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IObjectServicePort;
import com.pragma.powerup.domain.api.IRolServicePort;
import com.pragma.powerup.domain.model.ObjectModel;
import com.pragma.powerup.domain.model.RolModel;
import com.pragma.powerup.domain.spi.IObjectPersistencePort;
import com.pragma.powerup.domain.spi.IRolPersistencePort;

import java.util.List;

public class RolUseCase implements IRolServicePort {

    /* APLICAR INYECCIÓN DE DEPENDENCIAS EN EL CONSTRUCTOR  -  NO USAR AUTOWIRED */
    private final IRolPersistencePort rolPersistencePort;

    public RolUseCase(IRolPersistencePort rolPersistencePort) {
        this.rolPersistencePort = rolPersistencePort;
    }

    @Override
    public void saveObject(RolModel rolModel) {
        rolPersistencePort.saveObject(rolModel);
    }

    @Override
    public List<RolModel> getAllObjects() {
        return rolPersistencePort.getAllObjects();
    }
}