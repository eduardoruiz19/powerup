package com.pragma.powerup.unitaria;

import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;
import com.pragma.powerup.infrastructure.out.jpa.entity.UserEntity;
import com.pragma.powerup.infrastructure.out.jpa.repository.IUserRepository;

import org.junit.Assert;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserEntityTest {
    @Autowired
    IUserRepository userRepository;

    @Test
    public void CreateUserEntity(){

        RolEntity rolEntity = new RolEntity();
        rolEntity.setId(1L); // admin
        UserEntity user= new UserEntity();
        user.setApellido("aaaa");
        user.setNombre("bbbb");
        user.setClave("abcd");
        user.setRol(rolEntity);

        userRepository.save(user);
        UserEntity user2=userRepository.findByNombre(user.getNombre());
        assertNotNull(user2);

    }

}

