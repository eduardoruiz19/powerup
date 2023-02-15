package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.IObjectServicePort;
import com.pragma.powerup.domain.api.IRolServicePort;
import com.pragma.powerup.domain.api.IUserServicePort;
import com.pragma.powerup.domain.spi.IObjectPersistencePort;
import com.pragma.powerup.domain.spi.IRolPersistencePort;
import com.pragma.powerup.domain.spi.IUserPersistencePort;
import com.pragma.powerup.domain.usecase.ObjectUseCase;
import com.pragma.powerup.domain.usecase.RolUseCase;
import com.pragma.powerup.domain.usecase.UserUseCase;
import com.pragma.powerup.infrastructure.out.jpa.adapter.ObjectJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.adapter.RolJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.adapter.UserJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IObjectEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IRolEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IObjectRepository;
import com.pragma.powerup.infrastructure.out.jpa.repository.IRolRepository;
import com.pragma.powerup.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IObjectRepository objectRepository;
    private final IObjectEntityMapper objectEntityMapper;

    /*********** USER ***********/
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    /*********** rol ***********/
    private final IRolRepository rolRepository;
    private final IRolEntityMapper rolEntityMapper;

    @Bean
    public IObjectPersistencePort objectPersistencePort() {
        return new ObjectJpaAdapter(objectRepository, objectEntityMapper);
    }

    @Bean
    public IObjectServicePort objectServicePort() {
        return new ObjectUseCase(objectPersistencePort());
    }

    /*********** USER ***********/
    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }

    /*********** ROL ***********/
    @Bean
    public IRolPersistencePort rolPersistencePort() {
        return new RolJpaAdapter(rolRepository, rolEntityMapper);
    }

    @Bean
    public IRolServicePort rolServicePort() {
        return new RolUseCase(rolPersistencePort());
    }



}