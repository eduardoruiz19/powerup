package com.pragma.powerup.application.security;

import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.domain.spi.IUserPersistencePort;
import com.pragma.powerup.domain.usecase.UserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterUserDetailsService  implements UserDetailsService {


    @Autowired
    private IUserPersistencePort userPersistencePort;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //System.out.println("* * USERNAME:" + username);
        UserModel userModel = userPersistencePort.findOneByEmail(username);
        if (userModel != null) {
            //System.err.println(userModel);
            return new User(userModel.getEmail(), userModel.getClave(), new ArrayList<>());
        }

        //System.err.println(userModel);
        //return new User("root","{noop}root",new ArrayList<>());
        String claveCrypt = "$2a$12$8c60xYTZghVg4E5znC/Ic.q0wtxYcwTWP..2sV/J2zz/EFVb/xoFO";
        //return new User("root",claveCrypt,new ArrayList<>());
        //return  new User("root",claveCrypt,new ArrayList<>());
        throw new UsernameNotFoundException("Username Not Found");
    }


}
