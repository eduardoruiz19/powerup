package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.domain.spi.IUserPersistencePort;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.exception.UserDocumentoIdentidadAlreadyExistException;
import com.pragma.powerup.infrastructure.out.jpa.entity.UserEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public UserModel saveUser(UserModel userModel) {
        UserEntity userEntityExist=userRepository.findBydocumentoIdentidad(userModel.getDocumentoIdentidad());
        if(userEntityExist==null){
            //userModel.setClave(passwordEncoder.encode(userModel.getClave()));
            UserEntity userEntity = userRepository.save(userEntityMapper.toEntity(userModel));
            return userEntityMapper.toUserModel(userEntity);

        }else{
            throw  new UserDocumentoIdentidadAlreadyExistException();
        }
    }

    @Override
    public UserModel getUserByDocumentoIdentidad(Long documentoIdentidad) {
        UserEntity userEntity =userRepository.findBydocumentoIdentidad(documentoIdentidad);
        return userEntityMapper.toUserModel(userEntity);

    }

    @Override
    public UserModel findOneByEmail(String email) {
        UserEntity userEntity =userRepository.findOneByEmail(email);
        return userEntityMapper.toUserModel(userEntity);

    }

    @Override
    public UserModel findOneByPassword(String password) {
        UserEntity userEntity =userRepository.findOneByClave(password);
        return userEntityMapper.toUserModel(userEntity);

    }

    @Override
    public UserModel getUserByEmailAndPassword(String email, String password) {
        UserEntity userEntity =userRepository.findByEmailAndClave(email,password);
        return userEntityMapper.toUserModel(userEntity);

    }

    @Override
    public List<UserModel> getAllUsers() {
        List<UserEntity> entityList = userRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return userEntityMapper.toUserModelList(entityList);
    }
}