package com.pragma.powerup.infrastructure.out.jpa.repository;

import com.pragma.powerup.infrastructure.out.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findBydocumentoIdentidad(Long documentoIdentidad);

    UserEntity findByEmailAndClave(String email, String password);
    UserEntity findOneByEmail(String email);

    UserEntity findOneByClave(String password);
}