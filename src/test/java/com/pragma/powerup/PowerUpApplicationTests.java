package com.pragma.powerup;


import com.pragma.powerup.application.handler.impl.UserHandler;
import com.pragma.powerup.domain.api.IUserServicePort;
import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;
import com.pragma.powerup.infrastructure.out.jpa.entity.UserEntity;
import com.pragma.powerup.infrastructure.out.jpa.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PowerUpApplicationTests {

    @Autowired
    IUserRepository userRepository;



    @Test
    void contextLoads() {
        RolEntity rolEntity = new RolEntity();
        rolEntity.setId(1L); // admin
        UserEntity user= new UserEntity();
        user.setApellido("aaaa");
        user.setNombre("bbbb");
        user.setClave("abcd");
        user.setRol("ADMIN");

        userRepository.save(user);
        return;

    }

}
