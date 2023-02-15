package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.ObjectModel;
import com.pragma.powerup.domain.model.RolModel;

import java.util.List;


/*  PERSISTENCIA */
public interface IRolPersistencePort {
    RolModel saveObject(RolModel rolModel);

    List<RolModel> getAllObjects();
}