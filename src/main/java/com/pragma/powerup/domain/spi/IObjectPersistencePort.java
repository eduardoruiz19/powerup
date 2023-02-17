package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.ObjectModel;
import java.util.List;


/*  PUERTO DE PERSISTENCIA */
public interface IObjectPersistencePort {
    ObjectModel saveObject(ObjectModel objectModel);

    List<ObjectModel> getAllObjects();
}