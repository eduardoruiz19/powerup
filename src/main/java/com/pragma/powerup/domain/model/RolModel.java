package com.pragma.powerup.domain.model;

import com.pragma.powerup.infrastructure.out.jpa.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RolModel {

    private Long id;

    private String name;

    private List<UserEntity> listaUsuarios=new ArrayList<>();

}
