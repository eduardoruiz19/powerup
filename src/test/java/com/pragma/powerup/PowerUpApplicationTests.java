package com.pragma.powerup;


import com.pragma.powerup.application.handler.IUserHandler;
import com.pragma.powerup.application.handler.impl.UserHandler;
import com.pragma.powerup.application.security.JWTUtil;
import com.pragma.powerup.domain.api.IUserServicePort;
import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.RolEntity;
import com.pragma.powerup.infrastructure.out.jpa.entity.UserEntity;
import com.pragma.powerup.infrastructure.out.jpa.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootTest
class PowerUpApplicationTests {


    private PasswordEncoder passwordEncoder;
    @Autowired
    IUserRepository userRepository;



    @Test
    void contextLoads() {

        RolEntity rolEntity = new RolEntity();

        UserEntity user= new UserEntity();
        user.setApellido("ADMIN");
        user.setCelular("3001234564");
        user.setNombre("ADMIN");
        user.setClave("abcd");
        String pwd="$2a$10$KRu6tZWHMhuiXNZSzoex9ux8u0z5bgDk4/PsmEbGEWG2bX1Zjp9zq"; //string
        user.setClave(pwd);
        user.setDocumentoIdentidad(111l);
        user.setEmail("admin@e.com");

        user.setRol("ADMIN");

        userRepository.save(user);
        return;

    }

}
