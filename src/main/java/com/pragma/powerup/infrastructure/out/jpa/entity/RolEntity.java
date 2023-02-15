package com.pragma.powerup.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rol")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RolEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rol_id", nullable = false)
    private Long id;

    @Column(length = 50)
    private String name;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private List<UserEntity> listaUsuarios=new ArrayList<>();

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", listaUsuarios=" + listaUsuarios +
                '}';
    }
}
